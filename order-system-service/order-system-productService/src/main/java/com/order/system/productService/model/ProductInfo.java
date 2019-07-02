package com.order.system.productService.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_product_info")
public class ProductInfo {
	@Id
     @Column(name = "product_id")
     private Integer productId;

     /**
      * 产品名字
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * 产品库存
     */
    private Long inventory;

    /**
     * 状态(-1:删除，1：上架，2：下架)
     */
    private Integer status;

    /**
     * 创建产品时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新产品时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品名字
     *
     * @return product_name - 产品名字
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名字
     *
     * @param productName 产品名字
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品价格
     *
     * @return price - 产品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置产品价格
     *
     * @param price 产品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取产品库存
     *
     * @return inventory - 产品库存
     */
    public Long getInventory() {
        return inventory;
    }

    /**
     * 设置产品库存
     *
     * @param inventory 产品库存
     */
    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取状态(-1:删除，1：上架，2：下架)
     *
     * @return status - 状态(-1:删除，1：上架，2：下架)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(-1:删除，1：上架，2：下架)
     *
     * @param status 状态(-1:删除，1：上架，2：下架)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建产品时间
     *
     * @return create_date - 创建产品时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建产品时间
     *
     * @param createDate 创建产品时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新产品时间
     *
     * @return update_date - 更新产品时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新产品时间
     *
     * @param updateDate 更新产品时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}