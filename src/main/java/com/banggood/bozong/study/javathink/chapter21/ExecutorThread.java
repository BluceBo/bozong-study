package com.banggood.bozong.study.javathink.chapter21;

/**
 * Created by admin on 2018/9/18.
 */
public class ExecutorThread extends Thread {
    private ExecutorUtil executorUtil;
    private String name;
    public ExecutorThread(ExecutorUtil executorUtil,String name) {
        this.executorUtil = executorUtil;
        this.name = name;
    }
    public void run() {
        executorUtil.getName(name);
    }
}
