package com.changhong.appserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.appserver.constant.Constant;
import com.changhong.appserver.entity.UserEntity;
import com.changhong.appserver.mapper.UserMapper;
import com.changhong.appserver.service.RegisterService;
import com.changhong.appserver.utils.TokenUtil;

public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public String register(String userName, String passWord) {
		UserEntity user = userMapper.selectByNameAndPwd(userName, passWord);
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
				return Constant.register_SUCCESS;
			} else {
				return Constant.register_FAILURE;
			}
		} else {
			// 不为空
			return Constant.userHasRegister;
		}
	}

}
