package com.banggood.bozong.study.crazyjava.chapter6;

import javax.swing.*;

public class LambdaYinYong {
    public static void main(String[] args) {
        //下面代码使用Lambda表达式创建Converter对象
        Converter converter1 = from -> Integer.valueOf(from);
        Integer val = converter1.convert("99");
        System.out.println(val);    //输出整数99
        //方法引用代替Lambda表达式：引用类方法
        //函数式接口中被实现方法的全部参数传递给该类方法作为参数
        Converter converter2 = Integer::valueOf;
        Integer val2 = converter2.convert("88");
        System.out.println(val2);   //输出整数88

        //下面代码使用Lambda表达式创建Converter对象
        Converter converter3 = from -> "fkit.org".indexOf(from);
        Integer val3 = converter3.convert("it");
        System.out.println(val3);   //输出2
        //方法引用代替Lambda表达式：引用特定对象的实例方法
        //函数式接口被实现方法的全部参数传给该方法作为参数
        Converter converter4 = "fkit.org"::indexOf;
        Integer val4 = converter4.convert("it");
        System.out.println(val4);   //输出2

        //下面代码使用Lambda表达式创建MyTest对象
        MyTest mt = (a,b,c) -> a.substring(b,c);
        String str = mt.test("Java I Love you",2,9);
        System.out.println(str);    //输出：va T Lo
        //方法引用代替Lambda表达式：引用某类对象的实例方法
        //函数式接口中被实现方法的第一个参数作为调用者
        //后面的参数全部传给该方法作为参数
        MyTest mt1 = String::substring;
        String str1 = mt1.test("Java I Love you",2,9);
        System.out.println(1);    //输出：va T Lo

        //下面代码使用Lambda表达式创建YourTest对象
        YourTest yt = (String a) -> new JFrame(a);
        JFrame jf = yt.win("我的窗口");
        System.out.println(jf);
        //构造器引用代替Lambda表达式
        //函数式接口被实现方法的全部参数传给该构造器作为参数
        YourTest yt1 = JFrame::new;
        JFrame jf1 = yt.win("我的窗口");
        System.out.println(jf1);
    }
}
