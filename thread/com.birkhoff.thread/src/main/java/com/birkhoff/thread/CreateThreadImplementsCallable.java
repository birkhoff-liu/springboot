package com.birkhoff.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadImplementsCallable implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThreadImplementsCallable create = new CreateThreadImplementsCallable();
        FutureTask<String> ft = new FutureTask<>(create);
        new Thread(ft).start();

        System.out.println(ft.get());
    }

    @Override
    public String call() throws Exception {
        return "hello callable";
    }
}
