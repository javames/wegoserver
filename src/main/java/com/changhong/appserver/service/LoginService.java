package com.changhong.appserver.service;

import com.changhong.appserver.entity.RefreshTokenEntity;

/**
 * 
 * @author changhongshi
 *
 */
public interface LoginService {
	RefreshTokenEntity login(String userName,String passWord);
}
