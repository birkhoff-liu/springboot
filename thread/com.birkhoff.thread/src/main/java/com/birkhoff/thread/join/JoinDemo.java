package com.birkhoff.thread.join;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run over!");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run over!");
            }
        });
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " wait " + t1.getName() + " and " + t2.getName() + " run over!");

        //放开或注释该两行代码，查看join()的阻塞效果
//        t1.join();
//        t2.join();

        //放开或注释该两行代码，查看join(millis)的阻塞效果
        t1.join(2000);
        t2.join(2000);

        System.out.println("final : " + t1.getName() + " and " + t2.getName());

        //查看线程状态
        System.out.println("t1 thread state " + t1.getState());
        System.out.println("t2 thread state " + t2.getState());
    }
}
