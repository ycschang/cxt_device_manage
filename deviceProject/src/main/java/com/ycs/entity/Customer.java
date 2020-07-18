package com.ycs.entity;

import lombok.Data;

@Data
public class Customer {
	private Integer id;
	private String customer_name;
	private String customer_card;
	private String create_date;
	private String remark;
}
