package com.changhong.appserver.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.RefreshTokenEntity;
import com.changhong.appserver.entity.RespApp;
import com.changhong.appserver.service.LoginService;
@RestController
public class LoginController extends BaseController{

	protected static Logger logger=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/firstLogin")
	public String FirstLogin(JSONObject jsonObject) {
		RespApp respApp=null;
		try {
			String userName = jsonObject.getString("userName");
			String passWord=jsonObject.getString("passWord");
			RefreshTokenEntity tokenEntity = loginService.login(userName, passWord);
			
			String code=tokenEntity.getCode();
			if(code.equals(Constant.succedCode)) {
				respApp = getSuccessRespEntity(tokenEntity);
			}else {
				respApp=getFailRespEntity(null);
			}
		} catch (JSONException e) {
			logger.debug("首次登录操作出现错误！");
			e.printStackTrace();
		}
		return JSON.toJSONString(respApp);
	}
	
	
	@RequestMapping("/secondLogin")
	public String secondLogin(RefreshTokenEntity refreshTokenEntity) {
		RefreshTokenEntity loginAccess = loginService.loginAccess(refreshTokenEntity);
		//用户不存在，即登录失败
		String code=loginAccess.getCode();
		RespApp respApp = getRespEntity(code,loginAccess);
		return JSON.toJSONString(respApp);
	}
}
