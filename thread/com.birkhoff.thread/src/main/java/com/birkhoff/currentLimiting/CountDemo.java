package com.birkhoff.currentLimiting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 限流-计数器方式
 */
public class CountDemo {
    private static int REQCOUNT = 0;

    private static final int LIMIT = 100;

    private static final long INTERVAL = 1000;

    private static long CURRENTTIMESTAMP = System.currentTimeMillis();

    private static boolean canAccess(){
        long now = System.currentTimeMillis();
        if(now <= CURRENTTIMESTAMP + INTERVAL){
            REQCOUNT++;
            return REQCOUNT <= LIMIT;
        }
        CURRENTTIMESTAMP = now;
        REQCOUNT = 1;
        return true;
    }

    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newFixedThreadPool(200);
        Work work = new Work();
        for(int i = 0 ; i < 10000 ; i++){
            executorService.submit(work);
        }
        executorService.shutdown();
    }

    static class Work implements Runnable{
        @Override
        public void run() {
            if(canAccess()){
                System.out.println(Thread.currentThread().getName() + "允许通过");
            } else {
                System.out.println(Thread.currentThread().getName() + "你被限制住了");
            }
        }
    }

}
