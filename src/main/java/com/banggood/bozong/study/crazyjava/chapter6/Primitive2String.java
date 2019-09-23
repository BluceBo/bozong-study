package com.banggood.bozong.study.crazyjava.chapter6;

public class Primitive2String {
    //定义长度为256的Integer数组
    static final Integer[] cache = new Integer[-(-128) + 127 + 1];
    static {
        //执行初始化，创建-128到127的Integer实例，并放入cache数组中
        for (int i = 0;i < cache.length;i++) {
            cache[i] = new Integer(i - 128);
        }
    }
    public static void main(String[] args) {
        //通过自动装箱，允许把基本类型值赋值给包装实例
        Integer ina = 2;
        Integer inb = 2;
        System.out.println("两个2自动装箱后是否相等：" + (ina == inb));
        Integer biga = 128;
        Integer bigb = 128;
        System.out.println("两个128自动装箱后是否相等：" + (biga == bigb));
    }
}
