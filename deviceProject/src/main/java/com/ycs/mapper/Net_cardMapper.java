package com.ycs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Net_cardMapper {
	public List<Map> selectNetCard(String net_card);
	
	/**
	 * 根据term条件查询物联网卡信息
	 * @param term
	 * @return 返回物联网卡的基本信息
	 */
	public List<Map> findNet_CardMsg(@Param(value="net_card") String net_card);
}
