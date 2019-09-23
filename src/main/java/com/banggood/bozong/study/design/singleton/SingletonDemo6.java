package com.banggood.bozong.study.design.singleton;

import java.io.ObjectInputStream;
import java.io.Serializable;

/**
* @description: 测试懒汉式如何防止反射和反序列化漏洞
* @author:  blucebo
* @createDate:  2019/1/20 20:40
* @updateUser:  blucebo
* @updateDate:  2019/1/20 20:40
* @updateRemark:
* @version: 1.0
*/
public class SingletonDemo6 implements Serializable {
    private static SingletonDemo6 singletonDemo6;
    private SingletonDemo6() {
        if (singletonDemo6 != null) {
            throw new RuntimeException();
        }
    }
    public static synchronized SingletonDemo6 getInstance() {
        if (singletonDemo6 == null) {
            singletonDemo6 = new SingletonDemo6();
        }
        return singletonDemo6;
    }

    //反序列化是，如果定义readResolve()则直接返回此方法指定的对象，而不需要单独再创建新的对象
    private Object readResolve() {
        return singletonDemo6;
    }
}
