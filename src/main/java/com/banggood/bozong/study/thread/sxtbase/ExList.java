package com.banggood.bozong.study.thread.sxtbase;

import javax.management.monitor.Monitor;

public class ExList<T> {
    //初始化集合长度
    private static final int DEFAULT_CAPACITY = 10;
    //集合的最大长度
    private int maxSize;

    private int index = 0;

    private Object[] arry;

    public ExList() {
        this.arry=new Object[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
    }

    public void add(Object object) {
       if (index == maxSize) {
           maxSize = maxSize + 10;
           Object[] arry1 = new Object[maxSize];
           for (int i=0;i<index;i++) {
               arry1[i]=arry[i];
           }
       }
       arry[index]=object;
       index++;
    }

    public int size() {
        return index;
    }

    public Object get(int i) {
        return arry[i];
    }
}
