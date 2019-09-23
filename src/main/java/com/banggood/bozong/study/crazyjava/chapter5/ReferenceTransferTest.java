package com.banggood.bozong.study.crazyjava.chapter5;

public class ReferenceTransferTest {
    //下面三行代码实现a,b变量的值交换
    public static void swap(DataWrap dataWrap) {
        //定义一个临时变量来保存变量a变量的值
        int tmp = dataWrap.a;
        //把b的值赋给a
        dataWrap.a = dataWrap.b;
        //把临时变量tmp的值赋给a
        dataWrap.a = tmp;
        System.out.println("swap方法里，a的值是" + dataWrap.a + "；b的值是" + dataWrap.b);
    }

    public static void main(String[] args) {
        DataWrap dataWrap = new DataWrap();
        dataWrap.a = 6;
        dataWrap.b = 9;
        swap(dataWrap);
        System.out.println("交换结束之后，变量a的值是" + dataWrap.a + "；变量b的值是" + dataWrap.b);
    }
}
