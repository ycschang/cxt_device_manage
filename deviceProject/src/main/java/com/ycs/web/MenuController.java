package com.ycs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycs.Service.MenuService;
import com.ycs.entity.Menu;
import com.ycs.util.MenuTree;

import net.sf.json.JSONObject;



@CrossOrigin
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	@Autowired 
	private MenuService mService;
	/**
	 * 查询菜单栏
	 * @return List<Menu>
	 */
	@RequestMapping(value = "/getMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object getMenu() {	
		List<Menu> mList =  mService.findMenu();
		MenuTree menuTree = new MenuTree(mList);
		List<Menu> menuList = menuTree.builTree();		
		Map<String, List<Menu>> map = new HashMap<String, List<Menu>>();
		map.put("contentManagement", menuList);
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject;
	}
}
