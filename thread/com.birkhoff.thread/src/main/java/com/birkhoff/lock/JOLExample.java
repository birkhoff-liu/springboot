package com.birkhoff.lock;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class JOLExample {

    static Other other = new Other();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        countHash(other);
        System.out.println(Integer.toHexString(other.hashCode()));
        System.out.println(ClassLayout.parseInstance(other).toPrintable());
    }

    public static  void countHash(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        long hashCode = 0;

        for(long index = 7 ; index > 0 ; index--){
            hashCode |= (unsafe.getByte(object,index) & 0xFF) << ((index -1 ) * 8);
        }
        String code = Long.toHexString(hashCode);
        System.out.println("util----------0x" + code);
    }
}
