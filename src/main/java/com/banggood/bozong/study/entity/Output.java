package com.banggood.bozong.study.entity;

public interface Output {
    int MAX_CACHE_LINE = 50;
    void out();
    void getData(String msg);
    default void print(String... msgs){
        for(String msg : msgs) {
            System.out.println(msg);
        }
    }
    default void test() {
        System.out.println("默认的test()方法");
    }
    static String staticTest() {
        return "接口中的类方法";
    }
}
