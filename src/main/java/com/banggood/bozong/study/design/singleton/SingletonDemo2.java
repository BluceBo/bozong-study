package com.banggood.bozong.study.design.singleton;

/**
* @description: 懒汉式
* @author:  blucebo
* @createDate:  2019/1/20 16:59
* @updateUser:  blucebo
* @updateDate:  2019/1/20 16:59
* @updateRemark:
* @version: 1.0
*/
public class SingletonDemo2 {

    public static SingletonDemo2 singletonDemo2 = null;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance() {
        if (singletonDemo2 == null) {
            singletonDemo2 = new SingletonDemo2();
        }
        return singletonDemo2;
    }
}
