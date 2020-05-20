package com.birkhoff.threadpool;

public class WorkerThreadDemo implements Runnable{
    private String info;

    public WorkerThreadDemo(String info){
        this.info = info;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");

    }
    @Override
    public String toString(){
        return this.info;
    }
}
