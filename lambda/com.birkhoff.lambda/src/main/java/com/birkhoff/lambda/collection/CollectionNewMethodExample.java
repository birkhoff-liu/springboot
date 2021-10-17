package com.birkhoff.lambda.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionNewMethodExample {
    public static void main(String[] args) {
        testforEach();
        testremoveIf();
        testreplaceAll();
        testsort();
    }

    private static  void testforEach(){
        //匿名内部类实现：
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 6, 9, 10));
        list.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer){
                if(integer % 3 == 0){
                    System.out.println(integer);
                }
            }
        });

        //lambda表达式实现：
        ArrayList<Integer> lambdaList = new ArrayList<>(Arrays.asList(3, 6, 9, 10));
        lambdaList.forEach((s) -> {
            if (s % 3 == 0){
                System.out.println(s);
            }
        });

    }

    private static  void testremoveIf(){
        //匿名内部类实现：
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 6, 9, 10));
        list.removeIf(new Predicate<Integer>(){ // 删除长度大于3的元素
            @Override
            public boolean test(Integer sum){
                return sum % 3 == 0;
            }
        });
        System.out.println(list);

        //lambda表达式实现：
        ArrayList<Integer> lambdaList = new ArrayList<>(Arrays.asList(3, 6, 9, 10));
        lambdaList.removeIf(s -> s % 3 == 0);
        System.out.println(lambdaList);
    }

    private static  void testreplaceAll(){
        //匿名内部类实现：
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 6, 9, 10));
        list.replaceAll(new UnaryOperator<Integer>(){
            @Override
            public Integer apply(Integer sum){
                if(sum % 3 == 0){
                    return ++sum;
                }
                return --sum;
            }
        });
        System.out.println(list);

        //lambda表达式实现：
        ArrayList<Integer> lambdaList = new ArrayList<>(Arrays.asList(3, 6, 9, 10));
        lambdaList.replaceAll(sum -> {
            if (sum % 3 == 0){
                return ++sum;
            }else {
                return --sum;
            }
        });
        System.out.println(lambdaList);
    }

    private static  void testsort(){
        //匿名内部类实现：
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6, 10, 9, 3));
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer sum1, Integer sum2){
                return sum1 - sum2;
            }
        });
        System.out.println(list);

        //lambda表达式实现：
        ArrayList<Integer> lambdaList = new ArrayList<>(Arrays.asList(6, 10, 9, 3));
        System.out.println(lambdaList);
        lambdaList.sort((sum1, sum2) -> sum1 - sum2);
        System.out.println(lambdaList);

    }
}


