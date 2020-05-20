package com.birkhoff.jdk8;

/**
 * 获取类的泛型类型
 * 提示：全局变量的泛型不会被擦除
 *      方法变量的泛型会被擦除
 * @param <Integer>
 */
public class TestJvm<Integer> {
    public static void main(String[] args) {
        System.out.println(TestJvm.class.getTypeParameters()[0]);
    }
}
