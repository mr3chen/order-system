package com.order.system.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer userId;

    private String userName;

    private Integer userSex;

    private String userPhone;

    private Date createDate;

    private String account;

}
