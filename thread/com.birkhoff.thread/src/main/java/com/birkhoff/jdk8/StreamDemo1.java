package com.birkhoff.jdk8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        listStream();
        arrayStream();
        setStream();
    }

    private static void listStream(){
        List<String> players = Arrays.asList("birkhoff","birkhoffliu","kobe","Monkey");

        List<String> result = players.stream().filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private static void arrayStream(){
        String[] players = {"birkhoff","birkhoffliu","kobe","Monkey"};

        List<String> result = Stream.of(players)
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private static void setStream(){
        List<String> players = Arrays.asList("birkhoff","birkhoffliu","kobe","Monkey");

        Set<String> set = new HashSet<>(players);

        List<String> result = set.stream()
                .filter(s->s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private static void fileStream() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("path"));
    }
}
