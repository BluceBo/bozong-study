package com.banggood.bozong.study.thread.callable;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    private int i=0;
    private Object object=new Object();
    @Override
    public String call() throws Exception {
        synchronized (object) {
            for (int j=0;j<10000;j++) {
                i++;
            }
            return Thread.currentThread().getName() + ">>>>>>" + "Callable测试Demo"+i;
        }

    }
}
