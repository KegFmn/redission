package com.likc.redission.consumer;

import com.likc.redission.util.RedisDelayedQueueUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class OrderConsumer implements CommandLineRunner {
    @Resource
    private RedisDelayedQueueUtils redisDelayedQueue;

    @Override
    public void run(String... args)  {
        String queueName = "deliveryOrder";
        log.info("启动监听队列线程" + queueName);
        new Thread(() -> {
            while (true) {
                try {
                    Object deliveryOrder = redisDelayedQueue.get(queueName);
                    log.info("消费：" + deliveryOrder.toString());
                } catch (Exception e) {
                    log.error(String.valueOf(e));
                }
            }
        }).start();
    }
}
