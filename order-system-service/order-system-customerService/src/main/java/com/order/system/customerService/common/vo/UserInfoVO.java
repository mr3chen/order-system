package com.order.system.customerService.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.order.system.common.model.response.RestfulResponse;
import com.order.system.common.utils.BeanUtils;
import com.order.system.customerService.model.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" }, ignoreUnknown = true)
public class UserInfoVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userName;

	private Integer userSex;

	private String userPhone;

	private Date createDate;

	private String account;

	public static UserInfoVO bulidUserInfoVO(UserInfo userInfo) {
		UserInfoVO userInfoVO = new UserInfoVO();
		BeanUtils.copyEntityProperties(userInfo, userInfoVO);
		return userInfoVO;
	}

}
