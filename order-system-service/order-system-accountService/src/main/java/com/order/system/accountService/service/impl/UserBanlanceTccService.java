package com.order.system.accountService.service.impl;

import com.google.common.base.Preconditions;
import com.order.system.accountService.common.StatusCode;
import com.order.system.accountService.common.domain.type.TccStatus;
import com.order.system.accountService.dao.AccountMapper;
import com.order.system.accountService.dao.UserBanlanceTccMapper;
import com.order.system.accountService.model.Account;
import com.order.system.accountService.model.UserBanlanceTcc;
import com.order.system.common.Shift;
import com.order.system.common.exception.ReservationExpireException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;


/**
 * @author: zhonghao
 * @date: 2019/01/29 16:43:13
 * @description: UserBanlanceTccService  用户账户余额实现
 */
@Service
@Transactional
public class UserBanlanceTccService {
    @Resource
    private UserBanlanceTccMapper userBanlanceTccMapper;

    @Resource
    private AccountMapper accountMapper;

    public UserBanlanceTcc trying(Long userId, Double amount) {
        return trying(userId, amount, 15);
    }

    public UserBanlanceTcc trying(Long userId, Double amount, long expireSeconds) {
        Preconditions.checkArgument(userId > 0);
        Preconditions.checkArgument(amount > 0);
        Preconditions.checkArgument(expireSeconds > 0);
        Account account = new Account();
        account.setUserId(Integer.parseInt(userId.toString()));
        Account a = accountMapper.selectOne(account);
        if (a == null)
            Shift.fatal(StatusCode.USER_NOT_EXISTS);
        return trying(a, amount, expireSeconds);

    }

    public UserBanlanceTcc trying(Account account, Double amount, long expireSeconds) {
        final int isLock = accountMapper.consumeBalance(account.getUserId(), amount);
        if (isLock == 0)
            Shift.fatal(StatusCode.INSUFFICIENT_BALANCE);
        UserBanlanceTcc tcc = new UserBanlanceTcc();
        tcc.setAmount(new BigDecimal(amount));
        tcc.setStatus(TccStatus.TRY.getStatus());
        tcc.setUserId(Long.parseLong(account.getUserId().toString()));
        tcc.setExpireTime(OffsetDateTime.now().plusSeconds(expireSeconds));
        userBanlanceTccMapper.insert(tcc);
        return tcc;
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirmReservation(Long id) {
        Preconditions.checkArgument(id > 0);
        UserBanlanceTcc userBanlanceTcc = userBanlanceTccMapper.selectByPrimaryKey(id);
        if (userBanlanceTcc == null) {
            // 无法获取说明不存在或者是已经被补偿（有可能是在try阶段失败了）
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }
        Optional.ofNullable(userBanlanceTcc).filter(x -> x.getStatus() == TccStatus.TRY.getStatus()).ifPresent(v -> {
            int isSuccessful = userBanlanceTccMapper.updateToConfirmationById(id);
            // 如果返回0则说明已经被撤销
            if (isSuccessful == 0) {
                throw new ReservationExpireException("resource " + id + " has been cancelled");
            }
        });

    }


    @Transactional(rollbackFor = Exception.class)
    public void cancelReservation(Long id) {
        Preconditions.checkNotNull(id);
        final UserBanlanceTcc balanceTcc = userBanlanceTccMapper.selectByPrimaryKey(id);
        // 无法获取说明不存在或者是已经被补偿
        if (balanceTcc == null) {
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }
        cancelReservation(balanceTcc);
    }


    @Transactional(rollbackFor = Exception.class)
    public void cancelReservation(UserBanlanceTcc res) {
        Preconditions.checkNotNull(res);
        Preconditions.checkNotNull(res.getId());
        Preconditions.checkNotNull(res.getAmount());
        Preconditions.checkNotNull(res.getUserId());
        Preconditions.checkNotNull(res.getStatus());

        // 只能补偿在TRY阶段
        Optional.ofNullable(res).filter(x -> x.getStatus() == TccStatus.TRY.getStatus()).ifPresent(v -> {
                    // 依赖行锁, 必须开启事务
                    int isSuccessDel = userBanlanceTccMapper.deleteTryingById(res.getId());
                    if (isSuccessDel > 0) {
                        //删除成功后才能进行补偿
                        int isSuccessful = accountMapper.returnReservedBalance(res.getUserId(), res.getAmount().doubleValue());
                        if (isSuccessful == 0) {
                            throw new IllegalStateException("balance reservation id " + res.getId() + " was succeeded in deleting, but failed to make compensation for user id " + res.getUserId());
                        }
                    }
                }
        );
    }


}
