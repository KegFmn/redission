package com.likc.redission;

import com.likc.redission.util.RedisDelayedQueueUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedissionApplicationTests {

    @Resource
    private RedisDelayedQueueUtils redisDelayedQueue;

    @Test
    void contextLoads() {
        redisDelayedQueue.addQueue("123456", 60, TimeUnit.SECONDS, "deliveryOrder");
    }

}
