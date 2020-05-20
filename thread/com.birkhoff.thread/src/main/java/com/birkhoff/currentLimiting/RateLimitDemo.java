package com.birkhoff.currentLimiting;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * RateLimiter使用的是一种叫令牌桶的流控算法，
 * RateLimiter会按照一定的频率往桶里扔令牌，
 * 线程拿到令牌才能执行，
 * 比如你希望自己的应用程序QPS不要超过1000，
 * 那么RateLimiter设置1000的速率后，就会每秒往桶里扔1000个令牌。
 */
public class RateLimitDemo {
    RateLimiter rateLimiter = RateLimiter.create(10);

    public void doPay(String name) {
        if (rateLimiter.tryAcquire()) {
            System.out.println(name + "支付成功");
        } else {
            System.out.println(name + "支付失败请求繁忙，请稍后重试");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimitDemo app = new RateLimitDemo();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Random random = new Random(10);
        for (int i = 0; i < 20; i++) {
            final int fi = i;
            Thread t = new Thread(() -> {
                try {
                    countDownLatch.await();
                    Thread.sleep(random.nextInt(1000));
                    app.doPay("Thread-" + fi + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        countDownLatch.countDown();


    }

}
