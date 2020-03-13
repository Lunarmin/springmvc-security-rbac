package com.learn.security.rbac.mapper;

import java.util.List;

import com.learn.security.rbac.bean.Permission;
import com.learn.security.rbac.bean.User;

public interface UserMapper {
	
	public User findByUsername(String username);
	
	public List<Permission> findPermissionByUsername(String username);
}
