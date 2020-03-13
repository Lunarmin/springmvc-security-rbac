package com.learn.security.rbac.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

public class ImageCodeAuthenticationFilter extends OncePerRequestFilter {

	private AuthenticationFailureHandler authenticationFailureHandler;
	
	public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//判断当前请求，是否为登录请求
		if(request.getRequestURI().contains("/securityLogin")) {
			try {
				//获取用户输入的验证码
				final String imageCode = request.getParameter("imagecode");
				
				//获取系统生成的验证码
				String key = (String) request.getSession().getAttribute("vertifycode");
				
				if(imageCode==null) {
					throw new ImageCodeException("验证码必须输入");
				}
				
				if(!imageCode.trim().equals(key.trim())) {
					throw new ImageCodeException("验证码不一致");
				}
				
			} catch (AuthenticationException e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return;
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
