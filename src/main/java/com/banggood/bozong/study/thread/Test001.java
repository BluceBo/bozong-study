package com.banggood.bozong.study.thread;

import com.banggood.bozong.study.thread.sxtbase.ExList;

/**
 * Created by admin on 2018/12/4.
 * 线程分几种
 */
public class Test001 {
    public static void main(String[] args) {
        ExList<String> exList = new ExList<>();
        exList.add("aaa");
        exList.add("aaa");
        exList.add("aaa");
        exList.add("aaa");
        for (int i=0;i<exList.size();i++) {
            System.out.println(exList.get(i));
        }
    }
}
