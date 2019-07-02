package org.order.system.cacheService;

import com.order.system.cacheService.CacheApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheApplication.class)
// @Transactional
// @Rollback
public abstract class Tester {

}
