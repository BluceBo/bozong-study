package com.banggood.bozong.study.crazyjava.chapter6;

public class StatusTranfer {
    public static void test() {
        String a = new String("轻量级JavaEE企业应用实战");
        System.out.println(a.hashCode());
        a = new String("疯狂Java讲义");
        System.out.println(a.hashCode());
    }

    public static void main(String[] args) {
        test();
    }
}
