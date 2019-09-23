package com.banggood.bozong.study.bigdata.javabase.thread;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/8/8 23:07
 * @Modified By:
 * @Version: 1.0
 */
public class App {
    public static void main(String[] args) {
        HoneyPool honeyPool = new HoneyPool();
        for (int i=0;i<100;i++) {
            new Bee(honeyPool,"蜜蜂:" + i).start();
        }
        new Bear(honeyPool,"熊大").start();
        new Bear(honeyPool,"熊二").start();
    }
}
