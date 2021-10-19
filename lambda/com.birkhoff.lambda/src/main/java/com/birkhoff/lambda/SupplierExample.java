package com.birkhoff.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//Supplier<T> 供给型接口
public class SupplierExample {
    public static void main(String[] args) {
        test2();
    }
    private static void test2(){
        List list = Arrays.asList(121, 1231, 455, 56, 67,78);
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }
    //需求：产生指定个数的整数，并放入集合中
    private static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
}
