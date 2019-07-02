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
package com.order.system.orderService.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.system.common.exception.RestStatusException;
import com.order.system.common.result.ServiceResult;
import com.order.system.orderService.common.StatusCode;
import com.order.system.orderService.common.exception.OrderServiceException;

/**
 * 全局异常处理
 * ControllerMethodResolver.
 * https://dzone.com/articles/global-exception-handling-with-controlleradvice
 * @see
 * @author zh
 */
@ControllerAdvice
public class ExceptionHandlers {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ServiceResult serverExceptionHandler(final Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		String message = "";
		if (exception instanceof OrderServiceException) {
			OrderServiceException customerServiceException = (OrderServiceException) exception;
			message = customerServiceException.getMessage();
		} else if (exception instanceof RestStatusException) {
			Integer errorCode = Integer.parseInt(exception.getMessage());
			String errorMsg = StatusCode.valueOfCode(errorCode).message();
			return ServiceResult.error(errorCode, errorMsg);
		} else {
			message = exception.getMessage()==null? "系统繁忙,请稍后重试":exception.getMessage();
		}
		return ServiceResult.error(message);
	}
}
