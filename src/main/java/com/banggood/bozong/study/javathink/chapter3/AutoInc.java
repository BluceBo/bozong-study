package com.banggood.bozong.study.javathink.chapter3;

/**
 * Created by admin on 2018/4/10.
 *
 */
public class AutoInc {
    public static void main(String[] args) {
        int i = 2;
        int j = 2;
        int k = ++i;    //i=3
        int z = i++;    //i=4,z=3
        int y = 1;
        System.out.println("k = " + k);
        System.out.println("k = " + z);
        System.out.println("i = " + i);
        System.out.println(y = i + 1);  //在打印函数中是先执行运算再打印值
    }
}
