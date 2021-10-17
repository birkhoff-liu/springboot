package com.birkhoff.lambda.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {
    public static void main(String[] args) {
//        test();
//        test1();
//        testMap();
//        test2();
//        test3();
        test4();
    }
    private static void test(){
        //　将Stream规约成List
        Stream<String> stream = Stream.of("I", "love", "Collector");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 方式1
        // List<String> list = stream.collect(Collectors.toList());// 方式2
        System.out.println(list);
    }

    private static void test1(){
        // 使用toCollection()指定规约容器的类型
        Stream<String> stream = Stream.of("I", "love", "Collector");
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
        // HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
        // System.out.println(hashSet);
    }

    //使用toMap()生成的收集器，这种情况是最直接的，前面例子中已提到，这是和Collectors.toCollection()并列的方法。
    // 如下代码将字符列表转换成由<String，字符串长度>组成的Map。
    private static void testMap(){
        // 使用toMap()统计字符长度
        Stream<String> stream = Stream.of("I", "love", "Collector");
        List<String> list = stream.collect(Collectors.toList());// 方式2
        Map<String, Integer> strLength = list.stream().collect(Collectors.toMap(Function.identity(), str -> str.length()));
        System.out.println(strLength);
    }


    //使用partitioningBy()生成的收集器，这种情况适用于将Stream中的元素依据某个二值逻辑（满足条件，或不满足）分成互补相交的两部分，
    // 比如男女性别、成绩及格与否等。下列代码展示将字符列表分成长度大于2或不大于2的两部分。
    private static void test2(){
        // 对字符串列表进行分组
        Stream<String> stream = Stream.of("I", "love", "Collector");
        List<String> list = stream.collect(Collectors.toList());// 方式2
        Map<Boolean, List<String>> listMap = list.stream().collect(Collectors.partitioningBy(str -> str.length() > 2));
        System.out.println(listMap);
    }
    //使用groupingBy()生成的收集器，这是比较灵活的一种情况。跟SQL中的group by语句类似，
    // 这里的groupingBy()也是按照某个属性对数据进行分组，属性相同的元素会被对应到Map的同一个key上。下列代码展示将字符列表按照字符长度进行分组。
    private static void test3(){
        // 按照长度对字符串列表进行分组
        Stream<String> stream = Stream.of("I", "love", "Collector", "you", "Java");
        List<String> list = stream.collect(Collectors.toList());// 方式2
        Map<Integer, List<String>> listMap = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(listMap);
    }

    //增强版的groupingBy()允许我们对元素分组之后再执行某种运算，比如求和、计数、平均值、类型转换等
    private static void test4(){
        // 对字符串列表进行分组，并统计每组元素的个数
        Stream<String> stream = Stream.of("I", "love", "Collector", "you", "Java");
        List<String> list = stream.collect(Collectors.toList());// 方式2
        Map<Integer, Long> listMap = list.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(listMap);
    }


}
