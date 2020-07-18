package com.ycs.entity;

import lombok.Data;

@Data
public class Device {
	private Integer id;
	private String device_card;
	private String device_name;
	private String whereabouts;
	private String cheack_out;
	private String device_status;
	private String device_type;
	private String create_date;
	private String remark;
	public Device() {
		super();
	}
	public Device(String device_card, String device_name, String device_status, String device_type) {
		super();
		this.device_card = device_card;
		this.device_name = device_name;
		this.device_status = device_status;
		this.device_type = device_type;
	}
	
}
