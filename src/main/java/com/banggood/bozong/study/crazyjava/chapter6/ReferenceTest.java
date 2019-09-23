package com.banggood.bozong.study.crazyjava.chapter6;

import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        //创建一个字符串对象
        String str = new String("疯狂Java讲义");
        //创建一个弱引用，让此若引用引用"疯狂Java讲义"字符串
        WeakReference wr = new WeakReference(str);
        //切断str引用和"疯狂Java讲义"字符串之间的引用
        str = null;
        //取出弱引用所引用的对象
        System.out.println(wr.get());
        //强制垃圾回收
        System.gc();
        System.out.println(wr.get());
    }
}
