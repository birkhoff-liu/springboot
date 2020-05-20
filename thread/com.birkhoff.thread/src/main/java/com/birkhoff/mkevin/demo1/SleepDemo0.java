package com.birkhoff.mkevin.demo1;

public class SleepDemo0 {

    public static void main(String[] args) {

        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " get Lock, sleeping");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " sleep over and run over!");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName()+" get Lock, sleeping");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" sleep over and run over!");
                }
            }
        });

        t1.start();
        t2.start();
        //提示：打开interrupt注释，关观interrupt效果
//        t1.interrupt();
    }

}
