package com.banggood.bozong.study.javathink.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2018/9/18.
 */
public class App {
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        ExecutorUtil executorUtil = new ExecutorUtil();
        for (int i = 0 ; i < 5 ; i++) {
            threadPoolExecutor.submit(new ExecutorThread(executorUtil,"线程====>>>>" + i));
        }
    }
}
