package com.ycs.entity;

import java.util.List;

import lombok.Data;

@Data
public class Menu {
	private Integer id;
	private Integer parentId;
	private String title;
	private String href;
	private boolean spread;
	private List<Menu> children;
	private String icon;
	private String remark;
}
