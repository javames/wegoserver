package com.changhong.appserver.constant;

public class Constant {

	//操作失败
	public static final String errorCode="APP_000";
	//操作成功
	public static final String succedCode="APP_001";
	//用户已存在
	public static final String userHasRegister="APP_032";
	//用户不存在
	public static final String userNotExsit="APP_101";
	//token超出有效时间
	public static final String outUsedTime="APP_102";
	//注册成功
	public static final String register_success="APP_103";
	//注册失败
	public static final String register_fail="APP_104";
	
	/**
	 * access_token有效时间
	 */
	public static final String expires_in="7200";
	
	/**
	 * refresh_token有效时间 30天
	 */
	public static final long refresh_expires_in=30*24*60*60;
	
	//shareSdk验证地址
	public static final String smsApi="https://webapi.sms.mob.com/sms/verify";
	
	public static final String appKey="234f1eee14d17";
	
	public static final String zoom="86";
	
	//验证成功
	public static final int identify_succed=200;
	//验证码错误
	public static final int identify_code_error=468;
	//验证码验证次数过多，已经失效
	public static final int identify_code_unused=467;
	
	
	
	
	
}
