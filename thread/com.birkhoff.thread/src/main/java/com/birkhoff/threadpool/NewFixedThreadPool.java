package com.birkhoff.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
    public static void main(String[] args) {
        //固定线程池大小
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //提供了十个任务
        for(int i = 0 ; i < 10 ; i++){
            WorkerThreadDemo workerThreadDemo = new WorkerThreadDemo("thread " + i);
            //线程池接受任务
            pool.execute(workerThreadDemo);
        }
        pool.shutdown();//顺序关闭
        while (!pool.isTerminated()){

        }
        System.out.println("All Thread is finished.");
    }
}
