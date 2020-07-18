package com.ycs.mapper;

import com.ycs.entity.User;

public interface UserMapper {
	public abstract User findByUsername(String username);
}
