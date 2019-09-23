package com.banggood.bozong.study.crazyjava.chapter7;

import java.util.Objects;

public class ObjectsTest {
    static ObjectsTest obj;
    public static void main(String[] args) {
        //输出一个null对象的hashCode值，输出0
        System.out.println(Objects.hashCode(obj));
        //输出一个null对象的toSttring(),输出null
        System.out.println(Objects.toString(obj));
        //要求obj不能为空，如果obj为空则引发异常
        System.out.println(Objects.requireNonNull(obj,"obj参数不能为空！"));
    }
}
