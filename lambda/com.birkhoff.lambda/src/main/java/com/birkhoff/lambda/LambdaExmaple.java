package com.birkhoff.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class LambdaExmaple {

    public static void main(String[] args) {
        example1();
        example2();
        example4();
        example5();
        example6();
        example7();
    }

    //语法格式一：无参，无返回值，Lambda 体只需一条语句。
    private static void example1(){
        Runnable runnable = () -> System.out.println("Hello Lambda!");
        runnable.run();
    }

//    语法格式二：Lambda 需要一个参数。
    private static void example2(){
        String y1 = "example2";
        Consumer<String> con = y ->  System.out.println(y);

        con.accept(y1);
    }
    //语法格式四：Lambda 需要两个参数，并且有返回值。
    private static void example4(){
        Integer x1 = 20; Integer y2 = 40;
        Comparator<Integer> com = ( x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println("example4 : " + com.compare(x1,y2));
    }

    //语法格式五：当 Lambda 体只有一条语句时，return 与大括号可以省略。
    private static void example5(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println("example5 : " + com.compare(10,20));
    }

    //Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”。
    private static void example6(){

        Comparator<Integer> com = (Integer x,Integer y) -> {  //Integer 类型可以省略
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println("example6 : " + com.compare(10,20));

        BinaryOperator<Long> add = (Long x, Long y) -> x + y;// 类型推断

        System.out.println("example6 : " + add.apply(new Long(10),new Long(20)));

    }

    //使用自定义函数接口
    private static void example7(){
        ConsumerInterface<String> consumer = str -> System.out.println(str);
        consumer.accept("我是自定义函数式接口");
    }

    // 自定义函数接口
    @FunctionalInterface
    public interface ConsumerInterface<T>{
        void accept(T t);
    }
}
