package com.banggood.bozong.study.javathink.chapter21;

import java.util.concurrent.Callable;

/**
 * Created by admin on 2018/4/18.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
