package com.ycs.Service;

import java.util.List;
import java.util.Map;

import com.ycs.entity.Device;
import com.ycs.entity.PageInfo;


public interface Net_cardService {
	/**
	 * 添加设备
	 * @param device
	 * @return 返回受影响的行数
	 */
	public List<Map> findNet_card(String net_card);
	/**
	 * 分页查询物联网卡信息
	 * @param currentPage
	 * @param pageSize
	 * @param net_card
	 * @return 查询到物联网卡的信息
	 */
	public PageInfo<Object> findAllNet_CardByPage(Integer currentPage,Integer pageSize,String net_card);
}
