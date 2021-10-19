package com.birkhoff.lambda;

import java.util.function.Function;

//数组引用
public class ArrayRefenceExample {
    public static void main(String[] args) {
        test10();
    }
    private static void test10(){
        //传统Lambda实现
        Function<Integer,int[]> function = (i) -> new int[i];
        int[] apply = function.apply(10);
        System.out.println(apply.length); // 10

        //数组类型引用实现
        function = int[] :: new;
        apply = function.apply(100);
        System.out.println(apply.length); // 100
    }

}
