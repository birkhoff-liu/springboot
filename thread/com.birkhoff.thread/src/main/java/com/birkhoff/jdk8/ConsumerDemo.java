package com.birkhoff.jdk8;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args){
        String xm = "";
        validate(xm,name -> System.out.println(name.isEmpty() ? "name is null" : name));
    }
    private static void validate(String name, Consumer<String> consumer){
        consumer.accept(name);
    }
}
