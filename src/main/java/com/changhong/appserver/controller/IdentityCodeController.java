package com.changhong.appserver.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.RefreshTokenEntity;
import com.changhong.appserver.entity.RespApp;
import com.changhong.appserver.service.LoginService;
import com.changhong.appserver.service.RegisterService;
import com.changhong.appserver.utils.Base64Util;
import com.changhong.appserver.utils.SmsWebApiKit;

@RestController
public class IdentityCodeController extends BaseController {

	
	protected static Logger logger=LoggerFactory.getLogger(IdentityCodeController.class);
	
	@Autowired
	private RegisterService registerService;
	@Autowired
	private LoginService LoginService;
	
	@ResponseBody
	@RequestMapping(value="/identity",method = { RequestMethod.GET }, produces="application/json;charset=UTF-8")
	public String identityCode(String phone,String code) throws IllegalAccessException {
		logger.debug("phone: "+phone+" code: "+code);
		SmsWebApiKit smsApi=new SmsWebApiKit(Constant.appKey);
		RespApp respApp=null;
		try {
			String checkcode = smsApi.checkcode(phone, Constant.zoom, code);
			logger.debug("checkCode: "+checkcode);
			com.alibaba.fastjson.JSONObject jsonObj = toJSONObject(checkcode);
			logger.debug("checkCode: "+jsonObj);
			int status = jsonObj.getInteger("status");
			logger.debug("status: "+status);
			switch (status) {
			case Constant.identify_succed:
				//验证成功后需要创建用户
				String register = registerService.register(phone+"sxy",Base64Util.encodeBase64String(phone+"1scf"+code));
				switch (register) {
				case Constant.succedCode:
				case Constant.userHasRegister:
					//注册成功,进行登录操作
					RefreshTokenEntity loginEntity = LoginService.login(phone+"sxy", Base64Util.encodeBase64String(phone+"1scf"+code));
					if(loginEntity.getCode().equals(Constant.succedCode)) {
						//登录成功,返回token
						logger.debug("登录成功！");
						respApp=getSuccessRespEntity(loginEntity);
					}else {
						//登录失败
						logger.debug("登录失败！");
						respApp=getFailRespEntity(loginEntity);
					}
					break;

				case Constant.errorCode:
					//注册失败
					logger.debug("手机验证码注册失败！");
					respApp=getRespEntity(Constant.register_fail, "fail!");
					break;
				}
				break;
			case Constant.identify_code_error:
				logger.debug("手机验证码错误！");
				respApp=getRespEntity(Constant.identify_code_error+"","error!");
				break;
			case Constant.identify_code_unused:
				logger.debug("手机验证码无效！");
				respApp=getRespEntity(Constant.identify_code_unused+"","unused!");
				break;
			}
		} catch (Exception e) {
			logger.debug("验证验证码出错！");
			e.printStackTrace();
		}
		String resp=toJSONString(respApp);
		logger.debug("resp: "+resp);
		return resp;
	}
}
