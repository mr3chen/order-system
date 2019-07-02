package com.order.system.orderService.model;

import com.order.system.orderService.model.type.OrderStatus;
import javafx.beans.binding.IntegerBinding;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_order_info")
public class OrderInfo {
	@Id
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     *订单状态, 0为支付中, 1为交易完成, 2为全部资源已被撤销, 3为资源确认冲突
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 支付状态(-1:未支付，1：已支付)
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单创建时间
     *
     * @return create_date - 订单创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置订单创建时间
     *
     * @param createDate 订单创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取支付状态(-1:未支付，1：已支付)
     *
     * @return pay_status - 支付状态(-1:未支付，1：已支付)
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态(-1:未支付，1：已支付)
     *
     * @param payStatus 支付状态(-1:未支付，1：已支付)
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取订单金额
     *
     * @return amount - 订单金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置订单金额
     *
     * @param amount 订单金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}