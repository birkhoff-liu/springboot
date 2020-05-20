package com.birkhoff.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MultiThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        //
        Arrays.asList(threadInfos).stream().forEach(th -> System.out.println("[" + th.getThreadId() + "]" + th.getThreadName()));

        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            Thread.sleep(5000);
            return new Random().nextInt();
        });

        new Thread(futureTask).start();
        System.out.println("子线程的返回值 ：" + futureTask.get());
        System.out.println("main is over");
    }
}
