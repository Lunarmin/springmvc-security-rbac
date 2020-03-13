package com.learn.security.rbac.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.security.rbac.utils.CodeImage;

@Controller
public class ImageCodeController {
	
	@RequestMapping("image")
	public void  getCodeImage(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		Map<String,Object> map = CodeImage.getCodeImage();
		session.setAttribute("vertifycode", map.get("code"));
		try {
			ImageIO.write((RenderedImage) map.get("image"), "JPEG", response.getOutputStream());
	        response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}