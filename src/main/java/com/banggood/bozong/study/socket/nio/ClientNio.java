package com.banggood.bozong.study.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ClientNio {

    public static void main(String[] args) {
        //远程地址创建
        InetSocketAddress remote = new InetSocketAddress("localhost",9999);
        SocketChannel channel = null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            //开启通道
            channel = SocketChannel.open();
            channel.connect(remote);
            Scanner reader = new Scanner(System.in);
            while (true) {
                System.out.println("put message for send to server");
                String line = reader.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                //将控制台输入的数据写入到缓存
                buffer.put(line.getBytes("UTF-8"));
                //重置缓存游标
                buffer.flip();
                //将数据发送给服务器
                channel.write(buffer);
                //清空缓存数据
                buffer.clear();
                //读取服务器返回的数据
                int readLength = channel.read(buffer);
                if (readLength == -1) {
                    break;
                }
                //重置缓存有游标
                buffer.flip();
                byte[] datas = new byte[buffer.remaining()];
                //读取数据到字节数组
                buffer.get(datas);
                System.out.println("from server : " + new String(datas,"UTF-8"));
                buffer.clear();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
