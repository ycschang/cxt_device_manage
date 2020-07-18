package com.ycs.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ycs.entity.Customer;
import com.ycs.entity.Device;
import com.ycs.entity.Net_card;


@Repository
public interface DeviceMapper {
	
	/* public List<Device> findByDevice(); */
	/**
	 * 根据term条件查询设备信息
	 * @param term
	 * @return 返回设备的基本信息
	 */
	public List<Map> findDeviceMsg(@Param(value="device_card") String device_card);
	
	/**
	 * 添加设备信息
	 * @param device
	 * @return 返回受影响的行数
	 */
	public int insertDevice(Device device);
	
	/**
	 * 删除设备
	 * @param Integer device_card
	 * @return 返回受影响的行数
	 */
	public int delDevice(String device_card);
	
	/**
	 * 修改设备信息
	 * @param Integer device_card
	 * @return 返回受影响的行数
	 */
	public int updateDevice(Device device);
	
	/**
	 * 添加物联网卡
	 * @param net_card
	 * @return
	 */
	public int insertNet_card(Net_card net_card);
	
	/**
	 * 设备绑定物联网卡
	 * @param device_card
	 * @param net_card
	 * @return 受影响的行数
	 */
	public int deviceBindNcard(@Param("net_card")String net_card,@Param("device_card")String device_card,@Param("card_status")String status,@Param("create_date")Date create_date);
	
	
	
	
	
	
}
