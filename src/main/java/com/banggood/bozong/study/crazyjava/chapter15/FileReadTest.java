package com.banggood.bozong.study.crazyjava.chapter15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\crazyjava\\chapter15\\FileReadTest.java");
            //创建一个字符数组
            char[] buf = new char[32];
            //用于保存读取的字符数
            int hasRead = 0;
            //使用循环将字符读取到字符数组中
            while ((hasRead = fr.read(buf)) > 0) {
                System.out.println(new String(buf,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
