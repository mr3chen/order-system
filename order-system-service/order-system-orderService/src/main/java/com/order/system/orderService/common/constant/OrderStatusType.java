package com.order.system.orderService.common.constant;

import java.util.Objects;

/**
 * 订单状态
 * 
 * @author zhongh2
 *
 */
public class OrderStatusType {
	/**
	 * 取消
	 */
	public static final Integer CANCEL = -1;

	/**
	 * 已发货
	 */
	public static final Integer SEND = 1;

	/**
	 * 待发货
	 */
	public static final Integer WAIT_SEND = 2;

	/**
	 * 正在配送
	 */
	public static final Integer IS_THE_SHIPPING = 3;

	/**
	 * 交易完成
	 */
	public static final Integer CLOSE_THE_DEAL = 4;

	/**
	 * 订单状态是否是取消状态
	 * 
	 * @return
	 */
	public static boolean isOrderStatusForCancel(Integer orderStatus) {
		return Objects.equals(orderStatus, CANCEL);
	}

	/**
	 * 订单状态是否是配送状态
	 * 
	 * @return
	 */
	public static boolean isOrderStatusForSend(Integer orderStatus) {
		return Objects.equals(orderStatus, SEND);
	}

	/**
	 * 订单状态是否是待发货状态
	 * 
	 * @return
	 */
	public static boolean isOrderStatusForWaitSend(Integer orderStatus) {
		return Objects.equals(orderStatus, WAIT_SEND);
	}

	/**
	 * 订单状态是否是交易完成状态
	 * 
	 * @return
	 */
	public static boolean isOrderStatusForCloseTheDeal(Integer orderStatus) {
		return Objects.equals(orderStatus, CLOSE_THE_DEAL);
	}

}
