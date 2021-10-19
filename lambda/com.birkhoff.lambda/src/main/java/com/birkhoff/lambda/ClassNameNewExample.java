package com.birkhoff.lambda;

import java.util.function.BiConsumer;

//类名 :: new
public class ClassNameNewExample {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        // Student类中必须有一个 Student(String name, int age) 的构造器
        BiConsumer<String, Integer> biConsumer = Student :: new;
        biConsumer.accept("王五", 19);
        biConsumer.toString();
    }
}

class Student{
    private String name;
    private int age;

    public Student(String name,int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
