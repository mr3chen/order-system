package com.order.system.productService.service.impl;

import com.google.common.base.Preconditions;
import com.order.system.common.Shift;
import com.order.system.common.exception.ReservationExpireException;
import com.order.system.productService.common.StatusCode;
import com.order.system.productService.common.constant.ProductStatusType;
import com.order.system.productService.common.domain.type.TccStatus;
import com.order.system.productService.dao.ProductInfoMapper;
import com.order.system.productService.dao.ProductStockTccMapper;
import com.order.system.productService.model.ProductInfo;
import com.order.system.productService.model.ProductStockTcc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.OffsetDateTime;
import java.util.Optional;


/**
 * @author: zhonghao
 * @date: 2019/02/22 16:13:51
 * @description: ProductStockTcc服务实现
 */
@Service("tccService")
@Transactional
public class ProductStockTccService {
    @Resource
    private ProductStockTccMapper tProductStockTccMapper;

    @Resource
    private ProductInfoMapper productInfoMapper;


    public ProductStockTcc trying(long productId) {
        return trying(productId, 15);
    }

    public ProductStockTcc trying(long productId, long expireSeconds) {
        Preconditions.checkArgument(productId > 0);
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        ProductStatusType.validProductStatus(productInfo);
        return trying(productInfo, expireSeconds);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProductStockTcc trying(ProductInfo product, long expireSeconds) {
        Preconditions.checkNotNull(product);
        Preconditions.checkNotNull(product.getProductId());
        Preconditions.checkArgument(expireSeconds > 0);

        //consume Stock
        final int isLock = productInfoMapper.consumeStock(product.getProductId());
        if (isLock == 0) {
            Shift.fatal(StatusCode.INSUFFICIENT_PRODUCT);
        }

        //insert tcc
        final ProductStockTcc tcc = new ProductStockTcc();
        // 每次下单默认只能1个
        tcc.setStack(1L);
        tcc.setStatus(TccStatus.TRY.getStatus());
        tcc.setProductId(product.getProductId());
        tcc.setExpireTime(OffsetDateTime.now().plusSeconds(expireSeconds));
        tProductStockTccMapper.insertAndReturnTccId(tcc);
        return tcc;
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirmReservation(Integer id) {
        Preconditions.checkArgument(id > 0);
        final ProductStockTcc productStockTcc = tProductStockTccMapper.selectByPrimaryKey(id);
        if (productStockTcc == null) {
            // 无法获取说明不存在或者是已经被补偿（有可能是在try阶段失败了）
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }
        Optional.ofNullable(productStockTcc).filter(x -> x.getStatus() == TccStatus.TRY.getStatus()).ifPresent(v -> {
            final int isSuccessful = tProductStockTccMapper.updateToConfirmationById(id);
            // 如果返回0则说明已经被撤销
            if (isSuccessful == 0) {
                throw new ReservationExpireException("resource " + id + " has been cancelled");
            }
        });
    }


    @Transactional(rollbackFor = Exception.class)
    public void cancelReservation(Long id) {
        Preconditions.checkNotNull(id);
        final ProductStockTcc productStockTcc = tProductStockTccMapper.selectByPrimaryKey(id);
        // 无法获取说明不存在或者是已经被补偿
        if (productStockTcc == null) {
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }
        cancelReservation(productStockTcc);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelReservation(ProductStockTcc pTcc) {
        Preconditions.checkNotNull(pTcc);
        Preconditions.checkNotNull(pTcc.getProductId());
        Preconditions.checkNotNull(pTcc.getProductStockTccId());
        Preconditions.checkNotNull(pTcc.getStatus());
        Preconditions.checkNotNull(pTcc.getStack());

        Optional.ofNullable(pTcc).filter(x -> x.getStatus() == TccStatus.TRY.getStatus()).ifPresent(v -> {
            int isSuccessDel = tProductStockTccMapper.deleteTryingById(pTcc.getProductStockTccId());
            if (isSuccessDel > 0) {
                int isSuccessful = productInfoMapper.returnReservedStock(pTcc.getProductStockTccId(), pTcc.getStack());
                if (isSuccessful == 0) {
                    throw new IllegalStateException("stock reservation id " + pTcc.getProductStockTccId() + " was succeeded in deleting, but failed to make compensation for product id " + pTcc.getProductId());
                }
            }
        });


    }


}
