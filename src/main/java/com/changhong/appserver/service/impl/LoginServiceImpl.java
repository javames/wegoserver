package com.changhong.appserver.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.appserver.constant.Constant;
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
	
	/**
	 * 首次登录
	 */
	@Override
	public RefreshTokenEntity login(String userName, String passWord) {
		RefreshTokenEntity refreshTokenEntity=new RefreshTokenEntity();
		UserEntity userEntity = userMapper.selectByNameAndPwd(userName, passWord);
		if(userEntity!=null) {//用户存在
			//第一次登陆
			refreshTokenEntity.setAccess_token(TokenUtil.getAccessToken());
			refreshTokenEntity.setRefresh_token(TokenUtil.getRefreshToken());
			refreshTokenEntity.setExpires_in(Constant.expires_in);
			refreshTokenEntity.setCurrent_time(System.currentTimeMillis()+"");
			refreshTokenEntity.setRefresh_expires(System.currentTimeMillis()+"");
			refreshTokenEntity.setUid(userEntity.getId()+"");
			refreshTokenEntity.setCode(Constant.loginSucced);
			refreshTokenEntity.setUnionid(userEntity.getUsertoken());
		}else {
			refreshTokenEntity.setCode(Constant.userNotExsit);
		}
		return refreshTokenEntity;
	}
	
	
	private RefreshTokenEntity updateAccessToken(RefreshTokenEntity refreshToken) {
		String current_time = refreshToken.getCurrent_time();
		String expires_in = refreshToken.getExpires_in();
		if(Long.parseLong(current_time)+Long.parseLong(expires_in)>System.currentTimeMillis()) {
			//在有效时间内，可以正常登陆,刷新下有效时间
			refreshToken.setCurrent_time(System.currentTimeMillis()+"");
			refreshTokenMapper.updataRefreshToken(refreshToken);
		}else {
			//在有效期外
			refreshToken=new RefreshTokenEntity();
			refreshToken.setAccess_token(TokenUtil.getAccessToken());
			refreshToken.setRefresh_token(TokenUtil.getRefreshToken());
			refreshToken.setExpires_in(Constant.expires_in);
			refreshToken.setCurrent_time(System.currentTimeMillis()+"");
			Integer id=refreshTokenMapper.saveTokens(refreshToken);
			if(id<=0) {
				refreshToken=null;
				logger.debug("保存access_refresh有效时间出错！");
			}
		}
		return refreshToken;
	}


	/**
	 * 二次登录
	 */
	@Override
	public RefreshTokenEntity loginAccess(RefreshTokenEntity refreshTokenEntity) {
		//首先检验当前用户是否存在
		UserEntity byUtoken = userMapper.selectByUtoken(refreshTokenEntity.getUnionid());
		if(byUtoken!=null) {//用户存在
			RefreshTokenEntity refreshToken=refreshTokenMapper.selectByUid(byUtoken.getId());
			if(refreshToken!=null) {
				String refresh_expires = refreshToken.getRefresh_expires();
				long parseLong = Long.parseLong(refresh_expires);
				if((parseLong+Constant.refresh_expires_in)>System.currentTimeMillis()) {
					//refresh_token没有超出有效时间
					refreshTokenEntity = updateAccessToken(refreshToken);
					refreshTokenEntity.setCode(Constant.loginSucced);
				}else {
					//refresh_token超出了有效时间
					refreshTokenEntity.setCode(Constant.outUsedTime);
				}
			}else {
				logger.debug("相关token记录为空！");
			}
		}else {
			refreshTokenEntity.setCode(Constant.userNotExsit);
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
