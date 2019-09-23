package com.banggood.bozong.study.design.singleton;

import java.util.concurrent.CountDownLatch;

/**
* @description: 测试多线程环境系5种创建单例的效率,
* @author:  blucebo
* @createDate:  2019/1/20 20:45
* @updateUser:  blucebo
* @updateDate:  2019/1/20 20:45
* @updateRemark:
* @version: 1.0
*/
public class Client3 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        //CountDownLatch,使用计数器直到所有线程执行结束，若没有结束则一直处于阻塞状态
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0;i < threadNum;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0;i < 100000;i++) {
                        SingletonDemo1 instance = SingletonDemo1.getInstance();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
