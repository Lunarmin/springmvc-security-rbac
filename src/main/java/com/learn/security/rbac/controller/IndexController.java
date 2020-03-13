package com.learn.security.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/userLogin")
	public String login() {
		return "login";
	}
}
