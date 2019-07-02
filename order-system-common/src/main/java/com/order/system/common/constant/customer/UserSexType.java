package com.order.system.common.constant.customer;

public class UserSexType {

	/**
	 * 未知
	 */
	public static final int UNDEFINED = 0;

	/**
	 * 男
	 */
	public static final int MAN = 1;

	/**
	 * 女
	 */
	public static final int WOMEN = 2;

	public static Boolean isMan(int sex) {
		return MAN == sex;
	}

	public static Boolean isWomen(int sex) {
		return WOMEN == sex;
	}

}
