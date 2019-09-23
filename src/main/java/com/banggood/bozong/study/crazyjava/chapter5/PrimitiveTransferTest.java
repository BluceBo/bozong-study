package com.banggood.bozong.study.crazyjava.chapter5;

public class PrimitiveTransferTest {
    //下面三行代码实现a,b变量的值交换
    public static void swap(int a,int b) {
        //定义一个临时变量来保存变量a变量的值
        int tmp = a;
        //把b的值赋给a
        a = b;
        //把临时变量tmp的值赋给a
        a = tmp;
        System.out.println("swap方法里，a的值是" + a + "；b的值是" + b);
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        swap(a,b);
        System.out.println("交换结束之后，变量a的值是" + a + "；变量b的值是" + b);
    }
}
