package com.banggood.bozong.study.javathink.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2018/4/7.
 * 使用有限的线程集来执行所提交的任务
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0;i < 6;i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
