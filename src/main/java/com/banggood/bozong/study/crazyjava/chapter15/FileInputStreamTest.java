package com.banggood.bozong.study.crazyjava.chapter15;
import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        //创建字节输入流
        FileInputStream fileInputStream = new FileInputStream("FileInputStreamTest.java");
        //创建一个长度为1024的字节数组
        byte[] buf = new byte[1024];
        //用于保存实际的读取字节数
        int hasRead = 0;
        //将字节数组转换成字符串输出
        while ((hasRead = fileInputStream.read(buf)) > 0) {
            System.out.print(new String(buf,0,hasRead));
        }
        fileInputStream.close();
    }
}
