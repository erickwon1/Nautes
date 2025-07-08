package com.nautestech.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nautestech.www.model.IpPools;

import utils.RequestList;

@Mapper
public interface IpPoolsMapper {
	public List<IpPools> getIpPools(RequestList<?> requestList);

	public int getIpPoolsCount(RequestList<?> requestList);

	public void setinsert(IpPools ipPools);

	public void setmodify(@Param("i_cnt") List<Integer> iList, @Param("ipPools") IpPools ipPools);

	public void setupdate();

	public int setdelete(@Param("i_cnt") List<Integer> iList);
}