package com.changhong.appserver.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.UserEntity;
import com.changhong.appserver.mapper.UserMapper;
import com.changhong.appserver.utils.TextUtils;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

@RestController
public class UpTokenController extends BaseController{
	
	protected static Logger logger=LoggerFactory.getLogger(UpTokenController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getUpToken",method = { RequestMethod.GET })
	public String getUpToken(String token) {
		UserEntity userEntity = userMapper.selectByUtoken(token);
		if(null==userEntity) {
			logger.debug("当前用户为空！");
			return toJSONString(getRespEntity(Constant.userNotExsit, "user null"));
		}else {
			
			String upToken=null;
			Auth auth = Auth.create(Constant.accessKey, Constant.secretKey);
			StringMap putPolicy = new StringMap();
			putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
			
			long expireSeconds = 3600;
			if (TextUtils.isEmpty(userEntity)) {
				upToken = auth.uploadToken(Constant.bucket, null, expireSeconds, putPolicy);
				logger.debug("当前上传凭证: "+upToken);
			}else {
				upToken = auth.uploadToken(Constant.bucket, userEntity.getHeadImage(), expireSeconds, putPolicy);
				logger.debug("当前上传凭证: "+upToken);
			}
			return toJSONString(getSuccessRespEntity(upToken));
		}
	}

}
