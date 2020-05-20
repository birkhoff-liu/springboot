package com.birkhoff.concurrent2;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingDemo {
    public static void main(String[] args) throws Exception {
//		insertBlocking();
//		fetchBlocking();

        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
        testProducerConsumer(abq);

    }


    /**
     * 此方法展示了 ArrayBlockingQueue 的插入阻塞特性 ：如果队列已经满了，那么插入的操作就会被阻塞，程序执行就会被迫暂停。
     */
    public static void insertBlocking() throws InterruptedException {
        ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);
        names.put("a");
        // 从这一句开始后面的就不会被执行了
        names.put("b");

        System.out.println("程序执行到此...");
    }

    /**
     * 此方法展示了 ArrayBlockingQueue 的取出阻塞特性 ：如果队列为空，那么取的操作就会被阻塞，程序执行就会报错。
     *
     */
    public static void fetchBlocking() throws InterruptedException {
        ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);
        names.put("a");
        names.remove();
        names.remove();
        names.put("b");

        System.out.println("程序执行到此...");
    }


    /**
     * @作用 此方法用来测试生产者和消费者
     * 为了让程序在获取不到元素时不报错有两种方式：
     * 1.让生产者的生产速度大于消费者的消费速度
     * 2.在消费者获取资源出错时让消费者线程暂停一段时间，不输出错误。
     * @param abq
     */
    public static void testProducerConsumer (ArrayBlockingQueue<String> abq) {
        Thread tConsumer = new Consumer(abq);
        Thread tProducer = new Producer(abq);
        tConsumer.start();
        tProducer.start();
    }

}


/**
 * @作用 定义消费者
 *
 */
class Consumer extends Thread {
    ArrayBlockingQueue<String> abq = null;

    public Consumer(ArrayBlockingQueue<String> abq) {
        super();
        this.abq = abq;
    }

    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(500);
                String msg = abq.remove();
                System.out.println("取数据：====" + msg + "\t剩余数据量：" + abq.size());
            } catch (Exception e) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}


/**
 * @作用 定义生产者
 *
 */
class Producer extends Thread {
    ArrayBlockingQueue<String> abq = null;

    public Producer(ArrayBlockingQueue<String> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            try {
                Thread.sleep(1000);
                abq.put(""+i);
                System.out.println("存放数据：====" + i + "\t剩余数据量：" + abq.size());
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
