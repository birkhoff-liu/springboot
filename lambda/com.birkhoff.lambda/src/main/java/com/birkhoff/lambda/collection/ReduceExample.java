package com.birkhoff.lambda.collection;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceExample {
    public static void main(String[] args) {
        test();
        test1();
    }
    private static void  test(){
        // 找出最长的单词
        Stream<String> stream1 = Stream.of("I", "love you", "you", "too");
//        Optional<String> longest = stream1.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
         Optional<String> longest = stream1.max((s1, s2) -> s1.length() - s2.length());
        System.out.println(longest.get());
    }

    private static void test1(){
        // 求单词长度之和
        // (参数1)初始值
        // (参数2)累加器
        // (参数3)部分和拼接器，并行执行时才会用到
        Stream<String> stream2 = Stream.of("I", "love", "you", "too");
        Integer lengthSum = stream2.reduce(0, (sum, str) -> sum + str.length(), (a, b) -> a + b);
//         int lengthSum = stream2.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
    }

    private static void test2(){
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        // 转换成list集合
        List<String> list = stream.collect(Collectors.toList());
        // 转换成set集合
         Set<String> set = stream.collect(Collectors.toSet());
        // 转换成map集合
         Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
    }
}
