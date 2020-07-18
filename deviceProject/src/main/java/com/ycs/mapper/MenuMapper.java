package com.ycs.mapper;

import java.util.List;

import com.ycs.entity.Menu;

public interface MenuMapper {
	/**
	 * 获取所有的菜单
	 */
	public List<Menu> getMenu();
}
