package com.birkhoff.lock;

import org.openjdk.jol.info.ClassLayout;

public class ObjectHeader {
    public static void main(String[] args) {
        Object object = new Object();

        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
