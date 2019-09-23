package com.banggood.bozong.study.javathink.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 2018/4/18.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> result = new ArrayList<Future<String>>();
        for(int i=0 ;i < 10;i++) {
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : result) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
