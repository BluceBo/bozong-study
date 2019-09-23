package com.banggood.bozong.study.crazyjava.chapter6;

import jdk.internal.dynalink.beans.StaticClass;

public class AccessStaticInnerClass {
    //定义内部类
    static class StaticInnerClass {
        private static int propl = 5;
        private int prop2 = 9;
    }
    public void accessInnerProp() {
        //通过类名访问静态内部类
        System.out.println(StaticInnerClass.propl);
        //通过实例访问静态内部类的实例成员
        System.out.println(new StaticInnerClass().prop2);
    }
}
