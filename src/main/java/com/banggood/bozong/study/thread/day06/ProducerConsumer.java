package com.banggood.bozong.study.thread.day06;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerThread implements Runnable{
    //创建生产者阻塞队列
    private BlockingQueue blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean FLAG = true;
    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动");
        while (FLAG) {
            String data = count.incrementAndGet() + "";
            try {
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + "生产队列" + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "生产队列" + data + "失败");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerThread implements Runnable{
    //创建消费者阻塞队列
    private BlockingQueue<String> blockingQueue;
    private volatile boolean FLAG = true;
    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者开始启动");
        while (FLAG) {
            try {
                String poll = blockingQueue.poll(1, TimeUnit.SECONDS);
                if (StringUtils.isNoneBlank(poll)) {
                    System.out.println(Thread.currentThread().getName() + "消费队列" + poll + "成功");
                } else {
                    System.out.println("消费线程未获取数据");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread t1 = new Thread(producerThread);
        Thread t2 = new Thread(consumerThread);
        t1.start();
        t2.start();
    }
}
