package com.order.system.customerService;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.system.customerService.CustomerApplication;


/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
// @Transactional
// @Rollback
public abstract class Tester {

}
