package com.banggood.bozong.study.javathink.chapter21;

/**
 * Created by admin on 2018/4/7.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        System.out.println("Waiting for LiftOff");
    }
}
