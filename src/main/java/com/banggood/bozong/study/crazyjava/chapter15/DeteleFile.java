package com.banggood.bozong.study.crazyjava.chapter15;

import java.io.File;

public class DeteleFile {
    public static void main(String[] args) {
        File file = new File("F:/BaiduYunDownload/适合自学的C语言基础视频_vedio");
        deteleFile(file);
    }
    public static void deteleFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()) {
                deteleFile(file1);
            }
            file1.delete();
        }
        file.delete();
    }
}
