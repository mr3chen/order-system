package com.order.system.customerService.ServiceTest;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.system.customerService.Tester;
import static org.junit.Assert.*;
import com.order.system.customerService.model.UserInfo;
import com.order.system.customerService.service.IUserInfoService;

public class IUserInfoServiceTest extends Tester {

	@Resource
	IUserInfoService userInfoService;

	@Test
	public void testInsert() throws JsonProcessingException {
		UserInfo model = new UserInfo();
		model.setAccount("992308966");
		model.setCreateDate(new Date());
		model.setPassword("xxxxx1111");
		model.setUserName("zh");
		model.setUserPhone("18318558888");
		model.setSalt("aaaaa");
		model.setUserSex(1);
		model.setAccount("111111");
		
		System.out.println(new ObjectMapper().writeValueAsString(model));
		
		boolean result = userInfoService.save(model);
		assertTrue(result);
	}
}
