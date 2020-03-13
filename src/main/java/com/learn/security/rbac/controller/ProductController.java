package com.learn.security.rbac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping("/add")
	public String add() {
		return "product/productAdd";
	}
	
	
	@RequestMapping("/update")
	public String update() {
		return "product/productUpdate";
	}
	
	@RequestMapping("/list")
	public String list() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal!=null) {
			if(principal instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) principal;
				String username = userDetails.getUsername();
				log.info("当前登录用户:{}",username);
			}
		}
		
		
		
		return "product/productList";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "product/productDelete";
	}
}
