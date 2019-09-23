package com.banggood.bozong.study.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedByteBufferTest {
    /**
     * 使用直接缓冲区完成对文件的复制
     * 321
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //创建通道
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\mnt\\data\\[电影天堂www.dygod.net].赌圣DVD国语中字-cd1.rmvb"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\mnt\\data\\2.rmvb"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //直接对缓冲区进行数据的读写操作
        byte[] dsf = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(dsf);
        outMappedByteBuffer.get(dsf);
        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
