package com.banggood.bozong.study.test;

import com.banggood.bozong.study.entity.Output;
import com.banggood.bozong.study.entity.OutputImpl;
import com.banggood.bozong.study.entity.Person;
import com.banggood.bozong.study.thread.sxtbase.Car;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by admin on 2018/4/5.
 */
public class Test1 {
    @Test
    public void test1() {
        System.out.println((int)'c');
        System.out.println(1+2);
        String str1 = "java";
        System.out.println("hashCode1---->" + str1.hashCode());
        str1 = str1 + "struts";
        System.out.println("hashCode2---->" + str1.hashCode());
        str1 = str1 + "spring";
        System.out.println("hashCode3---->" + str1.hashCode());
        System.out.println(str1);
        HashMap hashMap = new HashMap();
    }

    @Test
    public void deleteFile(){
        File file = new File("F:\\迅雷下载\\【150658477】[美国] 美丽小蜜桃Pretty Peaches [AVI.1.29G]");
        file.delete();
    }

    @Test
    public void test2() {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue(3);
        blockingDeque.add("张三");
        blockingDeque.add("李四");
        blockingDeque.add("王五");
        blockingDeque.add("赵六");
    }

    /**
     * 配置堆内存大小和新生代空间最大值打印GC日志
     * -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    @Test
    public void testGc() {
        byte[] gc1,gc2,gc3,gc4;
        gc1 = new byte[2*1024*1024];
        gc2 = new byte[2*1024*1024];
        gc3 = new byte[2*1024*1024];
        gc4 = new byte[4*1024*1024];
    }

    @Test
    public void test3() {
       int[] arr = new int[10];
       arr[0]=1;
        System.out.println(arr.length);
    }

    @Test
    public void test4() {
        Car car = new Car();
        Car car1 = new Car();
        System.out.println(car.getPerson().hashCode());
        System.out.println(car1.getPerson().hashCode());
    }

    @Test
    public void test5() {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(20);
        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(20);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }

    @Test
    public void test6() {
        System.out.println(Math.round(-1.5));
    }

    @Test
    public void test7() {
        Output.staticTest();
        Output output = new OutputImpl();
        output.print("tantantan");
    }
}
