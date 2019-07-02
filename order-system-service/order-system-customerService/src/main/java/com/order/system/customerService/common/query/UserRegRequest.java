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
public class UserRegRequest {
	@NotBlank(message = "用户名不能为空")
	@Length(min = 1, max = 10, message = "用户名长度必须在1-10之间")
	private String userName;

	private Integer userSex;

	@NotBlank(message = "用户手机号码不能为空")
	private String userPhone;

	@NotBlank(message = "密码不能为空")
	private String password;

	@NotBlank(message = "账号不能为空")
	private String account;
}
