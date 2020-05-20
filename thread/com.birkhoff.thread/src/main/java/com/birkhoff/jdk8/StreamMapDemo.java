package com.birkhoff.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapDemo {

    public static void main(String[] args) {
        List<String> players = Arrays.asList("birkhoff","birkhoffliu","kobe","Monkey");

//        List<String> result =players.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> result =players.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());

        System.out.println(result);
    }
}
