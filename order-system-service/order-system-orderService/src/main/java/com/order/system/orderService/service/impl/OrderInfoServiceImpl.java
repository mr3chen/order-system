package com.order.system.orderService.service.impl;

import com.order.system.orderService.dao.OrderInfoMapper;
import com.order.system.orderService.model.OrderInfo;
import com.order.system.orderService.service.IOrderInfoService;
import com.order.system.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: zhonghao
* @date: 2019/01/28 10:07:34
* @description: OrderInfo服务实现
*/
@Service
@Transactional
public class OrderInfoServiceImpl extends AbstractService<OrderInfo> implements IOrderInfoService {
    @Resource
    private OrderInfoMapper tOrderInfoMapper;

}
