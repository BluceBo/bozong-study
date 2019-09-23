package com.banggood.bozong.study.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    /**
     * 1427
     * 非直接缓冲区完成文件复制
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\mnt\\data\\[电影天堂www.dygod.net].赌圣DVD国语中字-cd1.rmvb");
        FileOutputStream fos = new FileOutputStream("E:\\mnt\\data\\1.rmb");
        //获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            //切换为读取模式
            buffer.flip();
            //将缓冲区中的数据写入通道中
            outChannel.write(buffer);
            buffer.clear();
        }
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
