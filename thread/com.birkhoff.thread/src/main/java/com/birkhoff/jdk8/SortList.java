package com.birkhoff.jdk8;

import com.birkhoff.jdk8.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "londo",
                "San Franceisco",
                "Tokyo",
                "New Delhi"
        );
        //原始
        System.out.println(cities);

        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cities);

        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);

        Employee e1 = new Employee(1,23,"M","Rick","Beethoyang");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lownan");
        Employee e5 = new Employee(5,19,"F","David","Roy");
        Employee e6 = new Employee(6,15,"F","Alex","Jain");
        Employee e7 = new Employee(7,68,"M","Neetu","Singh");
        Employee e8 = new Employee(8,79,"M","Naveen","Gussin");

        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8);

        //集合排序
        //都是正序，不加reversed
        //都是倒序，最后面加一个reversed
        //先是倒序加reversed，然后正序
        //先是正序加reversed，然后倒序加reversed
        employees.sort(
                Comparator.comparing(Employee::getGender)
                    .reversed()
                .thenComparing(Employee::getAge)
                .reversed()
        );

        employees.forEach(System.out :: println);

    }
}
