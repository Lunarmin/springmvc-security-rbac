package com.learn.security.rbac.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.learn.security.rbac.bean.Permission;
import com.learn.security.rbac.bean.User;
import com.learn.security.rbac.mapper.UserMapper;

/**
 * 登录业务处理
 * 
 * @author Panlf
 *
 */
public class MyUserDetailService implements UserDetailsService {

	public static final Logger log = LoggerFactory.getLogger(MyUserDetailService.class);
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 根据用户名查询用户
		User user = userMapper.findByUsername(username);

		if (user != null) {
			List<Permission> permList = userMapper.findPermissionByUsername(username);
			List<GrantedAuthority> authoritys = new ArrayList<>();

			for (Permission perm : permList) {
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perm.getPermTag());
				authoritys.add(grantedAuthority);
			}

			user.setAuthories(authoritys);

			log.info("当前用户为{}", user);
		}
		return user;
	}

}
