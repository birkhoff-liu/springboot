package com.birkhoff.jdk8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.repository.support.QuerydslMongoPredicateExecutor;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    public static Predicate<Employee> ageGreaterThan60 = x -> x.getAge() > 60;
    public static Predicate<Employee> genderM = x -> x.getGender().equals("M");
}
