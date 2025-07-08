package com.nautestech.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nautestech.www.model.ProxyChkList;

import utils.RequestList;

@Mapper
public interface ProxyChkListMapper {
	public List<ProxyChkList> getProxyChkList(RequestList<?> requestList);

	public int getProxyChkListCount(RequestList<?> requestList);

	public void insertProxyChkList(ProxyChkList insertProxyChkList);

	public int deleteProxyChkList(@Param("px_cnt") List<Integer> rList);

	public void updateProxyChkList();

	public void setmodify(@Param("px_cnt") List<Integer> rList, @Param("proxyChkList") ProxyChkList proxyChkList);
}