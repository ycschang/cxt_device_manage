package com.ycs.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycs.Service.Net_cardService;
import com.ycs.entity.Device;
import com.ycs.entity.PageInfo;
import com.ycs.mapper.Net_cardMapper;

@Service
public class Net_cardServiceImpl implements Net_cardService{
	@Autowired
	private Net_cardMapper n_cMapper;
	
	@Override
	public List<Map> findNet_card(String net_card) {
		// TODO Auto-generated method stub
		return n_cMapper.selectNetCard(net_card);
	}
	/**
	 * 查询物联网卡的基本信息
	 */
	@Override
	public PageInfo<Object> findAllNet_CardByPage(Integer currentPage, Integer pageSize, String net_card) {
		// TODO Auto-generated method stub
		// List<Device> device = dMapper.findByDevice();
		List<Map> n_c = n_cMapper.findNet_CardMsg(net_card);
		// List<Map> device = dMapper.findDeviceMsg();
		PageInfo<Object> pageInfo = new PageInfo<>(n_c.size(), currentPage, pageSize, 10);
		// 判断是否是最后一页,如果最后一页就显示最后一页的几条，不是最后一页就显示pageSize条
		if (currentPage == pageInfo.getTotalPage())
			pageInfo.setList(n_c.subList((currentPage - 1) * pageSize, n_c.size()));
		else
			pageInfo.setList(n_c.subList((currentPage - 1) * pageSize, (currentPage - 1) * pageSize + pageSize));
		return pageInfo;
	}
}
