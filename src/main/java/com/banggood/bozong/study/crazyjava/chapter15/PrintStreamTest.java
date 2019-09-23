package com.banggood.bozong.study.crazyjava.chapter15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("E:\\shop-workspace\\bozong-study\\doc\\newFile.txt");
            PrintStream ps = new PrintStream(fos);
            //使用PrintStream执行输出
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

