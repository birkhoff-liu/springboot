package com.birkhoff.concurrent2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo {
        private final ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();

        public static void main(String[] args){
            ExecutorService service = Executors.newFixedThreadPool(3);
            ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
            service.execute(demo.new WriteThreadOne());
            service.execute(demo.new WriteThreadTwo());
            service.execute(demo.new ReadThread());
            service.shutdown();
        }

        class WriteThreadOne implements Runnable{
            @Override
            public void run() {
                for(int i = 0 ; i < 10 ; i++){
                    concurrentHashMap.putIfAbsent(i, "A_" + i);
                }
            }
        }

    class WriteThreadTwo implements Runnable{
        @Override
        public void run() {
            for(int i = 0 ; i < 5 ; i++){
                concurrentHashMap.put(i, "B_" + i);
            }
        }
    }

    class ReadThread implements Runnable{
        @Override
        public void run() {
            Iterator<Integer> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()){
                Integer key = it.next();
                System.out.println(key + " : " + concurrentHashMap.get(key));
            }
        }
    }
}
