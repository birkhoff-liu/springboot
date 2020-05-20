package com.birkhoff.jdk8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamState {
    public static void main(String[] args) {
        List<String> limitN = Stream.of("Monkey","Lion","Giraffe","Lemur")
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(limitN);

        List<String> skipN = Stream.of("Monkey","Lion","Giraffe","Lemur")
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(skipN);

        List<String> uniqueAnimals = Stream.of("Monkey","Lion","Giraffe","Lemur","Lion")
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueAnimals);

        List<String> alphabeticOrder = Stream.of("Monkey","Lion","Giraffe","Lemur")
                .parallel()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(alphabeticOrder);
    }
}
