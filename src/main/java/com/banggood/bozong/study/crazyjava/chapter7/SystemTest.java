package com.banggood.bozong.study.crazyjava.chapter7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
    public static void main(String[] args) throws IOException {
        //获取系统的所有环境变量
        Map<String,String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + "--->" + env.get(name));
        }
        //获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        //获取所有的系统属性
        Properties props = System.getProperties();
        //将所有的系统属性保存到props.txt文件中
        props.store(new FileOutputStream("props.txtx"),"System Properties");
        //输出特定的系统属性
        System.out.println(System.getProperty("os.name"));
    }
}
