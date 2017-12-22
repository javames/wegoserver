package com.changhong.appserver.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changhong.appserver.entity.UserEntity;
import com.changhong.appserver.mapper.UserMapper;

@RestController
public class HolloWorldController {
	protected static Logger logger=LoggerFactory.getLogger(HolloWorldController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/hello")
    public String index() {
		System.out.println("hello");
		logger.debug("访问hello");  
		userMapper.insertUser(new UserEntity("Tom",1, "1231231","454545","456465dd","123456"));
        return "Hello World";
    }
	
	 @RequestMapping("/add")
	    public void save(UserEntity user) {
		 	String h;
	    	userMapper.insertUser(user);
	    }
}
