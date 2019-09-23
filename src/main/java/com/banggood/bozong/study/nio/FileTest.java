package com.banggood.bozong.study.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
    /**
     * 1408
     * 普通IO完成文件复制
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\mnt\\data\\[电影天堂www.dygod.net].赌圣DVD国语中字-cd1.rmvb");
        FileOutputStream fos = new FileOutputStream("E:\\mnt\\data\\3.rmvb");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) > 0) {
            fos.write(buf,0,len);
        }
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
