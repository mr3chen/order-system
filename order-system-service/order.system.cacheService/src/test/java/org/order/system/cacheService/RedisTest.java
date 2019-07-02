package org.order.system.cacheService;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.system.cacheService.client.RedisClient;
import com.order.system.cacheService.common.constant.RedisKeyFormat;
import com.order.system.cacheService.model.UserInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public class RedisTest extends Tester {

    @Autowired
    RedisClient redisClient;


    @Test
    public void testSet() {
        try {
            redisClient.set("", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet() {
        try {
            UserInfoVO u = (UserInfoVO)redisClient.get(String.format(RedisKeyFormat.CUSTOMER_LOGIN, "5Sys3SW9"));

//            System.out.println(JSON.toJSONString(bya5vEsd));
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//           // Map u = new ObjectMapper().readValue(JSON.toJSONString(bya5vEsd), Map.class);
//            UserInfoVO u =new ObjectMapper().readValue(JSON.toJSONString(bya5vEsd),UserInfoVO.class);
            System.out.println(u.getAccount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
