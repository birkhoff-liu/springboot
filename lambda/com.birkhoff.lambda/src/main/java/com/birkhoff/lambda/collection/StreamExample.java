package com.birkhoff.lambda.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        testforEach();
        testfilter();
        testdistinct();
        testsorted();
        flatMap();
    }
    private static void testforEach(){
        // 使用Stream.forEach()迭代
        Stream<String> stream = Stream.of("I", "love", "Java");
        stream.forEach(str -> System.out.println(str));
    }

    private static void testfilter(){
        // 保留长度大于等于3的字符串
        Stream<String> stream = Stream.of("I", "love", "Java");
        stream.filter(str -> str.length() >= 3).forEach(str -> System.out.println(str));
    }

    private static void testdistinct(){
        // 元素去重
        Stream<String> stream = Stream.of("I", "love", "you", "Java", "you");
        stream.distinct().forEach(str -> System.out.println(str));
    }

    private static void testsorted(){
        // 排序
        Stream<String> stream = Stream.of("I", "love", "you", "too", "Java");
//        stream.sorted().forEach(str -> System.out.println(str));
        stream.sorted((str1, str2) -> str1.length() - str2.length()).forEach(str -> System.out.println(str));
    }

    private static void flatMap(){
        // 将两个集合中大于等于2的数重新组成Stream，然后输出
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream.flatMap(list -> list.stream().filter(integer -> integer >= 2)).forEach(i -> System.out.println(i));
    }
}
