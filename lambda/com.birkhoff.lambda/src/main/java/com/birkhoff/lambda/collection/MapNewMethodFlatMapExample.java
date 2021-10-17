package com.birkhoff.lambda.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.Assert.assertEquals;

public class MapNewMethodFlatMapExample {
    private static final List<Employee> list = Arrays.asList(
            new Employee(1, "Alex", 1000.0),
            new Employee(2, "Michael", 2000.0),
            new Employee(3, "Jack", 1500.0),
            new Employee(4, "Owen", 1500.0),
            new Employee(5, "Denny", 2000.0));

    private static final List<List<Employee>> listFlat = Arrays.asList(
            Arrays.asList(new Employee(1, "Alex", 1000.0),
                    new Employee(2, "Michael", 2000.0)),
            Arrays.asList(new Employee(3, "Jack", 1500.0),
                    new Employee(4, "Owen", 1500.0)),
            Arrays.asList(new Employee(5, "Denny", 2000.0)));

    @Test
    public void flatMap() {
        List<Employee> employeesAll = listFlat.stream().flatMap(Collection::stream).collect(Collectors.toList());
        assertTrue(employeesAll.size() == 5);

        List<Employee> employeesAll2 = listFlat.stream().flatMap(employees -> {
            Stream<Employee> stream = employees.stream();
            return stream;
        }).collect(Collectors.toList());
        assertEquals(employeesAll, employeesAll2);

        List<Long> listFlatLong = listFlat.stream()
                .flatMap(employees -> employees.stream())
                .peek(System.out::println)
                .flatMapToLong(employee -> LongStream.of(employee.getId()))
                .peek(System.out::println)
                .boxed()
                .collect(Collectors.toList());
        System.out.printf(String.format("listFlatLong:{} %s", listFlatLong.toString()));

        List<Long> listFlatLong2 = listFlat.stream()
                .flatMap(employees -> employees.stream())
                .peek(System.out::println)
                .mapToLong(Employee::getId)
                .peek(System.out::println)
                .boxed()
                .collect(Collectors.toList());

        List<Double> listFlatName = listFlat.stream().flatMap(employees -> employees.stream())
                .peek(System.out::println)
                .map(employee -> employee.getSalary())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}
class Employee{
    private int id;
    private String name;
    private Double salary;

    public Employee(int id,String name ,Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }
}
