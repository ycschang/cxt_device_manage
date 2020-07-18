package com.ycs.Service;

import com.ycs.entity.Customer;

public interface CustomerService {
	/**
	 * 添加设备
	 * @param device
	 * @return 返回受影响的行数
	 */
	public int addCustomer(Customer customer);
}
