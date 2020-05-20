package com.birkhoff.concurrent2;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * 多个线程处理同一个队列
 */
public class LinkedTransferQueueDemo {
    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();
        Thread producer = new Thread(new ProducerLinkedTransferQueue(queue));
        producer.setDaemon(true);
        producer.start();

        for (int i = 0; i < 10; i++) {
            Thread consumer = new Thread(new ConsumerLinkedTransferQueue(queue));
            consumer.setDaemon(true);
            consumer.start();
            try {
                Thread.sleep(1000L);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
 class ProducerLinkedTransferQueue implements Runnable {
    private final TransferQueue<String> queue;

    public ProducerLinkedTransferQueue(TransferQueue<String> queue) {
        this.queue = queue;
    }

    private String produce() {
        return "Your lucky number " + (new Random().nextInt(100));
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while (true) {
                if (queue.hasWaitingConsumer()) {
                    queue.transfer(produce());
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {

        }

    }
}
 class ConsumerLinkedTransferQueue implements Runnable{
    private final TransferQueue<String> queue;
    public ConsumerLinkedTransferQueue(TransferQueue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println("Consumer " + Thread.currentThread().getName() + " " + queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
