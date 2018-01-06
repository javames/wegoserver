package com.changhong.appserver.controller;

import org.json.JSONObject;
import org.junit.experimental.theories.Theories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	protected RespApp getRespEntity(String code,Object obj) {
		RespApp respApp=new RespApp(code, "返回数据！", obj);
		return respApp;
	}
	
	protected String toJSONString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	protected com.alibaba.fastjson.JSONObject toJSONObject(Object obj) {
		com.alibaba.fastjson.JSONObject jsonObject=JSON.parseObject(obj.toString());
		return jsonObject;
	}
}
