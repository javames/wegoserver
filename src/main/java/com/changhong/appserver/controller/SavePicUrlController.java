package com.changhong.appserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.changhong.appserver.mapper.UserMapper;

@RestController
public class SavePicUrlController extends BaseController {

	protected static Logger logger=LoggerFactory.getLogger(SavePicUrlController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/savePicUrl",method = { RequestMethod.GET })
	public String savePicUrl(String token,String filePath,String type) {
		switch (type) {
		case "headImg":
			updateUserHeadImg(token,filePath);
			break;

		default:
			break;
		}
		return "";
	}

	private void updateUserHeadImg(String token,String filePath) {
		try {
			userMapper.updataUserEntityByToken(token,filePath);
		} catch (Exception e) {
			logger.debug("保存头像出错！");
		}
		
	}
}
