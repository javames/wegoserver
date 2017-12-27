package com.changhong.appserver.utils;

import com.changhong.appserver.constant.Constant;

/**
 * 服务端发起验证请求验证移动端(手机)发送的短信
 * @author Administrator
 *
 */

public class SmsWebApiKit {

private String appkey;
	
	public SmsWebApiKit(String appkey) {
		super();
		this.appkey = appkey;
	}

	/**
	 * 服务端发起发送短信请求
	 * @return
	 * @throws Exception
	 */
	public  String sendMsg(String phone,String zone) throws Exception{
		
		String address = Constant.smsApi;
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addParam("appkey", appkey).addParam("phone", phone)
					.addParam("zone", zone);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
	
	/**
	 * 服务端发验证服务端发送的短信
	 * @return
	 * @throws Exception
	 */
	public  String checkcode(String phone,String zone,String code) throws Exception{
		
		String address = Constant.smsApi;
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addParam("appkey", appkey).addParam("phone", phone)
					.addParam("zone", zone).addParam("code", code);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
//		String result=new SmsWebApiKit("234f1eee14d17").checkcode("15618902203", "86", "5975");
//		System.out.println("result= "+result.toString());
	}
	
}
