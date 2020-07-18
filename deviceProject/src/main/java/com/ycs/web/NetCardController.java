package com.ycs.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycs.Service.Net_cardService;
import com.ycs.entity.PageInfo;

@CrossOrigin
@Controller
@RequestMapping(value = "/netCard")
public class NetCardController {
	@Autowired
	private Net_cardService n_cService;
	/**
	 * 物联网卡分页查询
	 * @param currentPage
	 * @param pageSize
	 * @param net_card
	 * @return 查询到的物联网相关信息
	 */
	@RequestMapping(value = "/getNet_CardPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNet_CardPageInfo(Integer page, Integer limit,String net_card) {
		//System.out.println(device_card);
		Integer pageSize = limit;
		PageInfo<Object> pageInfoUser = n_cService.findAllNet_CardByPage(page, pageSize, net_card);
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfoUser.getTotalNum());
		map.put("data", pageInfoUser.getList());
		return map;
	}
}
