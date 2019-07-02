package com.order.system.productService.service.impl;

import com.order.system.productService.dao.ProductStockTccMapper;
import com.order.system.productService.model.ProductStockTcc;
import com.order.system.productService.service.IProductStockTccService;
import com.order.system.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: zhonghao
* @date: 2019/02/22 16:13:51
* @description: ProductStockTcc服务实现
*/
@Service
@Transactional
public class ProductStockTccServiceImpl extends AbstractService<ProductStockTcc> implements IProductStockTccService {
    @Resource
    private ProductStockTccMapper tProductStockTccMapper;




}
