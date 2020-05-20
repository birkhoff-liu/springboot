package com.birkhoff.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterDemo {

    static List<Apple> inventory = Arrays.asList(
            new Apple("green",80),
            new Apple("green",120),
            new Apple("red",150)
    );

    public static void main(String[] args){
//        List<Apple> result = fileterApples(inventory, new AppleStrange() {
//            @Override
//            public boolean check(Apple apple) {
//                return apple.getWeight() > 80;
//            }
//        });
//        List<Apple> result = fileterApples(inventory,(Apple apple)->apple.getWeight() > 80);
        List<Apple> result = fileterApples(inventory,apple->apple.getWeight() > 80);
        System.out.println(result);
//
//        new Thread(() -> {
//            System.out.println("execute");
//        }).start();

    }

    private static <T> List<T> fileterApples(List<T> inventory, Predicate<T> strange){
        List<T> result = new ArrayList<T>();
        for(T t : inventory){
            if(strange.test(t)){
                result.add(t);
            }
        }
        return result;
    }
}
