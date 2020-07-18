package com.ycs.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycs.entity.Menu;


public interface MenuService {
	/**
	 * 查询所有的菜单
	 * @return 菜单集合
	 */
	public List<Menu> findMenu();
}
