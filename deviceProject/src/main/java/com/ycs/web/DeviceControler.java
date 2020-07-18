package com.ycs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycs.Service.DeviceServices;
import com.ycs.Service.Net_cardService;
import com.ycs.entity.Device;
import com.ycs.entity.Net_card;
import com.ycs.entity.PageInfo;;

/*@RestController(value = "/user")*/
@CrossOrigin
@Controller
@RequestMapping(value = "/device")
public class DeviceControler {
	@Autowired
	private DeviceServices dServices;
	@Autowired
	private Net_cardService n_cService;
	/**
	 * 设备分页查询
	 * @param currentPage
	 * @param pageSize
	 * @param device
	 * @return 查询到的设备信息
	 */
	@RequestMapping(value = "/getPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> PageInfo(Integer page, Integer limit,String device_card) {
		//System.out.println(device_card);
		Integer pageSize = limit;
		PageInfo<Device> pageInfoUser = dServices.findAllUsersByPage(page, pageSize,device_card);
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfoUser.getTotalNum());
		map.put("data", pageInfoUser.getList());
		return map;
	}

	/**
	 * 添加设备
	 * 
	 * @param device
	 * @return
	 */
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addDevice(Device device) {
		// StringUtils.isNotBLank(errMsg);
		String VerificatioResult = "";
		Map<String, Object> map = new HashMap<>();
		try {
			int r = dServices.addDevice(device);// 新增设备信息
			if (r > 0) {
				map.put("code", 200);
				map.put("msg", "");
				map.put("result", "添加成功");

			} else {
				map.put("code", 200);
				map.put("msg", "");
				map.put("result", "添加失败");
			}
			return map;
		} catch (Exception e) {
			boolean isThrow = true;
			Throwable cause = e.getCause();
			if (cause instanceof java.sql.SQLIntegrityConstraintViolationException) {
				isThrow = false;
				String errMsg = ((java.sql.SQLIntegrityConstraintViolationException) cause).getMessage();
				// 根据约束名称定位是那个字段
				if (StringUtils.isNotBlank(errMsg) && errMsg.indexOf("Duplicate") != -1) {
					VerificatioResult = "详情必传参数异常: APP_CODE 违反唯一约束条件";
				} else {
					isThrow = true;
				}
			}
			if (isThrow) {
				// 处理非唯一约束异常
				map.put("748", "未知异常");
				return map;
			}
		}
		if (StringUtils.isNotBlank(VerificatioResult)) {
			// 把对应字段的错误返回给前端显示
			map.put("code", 201);
			map.put("result", "设备号重复");
			return map;
		}
		return map;

	}
	
	/**
	 * 删除设备
	 * 
	 * @param device
	 * @return
	 */
	@RequestMapping(value = "/delDevice", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delDevice(String device_card) {
		Map<String, Object> map = new HashMap<>();
		int r = dServices.deleteDevice(device_card);
		if (r > 0) {
			map.put("code", 200);
			map.put("msg", "");
			map.put("result", "删除成功");
			/* map.put("data", pageInfoUser.getList()); */
		} else {
			map.put("code", 0);
			map.put("msg", "");
			map.put("result", "删除失败");
		}
		return map;
	}
	
	
	/**
	 * 修改设备信息＆绑定互联网卡
	 * 
	 * @param device
	 * @return
	 */
	@RequestMapping(value = "/updateDevice", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateDevice(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String device_card = request.getParameter("device_card");
		String device_type = request.getParameter("device_type");
		String device_name = request.getParameter("device_name");
		String device_status = request.getParameter("device_status");
		String net_card = request.getParameter("net_card");
		//System.out.println(net_card);
		String status ="1";
		List<Map> list = n_cService.findNet_card(net_card);
		//System.out.println(list);
		if(net_card == null || net_card == "") {
			Net_card n_card = new Net_card();
	        n_card.setNet_card(net_card);
	        n_card.setCard_status(1);
			Device device = new Device(device_card, device_name, device_status, device_type);
			//int r1 = dServices.addNet_card(n_card);//向物联网卡表中插入卡号
			int r2 = dServices.deviceBindNcard(net_card,device_card, status);//设备绑定物联网卡
			int r = dServices.editDevice(device);//根据设备号修改设备信息
			if (r > 0) {
				map.put("code", 200);
				map.put("msg", "");
				map.put("result", "修改成功");
			} else {
				map.put("code", 200);
				map.put("msg", "");
				map.put("result", "修改失败");
			}
			return map;
		} else {
			if (null == list || list.size() ==0) {
				//System.out.println(66666);
				map.put("code", 200);
				map.put("result", "卡号不存在");
				//System.out.println(6666677);
				return map;
			} else {
				Net_card n_card = new Net_card();
		        n_card.setNet_card(net_card);
		        n_card.setCard_status(1);
				Device device = new Device(device_card, device_name, device_status, device_type);
				//int r1 = dServices.addNet_card(n_card);//向物联网卡表中插入卡号
				int r2 = dServices.deviceBindNcard(net_card,device_card, status);//设备绑定物联网卡
				int r = dServices.editDevice(device);//根据设备号修改设备信息
				if (r > 0) {
					map.put("code", 200);
					map.put("msg", "");
					map.put("result", "修改成功");
				} else {
					map.put("code", 200);
					map.put("msg", "");
					map.put("result", "修改失败");
				}
				return map;
			}
		}
		
	}

	

	/**
	 * 设备绑定物联网卡
	 * @param device_card,net_card
	 * @return 受影响的行数
	 */
	@RequestMapping(value = "/deviceBindNcard", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deviceBindNcard(String device_card, String net_card) {
		String status = "1";
		Map<String, Object> map = new HashMap<>();
		int r = dServices.deviceBindNcard(device_card, net_card, status);
		if (r > 0) {
			map.put("code", 200);
			map.put("msg", "绑定成功");
		} else {
			map.put("code", 0);
			map.put("msg", "绑定失败");
		}
		return map;
	}
	
}
