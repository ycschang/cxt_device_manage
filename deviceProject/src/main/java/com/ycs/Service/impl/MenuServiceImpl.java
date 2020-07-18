package com.ycs.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycs.Service.MenuService;
import com.ycs.entity.Menu;
import com.ycs.mapper.MenuMapper;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper mMapper;
	@Override
	public List<Menu> findMenu() {
		// TODO Auto-generated method stub
		List<Menu> listMenu = mMapper.getMenu();
		return listMenu;
	}
	
}
