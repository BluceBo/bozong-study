package com.banggood.bozong.study.crazyjava.chapter6;

public class CreateInnerInstance {
    public static void main(String[] args) {
        Out.In in = new Out().new In("测试信息");
        /*
        上面代码可改为如下三行代码使用OutterClass.InnerClass的形式定义内部类
        Out.In in;
        Out out = new Out();
        in = out.new In("测试信息")*/
    }
}
