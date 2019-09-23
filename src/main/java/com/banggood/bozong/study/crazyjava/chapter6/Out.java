package com.banggood.bozong.study.crazyjava.chapter6;

public class Out {
    //定义一个内部类，不使用访问控制符
    //即只有同一个包中的其他类可访问该内部类
    class In{
        public In(String msg) {
            System.out.println(msg);
        }
    }
}
