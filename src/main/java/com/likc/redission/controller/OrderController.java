package com.likc.redission.controller;

import com.likc.redission.util.RedisDelayedQueueUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderController {

    @Resource
    private RedisDelayedQueueUtils redisDelayedQueue;

    @GetMapping("add")
    public void add(@RequestParam Long second) {
        redisDelayedQueue.addQueue("123456", second, TimeUnit.SECONDS, "deliveryOrder");
    }

    @GetMapping("remove")
    public void remove(@RequestParam String key) {
        redisDelayedQueue.remove(key, "deliveryOrder");
    }

    @GetMapping("getAll")
    public void remove() {
        System.out.println(redisDelayedQueue.readAll("deliveryOrder"));
    }

}
