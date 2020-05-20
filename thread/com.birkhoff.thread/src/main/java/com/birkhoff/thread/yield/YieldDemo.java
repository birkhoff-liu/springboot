package com.birkhoff.thread.yield;

public class YieldDemo extends Thread{
    public static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock){
            System.out.println(this.getName() + " yield !");

             this.yield();

            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " run over!");
        }

    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 1000 ; i++){
            YieldDemo demo = new YieldDemo();
            demo.start();
        }
        synchronized (lock){
            lock.notifyAll();
        }
    }

}
