package com.banggood.bozong.study.crazyjava.chapter7;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by admin on 2018/10/28.
 */
public class MethodHandleTest {
    //定义一个private类方法
    private static void hello() {
        System.out.println("hello world");
    }
    //定义一个private实例方法
    private String hello(String name) {
        System.out.println("执行带参数的hello" + name);
        return name + "你好";
    }
    public static void main(String[] args) throws Throwable {
        //定义一个返回值为void、不带形参的方法类型
        MethodType methodType = MethodType.methodType(void.class);
        //使用MethodHandles.Lookup的findStatic获取类方法
        MethodHandle mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", methodType);
        //通过MethodHandle执行方法
        mtd.invoke();
        //通过MethodHandles.Lookup的findVirtual获取实例方法
        MethodHandle mtd2 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello",
                //指定获取返回值为String，形参为String的方法类型
                MethodType.methodType(String.class, String.class));
        //通过MethodHandle执行方法，传入主调对象和参数
        System.out.println(mtd2.invoke(new MethodHandleTest(),"blucebo"));
    }
}
