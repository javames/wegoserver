package com.changhong.appserver.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.changhong.appserver.entity.UserEntity;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
//		UserMapper.insertUser(new UserEntity("Tom",1, "1231231","454545","456465dd","ssss"));
//		UserMapper.insertUser(new UserEntity("bb",1, "1231231","454545","456465dd","sssss"));
//		UserMapper.insertUser(new UserEntity("cc",1, "1231231","454545","456465dd","sssssss"));
		UserEntity user = new UserEntity();
		user.setName("Tom");
		user.setPassword("123456");
		UserEntity userEntitys = userMapper.selectByNameAndPwd("Tom","123456");
		System.out.println(userEntitys.toString());
//		Assert.assertEquals(3, UserMapper.getAll().size());
	}
	

}
