package com.learn.security.rbac.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{

	private static final long serialVersionUID = -2034431428790862325L;
	
	private Integer id;
	private String username;
	private String realname;
	private String password;
	/**
	 * 创建日期
	 */
	private Date createDate; 
	
	/**
	 * 最后登录时间
	 */
	private Date lastLogintime;
	
	/**
	 * 是否可用
	 */
	private boolean enabled;
	/**
	 * 是否过期
	 */
	private boolean accountNonExpired;
	/**
	 * 是否锁定
	 */
	private boolean accountNonLocked;
	
	/**
	 * 证书是否过期
	 */
	private boolean credentialsNonExpired;

	/**
	 * 用户拥有的所有权限
	 */
	public List<GrantedAuthority> authorities = new ArrayList<>();
	
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthories(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(Date lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
