package com.birkhoff.lambda;

import java.util.function.Consumer;

//Consumer<T> 消费型接口
public class ConsumerExample {
    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        hello("张三", (m) -> System.out.println("你好：" + m));
    }
    private static void hello(String st, Consumer<String> con){
        con.accept(st);
    }
}
