package com.learn.security.rbac.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义登录成功的逻辑
 * @author Panlf
 *
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private ObjectMapper objectMapper = new  ObjectMapper();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//返回字符串给前端
		Map<String,Object> map = new HashMap<>();
		map.put("success",true);
		
		String json = objectMapper.writeValueAsString(map);
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(json);
		
	}

}
