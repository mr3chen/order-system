package com.order.system.customerService.service;

import com.order.system.customerService.common.query.UserRegRequest;
import com.order.system.customerService.common.vo.UserInfoVO;
import com.order.system.customerService.model.UserInfo;
import com.order.system.common.core.Service;
import com.order.system.common.result.ServiceResult;

/**
 * @author: zhonghao
 * @date: 2019/01/23 11:36:32
 * @description: UserInfo服务接口
 */
public interface IUserInfoService extends Service<UserInfo> {
	boolean register(UserRegRequest userInfoQuery);

	ServiceResult loginByPhoneORAccount(String phone, String account, String password);
}
