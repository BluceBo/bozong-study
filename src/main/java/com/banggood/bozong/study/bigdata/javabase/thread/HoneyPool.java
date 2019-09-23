package com.banggood.bozong.study.bigdata.javabase.thread;

import java.util.LinkedList;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/7/25 22:47
 * @Modified By:
 * @Version: 1.0
 */
public class HoneyPool {
    private LinkedList<Integer> honeyPool = new LinkedList<>();
    public int add(int i) {
        honeyPool.add(i);
        return i;
    }
    public int remove() {
        while (honeyPool.size() < 20) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return honeyPool.removeFirst();
    }
    //蜂蜜池的蜂蜜量
    public int size() {
        return honeyPool.size();
    }
}
