package com.order.system.accountService.service.impl;

import com.order.system.accountService.dao.AccountMapper;
import com.order.system.accountService.model.Account;
import com.order.system.accountService.service.IAccountService;
import com.order.system.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: zhonghao
* @date: 2019/01/29 16:43:13
* @description: Account服务实现
*/
@Service
@Transactional
public class AccountServiceImpl extends AbstractService<Account> implements IAccountService {
    @Resource
    private AccountMapper tAccountMapper;

}
