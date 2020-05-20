package com.birkhoff.jdk8;

import com.birkhoff.jdk8.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterPredicate {
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

//        List<Employee> result = employees.stream()
//                .filter(e -> e.getAge() > 60 && e.getGender().equals("M"))
//                .collect(Collectors.toList());

//        and
//        List<Employee> result = employees.stream()
//                .filter(Employee.ageGreaterThan60.and(Employee.genderM))
//                .collect(Collectors.toList());
//        or
//        List<Employee> result = employees.stream()
//                .filter(Employee.ageGreaterThan60.or(Employee.genderM))
//                .collect(Collectors.toList());
//        非
        List<Employee> result = employees.stream()
                .filter(Employee.ageGreaterThan60.or(Employee.genderM).negate())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
