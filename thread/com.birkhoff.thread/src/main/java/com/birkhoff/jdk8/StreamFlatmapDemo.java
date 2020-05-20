package com.birkhoff.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * flatmap 处理二维数组，或多维数组
 */
public class StreamFlatmapDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello","world");

        words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .forEach(System.out :: println);
    }
}
