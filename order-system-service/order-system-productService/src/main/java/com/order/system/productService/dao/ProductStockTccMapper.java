package com.order.system.productService.dao;

import com.order.system.common.core.Mapper;
import com.order.system.productService.model.ProductStockTcc;
import org.apache.ibatis.annotations.Param;

public interface ProductStockTccMapper extends Mapper<ProductStockTcc> {
    int updateToConfirmationById(@Param("id") Integer id);
    int deleteTryingById(@Param("id") Integer id);
    int insertAndReturnTccId(ProductStockTcc productStockTcc);
}