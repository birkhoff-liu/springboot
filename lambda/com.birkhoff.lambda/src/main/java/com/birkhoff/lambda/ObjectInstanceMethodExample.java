package com.birkhoff.lambda;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

//对象::实例方法
public class ObjectInstanceMethodExample {
    public static void main(String[] args) {
        test1();
        test2();
    }
    private static void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (str) -> ps.println(str);
        con.accept("Hello World！");

        System.out.println("--------------------------------");

        Consumer<String> con2 = ps::println;
        con2.accept("Hello Java8！");

        Consumer<String> con3 = System.out::println;
    }
    private static void test2(){
        Employee emp = new Employee(1, "张三", 18, 5112.99);

        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        System.out.println("----------------------------------");

        Employee emp1 = new Employee(2, "李四", 18, 5112.99);
        Supplier<String> sup2 = emp1::getName;
        System.out.println(sup2.get());
    }
}
class Employee {
    private int id;
    private String name;
    private int age;
    private double saler;

    public Employee(){}

    public Employee(int id,String name ,int age,double saler){
        this.id = id;
        this.name = name;
        this.age = age;
        this.saler = saler;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSaler() {
        return saler;
    }

    public String show(){
        return "Employee class show";
    }
}
