package com.order.system.accountService.controller;

import com.order.system.accountService.common.model.Participant;
import com.order.system.accountService.common.model.request.BalanceReservationRequest;
import com.order.system.accountService.common.model.response.ReservationResponse;
import com.order.system.accountService.model.UserBanlanceTcc;
import com.order.system.accountService.service.IAccountService;
import com.order.system.accountService.service.impl.UserBanlanceTccService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.OffsetDateTime;

/**
 * @author: zhonghao
 * @date: 2019/01/29 16:43:13
 * @description: Account控制器
 */
@RestController
public class AccountBanlanceReservationController {
    @Resource
    private IAccountService accountService;

    private static final String RESERVATION_URI = "/banlance/reservation";

    public static final String API_PREFIX = "/api/v1";

    @Value("${spring.application.name}")
    private String applicationName;

    @Resource
    private UserBanlanceTccService userBanlanceTccService;


    @ApiOperation(value = "预留余额", notes = "")
    @RequestMapping(value = RESERVATION_URI, method = RequestMethod.POST)
    public ReservationResponse reserve(@Valid @RequestBody BalanceReservationRequest request, BindingResult error) {
        UserBanlanceTcc balanceTcc = userBanlanceTccService.trying(request.getUserId(), request.getAmount());
        final Long tccId = balanceTcc.getId();
        final OffsetDateTime expireTime = balanceTcc.getExpireTime();
        final Participant participant = new Participant("http://" + applicationName + API_PREFIX + RESERVATION_URI + "/" + tccId, expireTime);
        return new ReservationResponse(participant);
    }

    @ApiOperation(value = "确认预留余额", notes = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = RESERVATION_URI + "/{reservationId}", method = RequestMethod.PUT)
    public void confirm(@PathVariable Long reservationId) {
        userBanlanceTccService.confirmReservation(reservationId);
    }

    @ApiOperation(value = "撤销预留余额", notes = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = RESERVATION_URI + "/{reservationId}", method = RequestMethod.DELETE)
    public void cancel(@PathVariable Long reservationId) {
        userBanlanceTccService.cancelReservation(reservationId);
    }

}
