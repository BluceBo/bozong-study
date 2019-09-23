package com.banggood.bozong.study.javathink.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2018/4/7.
 * SingleThreadExecutor就像线程数量为1的FixedThreadPool。这对于你希望在另一个线程中连续
 * 运行的任何事物来说是非常有用的。
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0;i < 5;i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
