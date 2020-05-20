package com.birkhoff.jdk8;

import com.birkhoff.jdk8.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,23,"M","Rick","Beethoyang");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lownan");
        Employee e5 = new Employee(5,19,"F","David","Roy");
        Employee e6 = new Employee(6,15,"F","Alex","Jain");
        Employee e7 = new Employee(7,68,"M","Neetu","Singh");
        Employee e8 = new Employee(8,79,"M","Naveen","Gussin");

        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8);

//        map
//        List<Employee> result = employees.stream().map(e ->{
//            e.setAge(e.getAge() +1 );
//            e.setGender(e.getGender().equals("M") ? "male" : "female");
//            return e;
//        }).collect(Collectors.toList());
//        peek
        List<Employee> result = employees.stream().peek(e ->{
            e.setAge(e.getAge() +1 );
            e.setGender(e.getGender().equals("M") ? "male" : "female");
        }).collect(Collectors.toList());

        System.out.println(result);
    }
}
