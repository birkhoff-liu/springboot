package org.fenixsoft.jvm.example;

public class StringReverse {
    public static void main(String[] args){
        final String test="abcdefg";
        System.out.println("charAtReverse method result : " + charAtReverse(test));
        System.out.println("reverseStringBuffer method result : " + reverseStringBuffer(test));
    }

    public static String charAtReverse (String s){
        int length = s.length();
        String reverse = " ";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;//字符串中获取单个字符的字符的放法
        }
        return reverse;
    }

    public static String reverseStringBuffer(String s){
        StringBuffer sb = new StringBuffer(s);
        String afterReverse = sb.reverse().toString();
        return afterReverse;
    }
}
