package com.order.system.common.model.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zh
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" }, ignoreUnknown = true)
public class RestfulRequest implements Request {
	private static final long serialVersionUID = -2363877433041183308L;

	@ApiModelProperty(value = "用户id", required = true, example = "1")
	@JsonProperty(value = "userId")
	private Long userId;

	@ApiModelProperty(value = "用户姓名", required = true, example = "1")
	@JsonProperty(value = "userName")
	private String userName;

	@ApiModelProperty(value = "用户账户", required = true, example = "1")
	@JsonProperty(value = "account")
	private String account;

	@ApiModelProperty(value = "用户性别", required = true, example = "1")
	@JsonProperty(value = "userSex")
	private int userSex;

	@ApiModelProperty(value = "用户手机号码", required = true, example = "1")
	@JsonProperty(value = "userPhone")
	private String userPhone;

	@ApiModelProperty(value = "用户注册时间", required = true, example = "1")
	@JsonProperty(value = "createDate")
	private Date createDate;

}
