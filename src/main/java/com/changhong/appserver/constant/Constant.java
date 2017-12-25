package com.changhong.appserver.constant;

public class Constant {

	public static final String errorCode="APP_000";
	
	public static final String succedCode="APP_001";
	
	public static final String register_SUCCESS="注册成功";
	
	public static final String register_FAILURE="注册失败";
	
	public static final String userHasRegister="用户已存在";
	
	//登录成功
	public static final String loginSucced="APP_100";
	//用户不存在
	public static final String userNotExsit="APP_101";
	//token超出有效时间
	public static final String outUsedTime="APP_102";
	/**
	 * access_token有效时间
	 */
	public static final String expires_in="7200";
	
	/**
	 * refresh_token有效时间 30天
	 */
	public static final long refresh_expires_in=30*24*60*60;
	
}
