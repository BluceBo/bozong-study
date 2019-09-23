package com.banggood.bozong.study.crazyjava.chapter6;

public class UnsignedTest {
    public static void main(String[] args) {
        byte b = -3;
        //将byte类型的-3转换为无符号整数
        System.out.println("byte类型的-3对应的无符号整数：" + Byte.toUnsignedInt(b));
        //将指定字符串解析成无符号整数
        System.out.println(Integer.parseUnsignedInt("12"));
        //指定使用十六进制解析无符号整数
        int val = Integer.parseUnsignedInt("ab",16);
        System.out.println(val);
        //将-12转换为无符号int
        System.out.println(Integer.toUnsignedString(-12));
        //将-12转换为无符号int然后转换为十六进制的字符串
        System.out.println(Integer.toUnsignedString(-12,16));
        //将两个数转换为无符号整数后相除
        System.out.println(Integer.divideUnsigned(-2,3));
        //将两个数转换为无符号整数相除后求余
        System.out.println(Integer.remainderUnsigned(-2,7));
    }
}
