package com.changhong.appserver.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenUtil {

	protected static Logger logger=LoggerFactory.getLogger(TokenUtil.class);
	/**
	 * 生成用户永久的token
	 * 
	 * @return
	 */
	public static String getToken(String userName) {
		String originPwd=UUID.randomUUID().toString().replace("-", "")+"/"+userName;
		String base64Str = Base64.encodeBase64String(originPwd.getBytes());
		logger.debug("base64Str: "+base64Str);
		return base64Str;
	}
	
	/**
	 * 每次登陆时生成的accessToken有一定的实效性
	 * @return
	 */
	public static String getAccessToken() {
		String originPwd=UUID.randomUUID().toString().replace("-", "");
		String base64Str = Base64.encodeBase64String(originPwd.getBytes());
		logger.debug("base64Str: "+base64Str);
		return base64Str;
	}
	

	/**
	 * 获取刷新口令的token
	 * @return
	 */
	public static String getRefreshToken() {
		String originPwd=UUID.randomUUID().toString().replace("-", "")+System.currentTimeMillis();
		//切割15位
		String base64Str = Base64.encodeBase64String(originPwd.substring(0,15).getBytes());
		logger.debug("base64Str: "+base64Str);
		return base64Str;
	}
	
	
	public static void main(String[] args) throws Exception {
		String ss=getToken("Tom");
		logger.debug(ss);
		
//        String current = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format( new Date()); 
////		logger.debug(current);
//		
//		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");  
//		Long time=new Long(Long.parseLong(current));
		
		
		logger.debug(System.currentTimeMillis()+"");
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");  
		Long time=new Long(1514007309652L);
		String d = format.format(time);  
		logger.debug(d);
//	    System.out.println("Format To String(Date):"+d);  
	}

}
