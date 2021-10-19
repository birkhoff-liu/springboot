package com.birkhoff.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;

//类::静态方法
public class ClassStaticMethodExample {
    public static void main(String[] args) {
        test3();
        test4();
    }

    private static void test3(){
        BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
        System.out.println(fun.apply(1.5, 22.2));

        System.out.println("--------------------------------------------------");
        BiFunction<Double, Double, Double> fun2 = Math::max;
        System.out.println(fun2.apply(1.2, 1.5));
    }

    private static void test4(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(3,9));

        System.out.println("-------------------------------------");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(3,9));
    }
}
