package com.changhong.appserver.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.RefreshTokenEntity;
import com.changhong.appserver.service.LoginService;

public class LoginController extends BaseController{

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/firstLogin")
	public String FirstLogin(JSONObject jsonObject) {
		String userName=jsonObject.getString("userName");
		String passWord=jsonObject.getString("passWord");
		RefreshTokenEntity tokenEntity = loginService.login(userName, passWord);
		return JSON.toJSONString(tokenEntity);
	}
	
	@RequestMapping("/secondLogin")
	public String secondLogin(JSONObject jsonObject) {
//		JSON.toJavaObject(jsonObject, RefreshTokenEntity.class);
		RefreshTokenEntity refreshTokenEntity = JSON.parseObject(jsonObject.toString(), RefreshTokenEntity.class);
		RefreshTokenEntity loginAccess = loginService.loginAccess(refreshTokenEntity);
		return JSON.toJSONString(loginAccess);
		
	}
}
