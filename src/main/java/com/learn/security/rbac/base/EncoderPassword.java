package com.learn.security.rbac.base;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderPassword {

	@Test
	public void encoderPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
   		String result = encoder.encode("secret");
   		System.out.println(result);
	}
}
