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
package com.order.system.customerService.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.system.common.exception.ServiceException;
import com.order.system.common.result.ServiceResult;
import com.order.system.customerService.common.exception.CustomerServiceException;

/**
 * ControllerMethodResolver.
 * https://dzone.com/articles/global-exception-handling-with-controlleradvice
 * 
 * @see 全局异常处理
 * @author zh
 */
@ControllerAdvice
public class ExceptionHandlers {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ServiceResult serverExceptionHandler(final Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		String message;
		if (exception instanceof CustomerServiceException) {
			CustomerServiceException customerServiceException = (CustomerServiceException) exception;
			message = customerServiceException.getMessage();
		} else {
			message = StringUtils.isNotBlank(exception.getMessage()) ? exception.getMessage() : "系统繁忙,请稍后重试";
		}
		return ServiceResult.error(message);
	}
}
