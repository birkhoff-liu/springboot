package com.birkhoff.thread;

public class TestThread {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + " running");
                }

                for (int i = 0 ; i < 10 ; i++){
                    System.out.println("count " + i);
                }
            }
        },"thread-one");

        threadOne.start();
        threadOne.sleep(5000);

        System.out.println("threadOne is start to interrupted");
        threadOne.interrupt();

        threadOne.join();//使主线程等待子线程执行，再执行
        System.out.println("main thread is finish!");
    }
}
