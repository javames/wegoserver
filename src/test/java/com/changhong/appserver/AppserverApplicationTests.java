package com.changhong.appserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.changhong.appserver.controller.HolloWorldController;
import com.changhong.appserver.utils.TokenUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppserverApplicationTests {

	protected static Logger logger=LoggerFactory.getLogger(AppserverApplicationTests.class);
	@Test
	public void contextLoads() {
		TokenUtil token=new TokenUtil();
//		String toek=token.getToken();
//		logger.debug(toek);
	}

}
