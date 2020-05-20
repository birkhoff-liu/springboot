package com.birkhoff.concurrent2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("开始新一轮比赛跑步............");
            }
        });

        new Thread(new Running(cb),"1").start();
        new Thread(new Running(cb),"2").start();
        new Thread(new Running(cb),"3").start();
        new Thread(new Running(cb),"4").start();
    }

    static class Running implements Runnable{
        CyclicBarrier cb;

        public Running(CyclicBarrier cb){
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                cb.await();
                System.out.println("第（" + Thread.currentThread().getName() + "）名选手开始第一次跑步");
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));

                cb.await();
                System.out.println("第（" + Thread.currentThread().getName() + "）名选手开始第二次跑步");
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
