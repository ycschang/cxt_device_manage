package com.ycs.Service;

import com.ycs.entity.Device;
import com.ycs.entity.Net_card;
import com.ycs.entity.PageInfo;


public interface DeviceServices {
	
	
	/**
	 * 分页查询设备查询
	 * @param currentPage
	 * @param pageSize
	 * @param device
	 * @return 查询到的设备信息
	 */
	public PageInfo<Device> findAllUsersByPage(Integer currentPage,Integer pageSize,String device_card);
	
	/**
	 * 添加设备
	 * @param device
	 * @return 返回受影响的行数
	 */
	public int addDevice(Device device);
	
	/**
	 * 删除设备
	 * @param Integer device_card
	 * @return 返回受影响的行数
	 */
	public int deleteDevice(String device_card);
	
	/**
	 * 修改设备信息
	 * @param Integer device_card
	 * @return 返回受影响的行数
	 */
	public int editDevice(Device device);
	
	
	/**
	 * 添加物联网卡
	 * @param device
	 * @return 返回受影响的行数
	 */
	public int addNet_card(Net_card net_card);
	/**
	 * 根据device条件查询设备
	 * @param term
	 * @return 返回设备的基本信息/使用人/项目
	 */
	//public List<Map> getDeviceMsg(Device device);
	
	
	/**
	 * 设备绑定物联网卡
	 * @param device_card
	 * @param net_card
	 * @return 受影响的行数
	 */
	public int deviceBindNcard(String net_card,String device_card,String status);
	
		
}
