package com.changhong.appserver.utils;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

	//Base64加密
	public static String encodeBase64String(String pwd) {
		return Base64.encodeBase64String(pwd.getBytes());
	}
	
	//Base64解密
	public static String decodeBase64(String pwd) {
		return new String(Base64.decodeBase64(pwd.getBytes()));
	}
}
