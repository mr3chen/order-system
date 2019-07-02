package com.order.system.productService.dao;

import com.order.system.common.core.Mapper;
import com.order.system.productService.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper extends Mapper<ProductInfo> {
    int updateInventory(Integer pid, Integer inventory);

    int consumeStock(Integer productId);

    int returnReservedStock(@Param("productId") Integer productId, @Param("stock") Long stock);

}