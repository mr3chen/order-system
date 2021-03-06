package com.order.system.customerService.common.constant;

/**
 * @author: 会跳舞的机器人
 * @date: 2017/7/6 09:45
 * @description: 项目常量
 */
public final class ProjectConstant {
	public static final String BASE_PACKAGE = "com.order.system.customerService";// 项目基础包名称，根据自己公司的项目修改

	public static final String MAPPER_BASE_PACKAGE = "com.order.system.common";// 项目基础包名称，根据自己公司的项目修改
	
	
	public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";// Model所在包
	public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";// Mapper所在包
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";// Service所在包
	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";// ServiceImpl所在包
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";// Controller所在包

	public static final String MAPPER_INTERFACE_REFERENCE = MAPPER_BASE_PACKAGE + ".core.Mapper";// Mapper插件基础接口的完全限定名
}
