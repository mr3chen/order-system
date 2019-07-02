package com.order.system.common.utils;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

	/* 随机字符串生成的方式（由字母和数字组成） */
	public static final int RANDOM_TYPE_NORMAL = 1;
	/* 随机字符串生成的方式（全部由数字组成） */
	public static final int RANDOM_TYPE_ALNUM = 2;
	/* 随机字符串生成的方式（全部由字母组成） */
	public static final int RANDOM_TYPE_ALPHA = 3;

	/**
	 * 浮点数格式化默认格式
	 */
	public static final String NUMBER_FORMAT_DEFAULT = "#.##";

	/**
	 * 判断str是null或者是""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else {
			if (str.equals("")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断str不是null并且不是""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (null != str && !"".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串对象是否为null或者只包含空白（包括包含空白符等）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串对象是否为不为null或者不只包含空白（包括包含空白符等）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * 格式化输出浮点数
	 * 
	 * @param number
	 * @return
	 */
	public static String numberFormat(Double number) {
		return numberFormat(number, NUMBER_FORMAT_DEFAULT);
	}

	/**
	 * 格式化输出浮点数
	 * 
	 * @param number
	 * @param format
	 * @return
	 */
	public static String numberFormat(Double number, String format) {
		if (number == null || format == null || "".equals(format)) {
			return "";
		}
		try {
			DecimalFormat df = new DecimalFormat(format);
			return df.format(number);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param len
	 *            随机字符串的长度
	 * @return
	 */
	public static String getRandomString(int len) {
		return getRandomString(len, RANDOM_TYPE_NORMAL);
	}

	/**
	 * 按指定的方式生成随机字符串
	 * 
	 * @param len
	 *            随机字符串的长度
	 * @param randomType
	 *            生成随机字符串的方式
	 * @return
	 */
	public static String getRandomString(int len, int randomType) {
		if (len < 1) {
			return "";
		}

		String str;

		if (randomType == RANDOM_TYPE_ALNUM) {
			str = "31045672892098312107654233402567810299871650243";
		} else if (randomType == RANDOM_TYPE_ALPHA) {
			str = "abcdefghjkmnpqrstuvwxyYXWVUTSRQPNMKJHGFEDCBAyxwvutsrqpnmkjhgfedcbaABCDEFGHJKMNPQRSTUVWXY";
		} else {
			str = "yxwvutsrqpnmkjhgfedcba1234567890ABCDEFGHJKMNPQRSTUVWXY0987654321ABCDEFGHJKMNPQRSTUVWXYabcdefghjkmnpqrstuvwxy";
		}

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			int index = rnd.nextInt(str.length());
			sb.append(str.charAt(index));
		}

		return sb.toString();
	}

	/**
	 * 检验字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static String validateString(String str) {
		return str == null ? "" : str;
	}

	public static void main(String[] args) {
		System.out.println(numberFormat(23.232353, "###.####"));

		String validateCode = StringUtil.getRandomString(4, StringUtil.RANDOM_TYPE_ALNUM);
		System.out.println(validateCode);
	}

	/**
	 * 匹配字符串中是否有目标字符
	 * 
	 * @param str
	 *            原字符串
	 * @param str1
	 *            需要匹配的字符串
	 * @return 目标字符串出现在原字符出现的位置,-1为找不到
	 */
	public static int queryString(String str, String str1) {
		return str.indexOf(str1);
	}
}
