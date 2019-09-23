package com.banggood.bozong.study.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future> list = new ArrayList<Future>();
        Callable c = new CallableDemo();
        for (int j=0;j<10;j++) {
            Future<String> submit = pool.submit(c);
            list.add(submit);
        }
        // 关闭线程池
        pool.shutdown();
        for (Future submit : list) {
            System.out.println(submit.get());
        }
    }
}
