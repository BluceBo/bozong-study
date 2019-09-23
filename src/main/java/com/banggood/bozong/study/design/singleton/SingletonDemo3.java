package com.banggood.bozong.study.design.singleton;

public class SingletonDemo3 {

    public static SingletonDemo3 singletonDemo3 = null;

    private SingletonDemo3() {

    }

    public static SingletonDemo3 getInstance() {
        if (singletonDemo3 == null) {
            SingletonDemo3 sc;
            synchronized (SingletonDemo3.class) {
                sc = singletonDemo3;
                if (sc == null) {
                    synchronized (SingletonDemo3.class) {
                        if (sc == null) {
                            sc = new SingletonDemo3();
                        }
                    }
                    singletonDemo3 = sc;
                }
            }
        }
        return singletonDemo3;
    }
}
