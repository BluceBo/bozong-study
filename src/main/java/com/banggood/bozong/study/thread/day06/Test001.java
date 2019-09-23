package com.banggood.bozong.study.thread.day06;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Test001 {
    //阻塞式队列最大的好处是，能够防止容器溢出，防止数据丢失
    public static void main(String[] args) {
        //非阻塞式队列
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.offer("张三");
        concurrentLinkedDeque.offer("李四");
        concurrentLinkedDeque.offer("王麻子");
        //获取总长度
        System.out.println(concurrentLinkedDeque.size());
        //从头获取元素，不删除元素
        System.out.println(concurrentLinkedDeque.peek());
        //从头获取元素，删除该元素
        System.out.println(concurrentLinkedDeque.poll());
        System.out.println(concurrentLinkedDeque.poll());
        System.out.println(concurrentLinkedDeque.poll());
        System.out.println(concurrentLinkedDeque.poll());
    }
}
