package com.ycs.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private Integer id;
    private String username;// 用户姓名
    private String sex;// 性别
    private Date birthday;// 生日
    private String address;// 地址
    private String password;
}
