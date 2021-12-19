package com.learn.security.rbac.base;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderPassword {

	public static void main(String args[]) {
		encoderPassword();
	}

	public static void encoderPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
   		String result = encoder.encode("secret");
   		System.out.println(result);
	}
}
