package com.birkhoff.jdk8;

import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args){
        String result = testSupplier(() -> " hello welcome!");
        System.out.println(result);
    }

    private static String testSupplier(Supplier<String> supplier){
        return supplier.get();
    }
}
