package com.banggood.bozong.study.design.singleton;

/**
* @description: 静态内部类方式
* @author:  blucebo
* @createDate:  2019/1/20 18:35
* @updateUser:  blucebo
* @updateDate:  2019/1/20 18:35
* @updateRemark:
* @version: 1.0
*/
public class SingletonDemo4 {
    private static class SingletonClassInstance {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }
    public static SingletonDemo4 getInstance() {
        return SingletonClassInstance.instance;
    }
    private SingletonDemo4() {

    }
}
