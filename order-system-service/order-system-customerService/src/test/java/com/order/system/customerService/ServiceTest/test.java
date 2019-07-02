package com.order.system.customerService.ServiceTest;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.system.customerService.model.UserInfo;

public class test {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
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
	}

}
