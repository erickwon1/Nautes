package com.nautestech.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.CoinProduct;

import utils.RequestList;

@Mapper
public interface CoinMapper {
	public List<CoinProduct> getCoinProduct(RequestList<?> requestList);

	public int getCoinProductCount(RequestList<?> requestList);
}
