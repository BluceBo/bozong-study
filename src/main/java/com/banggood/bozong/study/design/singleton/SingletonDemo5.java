package com.banggood.bozong.study.design.singleton;

public class SingletonDemo5 {

    private SingletonDemo5() {

    }

    private static enum SingletonEnumInstance {
        INSTANCE;
        //枚举元素为单例
        private SingletonDemo5 singletonDemo5;
        private SingletonEnumInstance() {
            System.out.println("SingletonDemo5");
            singletonDemo5 = new SingletonDemo5();
        }
        public SingletonDemo5 getInstance() {
            return singletonDemo5;
        }
    }

    public static SingletonDemo5 getInstance() {
        return SingletonEnumInstance.INSTANCE.getInstance();
    }
}
