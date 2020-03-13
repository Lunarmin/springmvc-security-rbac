package com.learn.security.rbac.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * 验证码工具类
 * 
 */
public class CodeImage {
	private static final int WIDTH = 100;
	private static final int HEIGHT = 40;
	
	public static Map<String,Object>  getCodeImage(){
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		setBackgroud(g);
		setBord(g);
		String code = setRandomChar(g);
		setRandomLine(g);
		g.dispose();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("image", image);
		return map;
	}
	
	private static void setRandomLine(Graphics2D g){
		//线状噪声
		for(int i=0;i<5;i++){
			g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(15);
			int y2 = new Random().nextInt(15);
			g.drawLine(x1, y1, x1+x2, x2+y2);
		}
		
		
		//点状噪声
		/*
		for (int i = 0; i < 5 * 7; i++) {
			int x = new Random().nextInt(WIDTH);
			int y = new Random().nextInt(HEIGHT);
			g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
			// 绘制1*1大小的矩形
			g.drawRect(x, y, 1, 1);
		}*/
	}
	
	//画布内容
	private static String setRandomChar(Graphics2D g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Georgia",Font.BOLD,HEIGHT-5));
		StringBuffer sb = new StringBuffer();
		String base="0123456789abcdefghijklmnopqrstuvwxyz";
		int x = 10;
		for(int i=0;i<4;i++){
			String ch = base.charAt(new Random().nextInt(base.length()))+"";
			int degree = new Random().nextInt(60)-30;
			g.rotate(degree*Math.PI/180,x,25);
			g.drawString(ch,x,25);
			g.rotate(-(degree*Math.PI/180), x, 25);
			x += 20;
			sb.append(ch);
		}
		return sb.toString();
	}

	//设置边框
	private static void setBord(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial", Font.BOLD, HEIGHT - 2));
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
	}

	//背景设置为白色
	private static void setBackgroud(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
}

