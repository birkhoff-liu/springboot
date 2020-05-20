package com.birkhoff.thread;

public class ThreadLocalDemo2 {

    public static final ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public static void main(String[] args){
        Thread[] threads = new Thread[5];
        for(int i = 0 ; i < 5 ; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int num = local.get();
                    num += 5;
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                }
            },"Thread-" + i);
        }

        for(Thread thread : threads){
            thread.start();
        }
    }
}
