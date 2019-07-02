package com.order.system.accountService.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_banlance_tcc")
public class UserBanlanceTcc {
    @Id
    @Column(name = "tuser_balance_tcc_id")
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "tuser_balance_tcc_create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "tuser_balance_tcc_update_time")
    private Date updateTime;

    /**
     * 删除时间
     */
    @Column(name = "tuser_balance_tcc_delete_time")
    private Date deleteTime;

    /**
     * 过期时间
     */
    @Column(name = "tuser_balance_tcc_expire_time")
    private OffsetDateTime expireTime;

    /**
     * 金额
     */
    @Column(name = "tuser_balance_tcc_amount")
    private BigDecimal amount;

    /**
     * 状态
     */
    @Column(name = "tuser_balance_tcc_status")
    private Integer status;

    /**
     * 用户id
     */
    @Column(name = "tuser_balance_tcc_t_user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public OffsetDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(OffsetDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}