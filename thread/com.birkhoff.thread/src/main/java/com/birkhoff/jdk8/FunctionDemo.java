package com.birkhoff.jdk8;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args){
        String result = testFunction("kobe",name -> name + " bryant");
        System.out.println(result);

        Integer sum = calcuate(5,e -> {return e + 5;});
        System.out.println(sum);

        Function<Integer,Integer> fun1 = e -> {return e + 5;};
        Function<Integer,Integer> fun2 = e -> {return e * 5;};
        System.out.println("addThen : " + fun1.andThen(fun2).apply(5));
        System.out.println("compose : " + fun1.compose(fun2).apply(5));

        int result1 = compute(5, e -> e * 5, e -> e + 5);
        int result2 = compute2(5, e -> e * 5, e -> e + 5);
        int result3 = compute3(5, e -> e * 5, e -> e + 5);
        int result4 = compute4(5, e -> e * 5, e -> e + 5);
        System.out.println("result1 : " + result1);//50
        System.out.println("result2 : " + result2);//30
        System.out.println("result3 : " + result3);//130
        System.out.println("result4 : " + result4);//250

    }

    private static String testFunction(String name, Function<String,String> function){
        return function.apply(name);
    }

    private static int calcuate(Integer a ,Function<Integer,Integer> function){
        return function.apply(a);
    }


    private static int compute(int source, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(source);
    }
    private static int compute2(int source, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(source);
    }
    private static int compute3(int source, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).compose(function1).apply(source); //从后往前
    }
    private static int compute4(int source, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).andThen(function1).apply(source);
    }


}
