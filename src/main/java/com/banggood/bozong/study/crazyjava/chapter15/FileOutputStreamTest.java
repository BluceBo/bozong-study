package com.banggood.bozong.study.crazyjava.chapter15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建字节输入流
            fis = new FileInputStream("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\crazyjava\\chapter15\\FileOutputStreamTest.java");
            //创建字节输出流
            fos = new FileOutputStream("E:\\shop-workspace\\bozong-study\\doc\\newFile.txt");
            byte[] buf = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buf)) > 0) {
                //每次读取一次，即写入文件输出流，读多少就写多少
                fos.write(buf,0,hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}