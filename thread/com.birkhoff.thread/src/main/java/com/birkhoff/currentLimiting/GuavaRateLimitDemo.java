package com.birkhoff.currentLimiting;

import com.google.common.util.concurrent.RateLimiter;

import java.time.Instant;

/**
 * 借助guava实现令牌桶算法
 */
public class GuavaRateLimitDemo {
    public static void main(String[] args) {
        // 每秒产生 10 个令牌（每 100 ms 产生一个）
        RateLimiter rt = RateLimiter.create(10);
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                // 获取 1 个令牌
                rt.acquire();
                System.out.println("正常执行方法，ts:" + Instant.now());
            }).start();
        }
    }
}
