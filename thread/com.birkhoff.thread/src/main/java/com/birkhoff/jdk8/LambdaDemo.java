package com.birkhoff.jdk8;

public class LambdaDemo {
    interface Printer{
        void printer(String str);
    }

    public void printSomething(String something,Printer printer){
        printer.printer(something);
    }

    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String some = "hello world!!!";

//        Printer printer = new Printer() {
//            @Override
//            public void printer(String str) {
//                System.out.println(str);
//            }
//        };
//        Printer printer = (String val) ->{
//            System.out.println(val);
//        };
//        Printer printer = (val) ->{
//            System.out.println(val);
//        };

//        Printer printer = val ->{
//            System.out.println(val);
//        };

        Printer printer = val -> System.out.println(val);

        demo.printSomething(some,printer);
    }
}
