package com.ycs.mapper;

import com.ycs.entity.Customer;

public interface CustomerMapper {
	/**
	 * 添加客户信息
	 * @param device
	 * @return 返回受影响的行数
	 */
	public int insertCustomer(Customer customer);
}
