package com.order.system.common;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

import com.order.system.common.exception.RestStatusException;
import com.order.system.common.model.response.ErrorEntity;

/**
 * @author Zhao Junjian
 */
public final class Shift {

	private Shift() {
	}

	/**
	 * 抛出具体的{@code RestStatus}异常
	 *
	 * @param status
	 *            自定义异常实体
	 * @param details
	 *            额外添加至details字段中的任意实体, 最终会被解析成JSON
	 */
	public static void fatal(RestStatus status) {
		checkNotNull(status);
		String errorCode = String.valueOf(status.code());
		throw new RestStatusException(errorCode);
	}
}