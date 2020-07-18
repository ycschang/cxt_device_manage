package com.ycs.Service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycs.Service.DeviceServices;
import com.ycs.entity.Device;
import com.ycs.entity.Net_card;
import com.ycs.entity.PageInfo;
import com.ycs.mapper.DeviceMapper;

@Service
public class DeviceServicesImpl implements DeviceServices {

	@Autowired
	private DeviceMapper dMapper;

	/**
	 * 分页查询
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param device
	 * @return 查询到的设备信息
	 */
	@Override
	public PageInfo<Device> findAllUsersByPage(Integer currentPage, Integer pageSize, String device_card) {
		// TODO Auto-generated method stub
		// List<Device> device = dMapper.findByDevice();
		List<Map> device = dMapper.findDeviceMsg(device_card);
		// List<Map> device = dMapper.findDeviceMsg();
		PageInfo<Device> pageInfo = new PageInfo<>(device.size(), currentPage, pageSize, 10);
		// 判断是否是最后一页,如果最后一页就显示最后一页的几条，不是最后一页就显示pageSize条
		if (currentPage == pageInfo.getTotalPage())
			pageInfo.setList(device.subList((currentPage - 1) * pageSize, device.size()));
		else
			pageInfo.setList(device.subList((currentPage - 1) * pageSize, (currentPage - 1) * pageSize + pageSize));
		return pageInfo;
	}

	/**
	 * 添加设备
	 * 
	 * @param device
	 * @return 返回受影响的行数
	 */
	@Override
	public int addDevice(Device device) {
		// TODO Auto-generated method stub
		return dMapper.insertDevice(device);
	}

	/**
	 * 根据device_card删除设备
	 * 
	 * @param device_card
	 * @return 返回受影响的行数
	 */
	@Override
	public int deleteDevice(String device_card) {
		// TODO Auto-generated method stub
		return dMapper.delDevice(device_card);
	}

	/**
	 * 根据device_card编辑设备信息
	 * 
	 * @param device
	 * @return 返回受影响的行数
	 */
	@Override
	public int editDevice(Device device) {
		// TODO Auto-generated method stub
		return dMapper.updateDevice(device);
	}

	@Override
	public int addNet_card(Net_card net_card) {
		// TODO Auto-generated method stub
		return dMapper.insertNet_card(net_card);
	}

	@Override
	public int deviceBindNcard(String net_card, String device_card, String status) {
		// TODO Auto-generated method stub
		Date create_date = null;
		return dMapper.deviceBindNcard(net_card, device_card, status, create_date);
	}

	

	/*
	 * @Override public List<Map> getDeviceMsg(Device device) { // TODO
	 * Auto-generated method stub return dMapper.findDeviceMsg(device); }
	 */

	/*
	 * @Autowired private CustomerMapper cMapper;
	 */
	/*
	 * @Override public List<Device> getAllDevice() { // TODO Auto-generated method
	 * stub List<Device> listDevice = dMapper.findByDevice(); return listDevice; }
	 */

	/*
	 * @Override public int addDeviceBind(String device_card, String id_card) {
	 * Customer customer = cMapper.findCustomer(id_card); if (customer == null) {
	 * return -1; } int r = dMapper.deviceBindCustomer(device_card, id_card); return
	 * r; }
	 */

	/*
	 * @Override public int addDeviceBind(String device_card, String id_card) { //
	 * TODO Auto-generated method stub return 0; }
	 */

}
