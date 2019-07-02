package com.order.system.common.result;

/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
import lombok.Data;

import org.springframework.http.HttpStatus;

import com.order.system.common.exception.CommonErrorCode;

import java.io.Serializable;

/**
 * AjaxResult .
 *
 * @author xiaoyu
 */
@Data
public class ServiceResult implements Serializable {

	private static final long serialVersionUID = -2792556188993845048L;

	private Integer code;

	private String message;

	private Object data;

	/**
	 * Instantiates a new Soul result.
	 */
	public ServiceResult() {

	}

	/**
	 * Instantiates a new Soul result.
	 *
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param data
	 *            the data
	 */
	public ServiceResult(final Integer code, final String message, final Object data) {

		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * return success.
	 *
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult success() {
		return success("");
	}

	/**
	 * return success.
	 *
	 * @param msg
	 *            msg
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult success(final String msg) {
		return success(msg, null);
	}

	/**
	 * return success.
	 *
	 * @param data
	 *            this is result data.
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult success(final Object data) {
		return success(null, data);
	}

	/**
	 * return success.
	 *
	 * @param msg
	 *            this ext msg.
	 * @param data
	 *            this is result data.
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult success(final String msg, final Object data) {
		return get(CommonErrorCode.SUCCESSFUL, msg, data);
	}

	/**
	 * return error .
	 *
	 * @param msg
	 *            error msg
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult error(final String msg) {
		return error(CommonErrorCode.ERROR, msg);
	}

	/**
	 * return error .
	 *
	 * @param code
	 *            error code
	 * @param msg
	 *            error msg
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult error(final int code, final String msg) {
		return get(code, msg, null);
	}

	/**
	 * return timeout .
	 *
	 * @param msg
	 *            error msg
	 * @return {@linkplain ServiceResult}
	 */
	public static ServiceResult timeout(final String msg) {
		return error(HttpStatus.REQUEST_TIMEOUT.value(), msg);
	}

	private static ServiceResult get(final int code, final String msg, final Object data) {
		return new ServiceResult(code, msg, data);
	}

}
