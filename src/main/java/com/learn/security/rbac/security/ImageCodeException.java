package com.learn.security.rbac.security;

import org.springframework.security.core.AuthenticationException;

public class ImageCodeException extends AuthenticationException{

	
	private static final long serialVersionUID = -719252269047841970L;
	
	public ImageCodeException(String msg,Throwable t) {
		super(msg, t);
	}
	
	public ImageCodeException(String msg) {
		super(msg);
	}

}
