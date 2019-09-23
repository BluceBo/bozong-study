package com.banggood.bozong.study.crazyjava.chapter6;

public class StaticOut {
    //定义一个静态内部类，不使用访问控制符
    //即同一个包中的其他类可访问该内部类
    static class StaticIn{
        public StaticIn() {
            System.out.println("静态内部类的构造器");
        }
    }
}
