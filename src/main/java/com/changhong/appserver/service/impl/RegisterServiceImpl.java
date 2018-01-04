package com.changhong.appserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.UserEntity;
import com.changhong.appserver.mapper.UserMapper;
import com.changhong.appserver.service.RegisterService;
import com.changhong.appserver.utils.TokenUtil;
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public String register(String userName, String passWord) {
		UserEntity user = userMapper.selectByName(userName);
		if (user == null) {
			// 为空
			user = new UserEntity();
			user.setName(userName);
			user.setPassword(passWord);
			String userToken = TokenUtil.getToken(userName);
			user.setUsertoken(userToken);
			Integer insertUser = userMapper.insertUser(user);
			if (insertUser > 0) {
				// 注册成功
				return Constant.succedCode;
			} else {
				//注册失败
				return Constant.errorCode;
			}
		} else {
			// 用户已经存在
			return Constant.userHasRegister;
		}
	}

}
