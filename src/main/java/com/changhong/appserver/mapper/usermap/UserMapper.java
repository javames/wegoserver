package com.changhong.appserver.mapper.usermap;

import org.apache.ibatis.annotations.Insert;

import com.changhong.appserver.entity.UserEntity;

public interface UserMapper {

	@Insert("INSERT INTO user_info(name,headImage,authenticated,usertoken,password) VALUES(#{name}, #{headImage}, #{authenticated},#{usertoken},#{password})")
	void insertUser(UserEntity user);
	
}
  