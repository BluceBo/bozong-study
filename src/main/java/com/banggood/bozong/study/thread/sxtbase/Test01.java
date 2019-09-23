package com.banggood.bozong.study.thread.sxtbase;

import java.util.concurrent.CountDownLatch;

/**
 *自定义容器，提供新增元素（add）和获取元素数量（size）方法。
 * 启动两个线程。线程1向容器中新增10个数据。线程2监听容器元素数量，当容器元素数量为5时，线程2输出信息并终止。
 */
public class Test01 {

    public static void main(String[] args) {
        ExList<Integer> exList = new ExList<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    System.out.println("add Object to Container " + i);
                    exList.add(i);
                    if (exList.size() == 5) {
                        countDownLatch.countDown();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (exList.size() != 5) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("size=5");
            }
        }).start();
    }
}
