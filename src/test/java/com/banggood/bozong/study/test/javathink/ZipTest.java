package com.banggood.bozong.study.test.javathink;

import org.junit.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/7/7 23:28
 * @Modified By:
 * @Version: 1.0
 */
public class ZipTest {
    @Test
    public void zip() throws Exception {
        //创建文件输出流对象
        FileOutputStream fos = new FileOutputStream("E:\\BaiduYunDownload\\tanbo.zip");
        //创建文件压缩流对象
        ZipOutputStream zos = new ZipOutputStream(fos);
        String[] arr = {"E:\\BaiduYunDownload\\2015-10-07 161121.jpg",
                "E:\\BaiduYunDownload\\2017年8月发货基础数据脚本.sql",
                "E:\\BaiduYunDownload\\2017年8月发货凭证基础数据文档.docx"};
        for (String path : arr) {
            addFile(zos,path);
        }
        fos.close();
        zos.close();
    }
    /**
     * @Author tanbo
     * @Description 
     * @Date 23:41 2018/7/7
     * @Param [zos, path]
     * @return void
     **/
    private void addFile(ZipOutputStream zos, String path) throws IOException {
        File file = new File(path);
        zos.putNextEntry(new ZipEntry(file.getName()));
        //创建文件输入流对象
        FileInputStream fis = new FileInputStream(path);
        //将文件写入压缩流
        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1) {
            zos.write(buf,0,len);
        }
        fis.close();
        zos.closeEntry();
    }
    /**
     * @Author admin
     * @Description 解压
     * @Date 23:49 2018/7/7
     * @Param
     * @return
     **/
    @Test
    public void unzip() throws IOException {
        //创建文件输入流对象
        FileInputStream fis = new FileInputStream("E:\\BaiduYunDownload\\tanbo.zip");
        //创建文件输入压缩流对象
        ZipInputStream zis = new ZipInputStream(fis);
        //通过文件压缩输入流对象读取压缩文件
        ZipEntry zipEntry = null;
        byte[] buf = new byte[1024];
        int len;
        while ((zipEntry = zis.getNextEntry()) != null) {
            String name = zipEntry.getName();
            //创建文件输出流对象
            FileOutputStream fos = new FileOutputStream("E:\\BaiduYunDownload\\tanbo\\" + name);
            while ((len = zis.read(buf)) != -1) {
                fos.write(buf,0,len);
            }
            zis.closeEntry();
            fos.close();
        }
        fis.close();
        zis.close();
    }
}
