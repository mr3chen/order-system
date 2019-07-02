package com.order.system.productService.common.constant;

import com.order.system.common.Shift;
import com.order.system.productService.common.StatusCode;
import com.order.system.productService.model.ProductInfo;

public class ProductStatusType {
    /**
     * 删除
     */
    public static final Integer DEL = -1;

    /**
     * 正常
     */
    public static final Integer NORMAL = 1;

    /**
     * 下架
     */
    public static final Integer OUT_STOCK = 2;

    public static void validProductStatus(ProductInfo productInfo) {
        if (productInfo == null) {
            Shift.fatal(StatusCode.PRODUCT_NOT_EXISTS);
        } else if (DEL == productInfo.getStatus()) {
            Shift.fatal(StatusCode.PRODUCT_DEL);
        } else if (OUT_STOCK == productInfo.getStatus()) {
            Shift.fatal(StatusCode.PRODUCT_OUT_STOCK);
        }
    }

}
