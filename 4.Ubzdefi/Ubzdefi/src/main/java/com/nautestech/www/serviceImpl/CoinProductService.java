package com.nautestech.www.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.CoinMapper;
import com.nautestech.www.model.CoinProduct;

import utils.RequestList;

@Service
public class CoinProductService {

	private final CoinMapper coinMapper;

	public CoinProductService(CoinMapper coinMapper) {
		this.coinMapper = coinMapper;
	}

	public Page<CoinProduct> getCoinProduct(CoinProduct coin, Pageable pageable, LocalDate start, LocalDate end) {
		RequestList<?> requestList = RequestList.builder().data(coin).pageable(pageable).start(start).end(end).build();

		List<CoinProduct> content = coinMapper.getCoinProduct(requestList);
		int total = coinMapper.getCoinProductCount(requestList);

		return new PageImpl<CoinProduct>(content, pageable, total);
	}
}