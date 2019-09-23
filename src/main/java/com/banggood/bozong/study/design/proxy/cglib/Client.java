package com.banggood.bozong.study.design.proxy.cglib;

import com.banggood.bozong.study.design.proxy.dynamicProxy.Star;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(StarImpl.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibProxy());
        // 创建代理对象
        StarImpl proxy = (StarImpl)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sing();
    }
}
