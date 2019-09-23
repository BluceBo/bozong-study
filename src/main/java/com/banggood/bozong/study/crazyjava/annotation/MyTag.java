package com.banggood.bozong.study.crazyjava.annotation;

/**
 * Created by admin on 2018/12/5.
 */
public @interface MyTag {
    //定义一个带成员变量的Annotation
    //Annotation中的成员变量以方法的形式来定义
    //String name();
    //int age();
    //可以设置默认值
    String name() default "tanbo";
    int age() default 26;
}
