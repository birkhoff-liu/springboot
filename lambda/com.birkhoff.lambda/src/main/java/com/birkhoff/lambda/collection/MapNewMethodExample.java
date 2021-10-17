package com.birkhoff.lambda.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class MapNewMethodExample {
    public static void main(String[] args) {
        testforEach();
        testgetOrDefault();

        testreplaceAll();
        testmerge();
        testcompute();
        testcomputeIfAbsent();
    }
    private static void testforEach(){
        //匿名内部类实现：
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "我");
        map.put(2, "拒绝");
        map.put(3, "996");
        map.forEach(new BiConsumer<Integer, String>(){
            @Override
            public void accept(Integer key, String value){
                System.out.println(key + "=" + value);
            }
        });

        //lambda表达式实现：
        HashMap<Integer, String> lambdamap = new HashMap<>();
        lambdamap.put(1, "我");
        lambdamap.put(2, "拒绝");
        lambdamap.put(3, "996");
        lambdamap.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    //该方法跟Lambda表达式没关系，但是很有用。方法签名为V getOrDefault(Object key, V defaultValue)，作用是按照给定的key查询Map中对应的value，
    // 如果没有找到则返回defaultValue。使用该方法可以省去查询指定键值是否存在的麻烦。
    private static void testgetOrDefault(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "我");
        map.put(2, "拒绝");
        map.put(3, "996");
        // Java7以及之前做法
        if(map.containsKey(4)){
            System.out.println(map.get(4));
        }else{
            System.out.println("NoValue");
        }

        // Java8使用Map.getOrDefault()
        System.out.println(map.getOrDefault(4, "NoValue"));
    }

    private  static void testputIfAbsent(){
        //匿名内部类实现：
        //lambda表达式实现：
    }

    private static void testremove(){
        //匿名内部类实现：
        //lambda表达式实现：
    }

    private static void testreplace(){
        //匿名内部类实现：
        //lambda表达式实现：
    }

    private static void testreplaceAll(){
        //匿名内部类实现：
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "我");
        map.put(2, "拒绝");
        map.put(3, "996");
        map.replaceAll(new BiFunction<Integer, String, String>(){
            @Override
            public String apply(Integer k, String v){
                if (v.equals("我")){
                    v = "你";
                }
                return v.toUpperCase();
            }
        });
        map.forEach((key, value) -> System.out.println(key + "=" + value));

        //lambda表达式实现：
        HashMap<Integer, String> lambdamap = new HashMap<>();
        lambdamap.put(1, "我");
        lambdamap.put(2, "拒绝");
        lambdamap.put(3, "996");
        lambdamap.replaceAll((k, v) -> {
            if (v.equals("我")){
                v = "你";
            }
            return v.toUpperCase();
        });
        lambdamap.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    private static void testmerge(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "我");
        map.put(2, "拒绝");
        map.put(3, "996");

        map.forEach((key, value) -> System.out.println(key + "=" + value));
        map.merge(1, "和你", (v1, v2) -> v1+v2);
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    private static void testcompute(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "我");
        map.put(2, "拒绝");
        map.put(3, "996");

        map.forEach((key, value) -> System.out.println(key + "=" + value));
        map.compute(1, (k,v) -> v == null ? "值为空" : v.concat("和你"));
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    private static void testcomputeIfAbsent(){
        Map<Integer, Set<String>> map = new HashMap<>();
        // Java7及以前的实现方式
        if(map.containsKey(1)){
            map.get(1).add("123");
        }else{
            Set<String> valueSet = new HashSet<String>();
            valueSet.add("123");
            map.put(1, valueSet);
        }
        // Java8的实现方式
        map.computeIfAbsent(1, v -> new HashSet<String>()).add("345");
        map.forEach((key, value) -> System.out.println(key + "=" + value));

    }

    private static void testcomputeIfPresent(){

    }
}
