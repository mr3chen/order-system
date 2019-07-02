package com.order.system.accountService.controller;

import com.order.system.common.result.ServiceResult;
import com.order.system.accountService.model.Account;
import com.order.system.accountService.service.IAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhonghao
 * @date: 2019/01/29 16:43:13
 * @description: Account控制器
 */
@RestController
public class AccountController {
    @Resource
    private IAccountService accountService;

    /**
     * Account详情
     */
    @GetMapping("/queryAccountInfo/{userId}")
    public ServiceResult queryAccountInfo(@PathVariable Integer userId) {
        Account account = accountService.findBy("userId", userId);
        if (account == null) {
            return ServiceResult.error("查找对象不存在！");
        }
        return ServiceResult.success(account);
    }

}
