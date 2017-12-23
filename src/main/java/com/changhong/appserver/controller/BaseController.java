package com.changhong.appserver.controller;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.RespApp;

public class BaseController {

	/**
	 * 将数据转换成前台app需要的样式(请求成功)
	 */
	protected RespApp getSuccessRespEntity(Object obj) {
		RespApp resp=new RespApp(Constant.succedCode,"请求成功！",obj);
		return resp;
	}
	
	protected RespApp getFailRespEntity(Object obj) {
		RespApp resp=new RespApp(Constant.errorCode,"请求失败！",null);
		return resp;
	}
	
	protected String toJSONObject(Object obj) {
		JSONObject jsonObject=new JSONObject();
		return JSON.toJSONString(jsonObject);
	}
}
