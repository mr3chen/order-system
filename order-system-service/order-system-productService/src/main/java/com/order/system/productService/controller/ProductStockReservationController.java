package com.order.system.productService.controller;

import com.order.system.common.result.ServiceResult;
import com.order.system.productService.common.model.Participant;
import com.order.system.productService.common.model.request.StockReservationRequest;
import com.order.system.productService.common.model.response.ReservationResponse;
import com.order.system.productService.model.ProductStockTcc;
import com.order.system.productService.service.IProductInfoService;
import com.order.system.productService.service.impl.ProductStockTccService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.OffsetDateTime;

/**
 * @author: zhonghao
 * @date: 2019/01/28 14:17:47
 * @description: ProductInfo控制器
 */
@RestController
@RequestMapping(value = ProductStockReservationController.API_PREFIX, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ProductStockReservationController {

    private static final String RESERVATION_URI = "/stocks/reservation";
    public static final String API_PREFIX = "/api/v1";

    @Value("${spring.application.name}")
    private String applicationName;

    @Resource
    private IProductInfoService productInfoService;

    @Resource
    private ProductStockTccService tccService;

    @ApiOperation(value = "预留库存", notes = "")
    @RequestMapping(value = RESERVATION_URI, method = RequestMethod.POST)
    public ServiceResult reserve(@Valid @RequestBody StockReservationRequest request, BindingResult error) {
        final ProductStockTcc stockTcc = tccService.trying(request.getProductId());
        final Integer tccId = stockTcc.getProductStockTccId();
        final OffsetDateTime expireTime = stockTcc.getExpireTime();
        final Participant participant = new Participant("http://" + applicationName + API_PREFIX + RESERVATION_URI + "/" + tccId, expireTime);
        return ServiceResult.success(participant);
    }


    @ApiOperation(value = "确认预留库存", notes = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = RESERVATION_URI + "/{reservationId}", method = RequestMethod.PUT)
    public void confirm(@PathVariable Integer reservationId) {
        tccService.confirmReservation(reservationId);
    }

    @ApiOperation(value = "撤销预留库存", notes = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = RESERVATION_URI + "/{reservationId}", method = RequestMethod.DELETE)
    public void cancel(@PathVariable Long reservationId) {
        tccService.cancelReservation(reservationId);
    }

}
