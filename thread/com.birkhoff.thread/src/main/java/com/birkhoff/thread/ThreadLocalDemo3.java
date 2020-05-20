package com.birkhoff.thread;

public class ThreadLocalDemo3 {

    private static Index num = new Index();
    public static final ThreadLocal<Index> local = new ThreadLocal<Index>(){
        @Override
        protected Index initialValue() {
            return num;
        }
    };
    public static void main(String[] args){
        Thread[] threads = new Thread[5];
        for(int i = 0 ; i < 5 ; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Index num = local.get();
                    num.increase();
                    System.out.println(Thread.currentThread().getName() + ":" + local.get().num);
                }
            },"Thread-" + i);
        }

        for(Thread thread : threads){
            thread.start();
        }
    }
    static  class Index{
        int num;
        public void increase(){
            num++;
        }
    }
}
