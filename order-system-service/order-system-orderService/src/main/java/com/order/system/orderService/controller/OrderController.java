package com.order.system.orderService.controller;

import com.order.system.common.result.ServiceResult;
import com.order.system.orderService.common.query.PaymentRequest;
import com.order.system.orderService.common.query.PlaceOrderRequest;
import com.order.system.orderService.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhonghao
 * @date: 2019/01/28 10:07:34
 * @description: OrderInfo控制器
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "下单", notes = "生成预订单")
    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public ServiceResult placeOrder(@Validated @RequestBody PlaceOrderRequest request, BindingResult result) {
        return orderService.placeOrder(request);
    }


    @ApiOperation(value = "确认下单", notes = "生成预订单")
    @RequestMapping(value = "/placeOrder/confirmation", method = RequestMethod.POST)
    public ServiceResult confirmation(@Validated @RequestBody PaymentRequest request, BindingResult result) {
        return orderService.confirmation(request);
    }

}
