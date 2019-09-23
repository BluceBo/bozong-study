package com.banggood.bozong.study.design.singleton;

/**
* @description: 饿汉式
* @author:  blucebo
* @createDate:  2019/1/20 16:54
* @updateUser:  blucebo
* @updateDate:  2019/1/20 16:54
* @updateRemark:
* @version: 1.0
*/
public class SingletonDemo1 {

    public static SingletonDemo1 singletonDemo1 = new SingletonDemo1();

    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        return singletonDemo1;
    }
}
