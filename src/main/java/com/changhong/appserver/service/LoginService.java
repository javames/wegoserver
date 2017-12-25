package com.changhong.appserver.service;

import com.changhong.appserver.entity.RefreshTokenEntity;

/**
 * 
 * @author changhongshi
 *
 */
public interface LoginService {
	/**
	 * 登录
	 * @param userName
	 * @param passWord
	 * @return
	 */
	RefreshTokenEntity login(String userName,String passWord);
	
	/**
	 * 二次登录
	 */
	RefreshTokenEntity loginAccess(RefreshTokenEntity refreshTokenEntity);
}
