package com.birkhoff.lambda;

import java.util.function.BiPredicate;
import java.util.function.Function;
//类::实例方法
public class ClassInstanceMethodExample {
    public static void main(String[] args) {
        test5();
    }
    private static void test5(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("abcde", "abcde"));

        System.out.println("-----------------------------------------");
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "qazx"));

        System.out.println("-----------------------------------------");
        Function<Employee, String> fun = (e) -> e.show();
        System.out.println(fun.apply(new Employee()));

        System.out.println("-----------------------------------------");
        Function<Employee, String> fun2 = Employee::show;
        System.out.println(fun2.apply(new Employee()));
    }
}
