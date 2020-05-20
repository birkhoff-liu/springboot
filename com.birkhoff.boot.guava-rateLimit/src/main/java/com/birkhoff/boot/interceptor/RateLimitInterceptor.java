package com.birkhoff.boot.interceptor;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RateLimitInterceptor extends AbstractInterceptor {
    public static final int REQUEST_COUNT = 1;
    /*** set the number of requests per second */
    private static final RateLimiter rateLimiter = RateLimiter.create(REQUEST_COUNT);

    @Override
    protected boolean preHandle(HttpServletRequest request) {
        if (!rateLimiter.tryAcquire()) {
            System.out.println(">>>>>>>>>> 亲！请稍后重试！");
            return false;
        }
        System.out.println(">>>>>>>> 恭喜您下单成功！");
        return true;
    }
}
