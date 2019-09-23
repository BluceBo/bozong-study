package com.banggood.bozong.study.javathink.chapter21;

/**
 * Created by admin on 2018/4/7.
 * 添加更多的线程去驱动更多的业务
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0;i < 5;i++) {
            new Thread(new LiftOff()).start();
            System.out.println("Waiting for LiftOff");
        }
    }
}
