package com.order.system.productService.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Table(name = "t_product_stock_tcc")
public class ProductStockTcc {
    @Id
    @Column(name = "product_stock_tcc_id")
    private Integer productStockTccId;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品库存
     */
    private Long stack;

    /**
     * o:try  1:CONFIRM
     */
    private Integer status;

    /**
     * 超时时间
     */
    @Column(name = "expire_time")
    private OffsetDateTime expireTime;

    /**
     * 删除时间
     */
    @Column(name = "delete_time")
    private OffsetDateTime deleteTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private OffsetDateTime updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private OffsetDateTime createTime;

    public OffsetDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(OffsetDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public OffsetDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(OffsetDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getProductStockTccId() {
        return productStockTccId;
    }

    public void setProductStockTccId(Integer productStockTccId) {
        this.productStockTccId = productStockTccId;
    }

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品库存
     *
     * @return stack - 产品库存
     */
    public Long getStack() {
        return stack;
    }

    /**
     * 设置产品库存
     *
     * @param stack 产品库存
     */
    public void setStack(Long stack) {
        this.stack = stack;
    }

    /**
     * 获取o:try  1:CONFIRM
     *
     * @return status - o:try  1:CONFIRM
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置o:try  1:CONFIRM
     *
     * @param status o:try  1:CONFIRM
     */
    public void setStatus(Integer status) {
        this.status = status;
    }


}