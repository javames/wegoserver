package com.changhong.appserver.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.RespApp;
import com.changhong.appserver.service.RegisterService;

@RestController
public class RegisterController extends BaseController{

protected static Logger logger=LoggerFactory.getLogger(HolloWorldController.class);
	
	@Autowired
	private RegisterService registerService;
	@RequestMapping("/register")
	public String register(JSONObject jsonObject) {
		String userName=jsonObject.getString("userName");
		String passWord=jsonObject.getString("passWord");
		String registerMsg = registerService.register(userName, passWord);
		String respObject=null;
		if(registerMsg.equals(Constant.register_SUCCESS)) {
			RespApp respEntity = getSuccessRespEntity("register succed!");
			respObject = toJSONObject(respEntity);
		}else {
			RespApp respEntity = getFailRespEntity(null);
			respObject = toJSONObject(respEntity);
		}
		return respObject;
		
	}
}
