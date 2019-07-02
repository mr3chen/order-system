package com.order.system.accountService.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_account")
public class Account {
	@Id
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 用户余额
     */
    private BigDecimal balance;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 账户状态(-1:冻结，1：正常)
     */
    private Byte status;

    /**
     * @return account_id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取用户余额
     *
     * @return balance - 用户余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置用户余额
     *
     * @param balance 用户余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取账户状态(-1:冻结，1：正常)
     *
     * @return status - 账户状态(-1:冻结，1：正常)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置账户状态(-1:冻结，1：正常)
     *
     * @param status 账户状态(-1:冻结，1：正常)
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}