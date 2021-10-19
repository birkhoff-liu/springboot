package com.birkhoff.lambda;

import java.util.function.Function;

//Function<T, R> 函数型接口
public class FunctionExample {
    public static void main(String[] args) {
        test3();
    }
    private static void test3(){
        String newStr = strHandler("ttt 这是一个函数型接口 ", (str) -> str.trim());
        System.out.println(newStr);
        String subStr = strHandler("这是一个函数型接口", (str) -> str.substring(4, 7));
        System.out.println(subStr);
    }
    //需求：用于处理字符串
    private static String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }
}
