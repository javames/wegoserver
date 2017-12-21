package com.changhong.appserver.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.changhong.appserver.entity.UserEntity;
import com.changhong.appserver.mapper.usermap.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insertUser(new UserEntity("Tom",1, "1231231","454545","456465dd","ssss"));
		UserMapper.insertUser(new UserEntity("bb",1, "1231231","454545","456465dd","sssss"));
		UserMapper.insertUser(new UserEntity("cc",1, "1231231","454545","456465dd","sssssss"));

//		Assert.assertEquals(3, UserMapper.getAll().size());
	}
	

}
