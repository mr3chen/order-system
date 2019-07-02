package com.order.system.customerService.common.query;

import java.util.Date;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
	private String phone;

	private String account;

	@NotBlank(message = "用户密码不能为空")
	private String password;
}
