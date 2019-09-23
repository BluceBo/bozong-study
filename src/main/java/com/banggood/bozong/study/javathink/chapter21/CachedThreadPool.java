package com.banggood.bozong.study.javathink.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2018/4/7.
 * CachedThreadPool将为每个任务都创建一个线程
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0;i < 5;i++) {
            executorService.execute(new LiftOff());
        }
        //防止新任务被提交给Executor
        executorService.shutdown();
    }
}
