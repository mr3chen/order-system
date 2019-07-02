package com.order.system.accountService.dao;

import com.order.system.accountService.model.UserBanlanceTcc;
import com.order.system.common.core.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserBanlanceTccMapper extends Mapper<UserBanlanceTcc> {

    int deleteTryingById(@Param("id") Long id);

    int updateToConfirmationById(@Param("id") Long id);
}