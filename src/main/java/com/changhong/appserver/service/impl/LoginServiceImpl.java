package com.changhong.appserver.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.appserver.entity.RefreshTokenEntity;
import com.changhong.appserver.entity.UserEntity;
import com.changhong.appserver.mapper.RefreshTokenMapper;
import com.changhong.appserver.mapper.UserMapper;
import com.changhong.appserver.service.LoginService;
import com.changhong.appserver.utils.TokenUtil;

public class LoginServiceImpl implements LoginService {

	protected static Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RefreshTokenMapper refreshTokenMapper;
	
	
	@Override
	public RefreshTokenEntity login(String userName, String passWord) {
		RefreshTokenEntity refreshTokenEntity=null;
		UserEntity userEntity = userMapper.selectByNameAndPwd(userName, passWord);
		if(userEntity!=null) {
			/**
			 * 用户存在,保存refresh_token等数据到数据库
			 */
			
			//首先查找当前用户是首次登录还是二次登录
			RefreshTokenEntity refreshToken=refreshTokenMapper.selectByUid(userEntity.getId());
			if(refreshToken!=null) {//二次登录
				
			}
			
			refreshTokenEntity=new RefreshTokenEntity();
			refreshTokenEntity.setAccess_token(TokenUtil.getAccessToken());
			refreshTokenEntity.setRefresh_token(TokenUtil.getRefreshToken());
			refreshTokenEntity.setExpires_in("3600");
			refreshTokenEntity.setCurrent_time(System.currentTimeMillis()+"");
			Integer id=refreshTokenMapper.saveTokens(refreshTokenEntity);
			if(id>0) {
				//保存成功
				return refreshTokenEntity;
			}
		}
		return refreshTokenEntity;
	}

//	public void main(String [] args){
//		//获取当前时间  
//		String current = new SimpleDateFormat("yyyyMMddHHmmssSSS").format( new Date()); 
//		
//		logger.debug(current);
//		
//	}
}
