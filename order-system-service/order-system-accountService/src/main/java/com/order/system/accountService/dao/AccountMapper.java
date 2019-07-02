package com.order.system.accountService.dao;

import com.order.system.accountService.model.Account;
import com.order.system.common.core.Mapper;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends Mapper<Account> {

    int consumeBalance(@Param("userId") Integer userId, @Param("amount") Double amount);

    int returnReservedBalance(@Param("userId") Long userId, @Param("amount") Double amount);
}