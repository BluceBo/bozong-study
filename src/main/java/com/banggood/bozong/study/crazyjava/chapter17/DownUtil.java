package com.banggood.bozong.study.crazyjava.chapter17;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/7/3 20:41
 * @Modified By:
 * @Version: 1.0
 */
public class DownUtil {
    //定义下载资源的路径
    private String path;
    //指定所下载文件的保存位置
    private String targetFile;
    //定义需要多个线程下载资源
    private int threadNum;
    //定义下载的线程对象
    private DownTread[] threads;
    //定义下载文件的总大小
    private int fileSize;
    public DownUtil(String path,String targetFile,int threadNum) {
        this.path = path;
        threads = new DownTread[threadNum];
        this.targetFile = targetFile;
        this.threadNum = threadNum;
    }
    public void download() {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置连接时间最大时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //设置请求方式
            conn.setRequestMethod("GET");
            //设置请求属性
            conn.setRequestProperty("Accept","image/gif, image/jpeg, image/pjpeg, "
                    + "application/x-shockwave-flash, application/xaml+xml, "
                    + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                    + "application/x-ms-application, application/vnd.ms-excel, "
                    + "application/vnd.ms-powerpoint, application/msword, */**");
            conn.setRequestProperty("Accept-Language","zh-CN");
            conn.setRequestProperty("Charset","UTF-8");
            conn.setRequestProperty("Connection","Keep-Alive");
            //得到文件的大小
            fileSize = conn.getContentLength();
            conn.disconnect();
            //获取每个线程分的文件块大小
            int currentPartSize = fileSize / threadNum + 1;
            //读取目标文件，没有文件则自动创建文件
            RandomAccessFile randomAccessFile = new RandomAccessFile(targetFile,"rw");
            //设置本地文件的大小
            randomAccessFile.setLength(fileSize);
            randomAccessFile.close();
            for (int i = 0;i < threadNum; i++) {
                //计算每个线程的开始位置
                int startPos = i * currentPartSize;
                //每个线程使用一个RandomAccessFile对象进行下载
                RandomAccessFile currentPart = new RandomAccessFile(targetFile,"rw");
                //定位该线程的下载位置
                currentPart.seek(startPos);
                //创建下载线程
                threads[i] = new DownTread(startPos,currentPartSize,currentPart);
                //启动下载线程
                threads[i].start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double getCompleteRate() {
        //统计多个线程已下载的总大小
        int sumSize = 0;
        for (int i = 0;i < threadNum;i++) {
            sumSize+=threads[i].length;
        }
        //返回已完成的百分比
        return sumSize*1.0/fileSize;
    }
    private class DownTread extends Thread {
        //当前线程的下载位置
        private int startPos;
        //定义当前线程负责下载文件的大小
        private int currentPartSize;
        //当前线程需要下载的文件块
        private RandomAccessFile currentPart;
        //定义该线程已下载的字节数
        public int length;
        public DownTread(int startPos,int currentPartSize,RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //设置连接时间最大时间为5秒
                conn.setConnectTimeout(5 * 1000);
                //设置请求方式
                conn.setRequestMethod("GET");
                //设置请求属性
                conn.setRequestProperty("Accept","image/gif, image/jpeg, image/pjpeg, "
                + "application/x-shockwave-flash, application/xaml+xml, "
                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                + "application/x-ms-application, application/vnd.ms-excel, "
                + "application/vnd.ms-powerpoint, application/msword, */**");
                conn.setRequestProperty("Accept-Language","zh-CN");
                conn.setRequestProperty("Charset","UTF-8");
                //获取输入流
                InputStream inputStream = conn.getInputStream();
                //跳过startPos个字节，表名该线程只下载自己负责的那部分文件
                inputStream.skip(this.startPos);
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buf)) != -1 && length < currentPartSize) {
                    currentPart.write(buf,0,len);
                    //累计该线程下载的总大小
                    length += len;
                }
                inputStream.close();
                currentPart.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
