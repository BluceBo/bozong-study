package com.banggood.bozong.study.bigdata.javabase.arichiver;

import java.io.*;

/**
 * 归档与解档
 * @Author: tanbo
 * @Description:
 * @Date: Create in 11:25 2018/6/25
 * @Modified By:
 */
public class Archiver {
    /**
     * 根据文件对象数组进行归档
     * @param originalFiles
     * @param destFile
     */
    public static void getArchiverFile(File[] originalFiles, File destFile) {
        //创建输出流对象
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(destFile);
            for (File file : originalFiles) {
                //获取文件名
                String fileName = file.getName();
                //将文件文件名转换成字节数组
                byte[] fileNameBytes = fileName.getBytes();
                //将文件名长度转换成字节数组
                byte[] fileNameLenBytes = ArchiverUtil.int2bytes(fileNameBytes.length);
                //将文件内容长度转换成字节数组
                byte[] fileLenBytes = ArchiverUtil.int2bytes((int) file.length());
                //读取文件内容到数组中
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                FileInputStream fis = new FileInputStream(file);
                byte[] buf = new byte[1024];
                int len;
                while ((len = fis.read(buf)) != -1) {
                    baos.write(buf,0,len);
                }
                //得到文件内容
                byte[] fileBytes = baos.toByteArray();
                fis.close();
                baos.close();
                //创建字节数组存储所有的数据
                byte[] bytes = new byte[fileBytes.length + fileNameBytes.length + fileLenBytes.length + fileNameLenBytes.length];
                System.arraycopy(fileNameLenBytes,0,bytes,0,fileNameLenBytes.length);
                System.arraycopy(fileNameBytes,0,bytes,fileNameLenBytes.length,fileNameBytes.length);
                System.arraycopy(fileLenBytes,0,bytes,fileNameLenBytes.length+fileNameBytes.length,fileLenBytes.length);
                System.arraycopy(fileBytes,0,bytes,fileNameLenBytes.length+fileNameBytes.length+fileLenBytes.length,fileBytes.length);
                fos.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据文件路径进行解档
     * @param originalFilePaths
     * @param destFilePath
     */
    public static void getArchiverFile(String[] originalFilePaths, String destFilePath) {
        File[] originalFiles = new File[originalFilePaths.length];
        File destFile = new File(destFilePath);
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i =0;i<originalFilePaths.length;i++) {
            originalFiles[i] = new File(originalFilePaths[i]);
        }
        getArchiverFile(originalFiles,destFile);
    }

    /**
     * 解析归档文件
     * @param filePath
     */
    public static void resolverArchiverFile(String filePath) {
        //创建文件输入流读取文件
        FileInputStream fis = null;
        //创建字节输出流对象
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(filePath);
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) > 0) {
                //将数据写入字节输出流中
                baos.write(buf,0,len);
            }
            //将字节输出流转换成字节数据
            byte[] bytes = baos.toByteArray();
            //解析的数组长度计数器
            int count = 0;
            //进行解档
            while (true) {
                //获取文件名长度字节数组
                byte[] fileNameLenBytes = new byte[4];
                //复制文件名长度数组到新数组
                System.arraycopy(bytes,count,fileNameLenBytes,0,4);
                count = count + 4;
                //将字节数组转换成int类型数字
                int fileNameLen = ArchiverUtil.bytes2int(fileNameLenBytes);
                //创建获取文件名字节数组
                byte[] fileNameBytes = new byte[fileNameLen];
                //复制文件名字节数组到新数组
                System.arraycopy(bytes,count,fileNameBytes,0,fileNameLen);
                count = count + fileNameLen;
                //创建文件内容长度数组
                byte[] fileLenBytes = new byte[4];
                //复制文件内容长度到新数组
                System.arraycopy(bytes,count,fileLenBytes,0,4);
                count = count + 4;
                //将文件内容长度数组转换成int类型
                int fileLen = ArchiverUtil.bytes2int(fileLenBytes);
                //创建文件内容数组
                byte[] fileBytes = new byte[fileLen];
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
