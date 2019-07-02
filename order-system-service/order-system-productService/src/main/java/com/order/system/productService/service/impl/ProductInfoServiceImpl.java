package com.order.system.productService.service.impl;

import com.order.system.common.Shift;
import com.order.system.productService.common.StatusCode;
import com.order.system.productService.common.exception.ProductServiceException;
import com.order.system.productService.dao.ProductInfoMapper;
import com.order.system.productService.model.ProductInfo;
import com.order.system.productService.service.IProductInfoService;
import com.order.system.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author: zhonghao
 * @date: 2019/01/28 14:17:47
 * @description: ProductInfo服务实现
 */
@Service
@Transactional
public class ProductInfoServiceImpl extends AbstractService<ProductInfo> implements IProductInfoService {
    @Resource
    private ProductInfoMapper tProductInfoMapper;


    @Override
    public boolean updateInventory(Integer pid, Integer inventory) {
        if (tProductInfoMapper.updateInventory(pid, inventory) < 0)
            Shift.fatal(StatusCode.PRODUCT_NOT_UPDATE);
        return true;
    }
}
