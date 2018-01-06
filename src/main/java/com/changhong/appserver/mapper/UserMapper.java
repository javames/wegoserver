package com.changhong.appserver.mapper;

import org.apache.ibatis.annotations.Param;

import com.changhong.appserver.entity.UserEntity;

public interface UserMapper {
	
	//插入一个用户
	Integer insertUser(UserEntity user);
	
	//查找根据uid查找用户
	UserEntity selectByUid(Integer id);
	
	//根据usertoken查找用户
	UserEntity selectByUtoken(String userToken);
	
	//根据用户名和密码查找用户
	UserEntity selectByNameAndPwd(@Param("name") String name,@Param("password")String password);
	
	//根据用户名查找用户
	UserEntity selectByName(@Param("name")String name);
	
	//修改用户的信息
	void updateUserEntityByUid(Integer uId);
	
	//删除用户
	void deleteUserByUid(Integer uId);
	
	//修改用户头像
	void updataUserEntityByToken(@Param("usertoken")String usertoken,@Param("headImage")String headImage);
}
  