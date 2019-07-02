package com.order.system.productService.service;

import com.order.system.productService.model.ProductInfo;
import com.order.system.common.core.Service;


/**
 * @author: zhonghao
 * @date: 2019/01/28 14:17:47
 * @description: ProductInfo服务接口
 */
public interface IProductInfoService extends Service<ProductInfo> {

    public boolean updateInventory(Integer pid, Integer inventory);
}
