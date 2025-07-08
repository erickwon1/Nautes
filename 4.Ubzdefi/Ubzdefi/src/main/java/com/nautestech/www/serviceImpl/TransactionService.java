package com.nautestech.www.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.TransactionMapper;
import com.nautestech.www.model.TransactionRecord;

import lombok.RequiredArgsConstructor;
import utils.RequestList;

@Service
@RequiredArgsConstructor
public class TransactionService {
	private final TransactionMapper transactionMapper;

	public Page<TransactionRecord> getTransactionRecord(TransactionRecord transaction, Pageable pageable,
			LocalDate start, LocalDate end) {
		RequestList<?> requestList = RequestList.builder().data(transaction).pageable(pageable).start(start).end(end)
				.build();

		List<TransactionRecord> content = transactionMapper.getTransactionRecord(requestList);
		int total = transactionMapper.getTransactionRecordCount(requestList);

		return new PageImpl<TransactionRecord>(content, pageable, total);
	}
}
