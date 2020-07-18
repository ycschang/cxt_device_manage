package com.ycs.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Net_card {
	private  Integer id;
	private String net_card;
	private Integer card_status;
	private Date create_date;
}
