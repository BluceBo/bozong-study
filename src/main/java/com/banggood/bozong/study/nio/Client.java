package com.banggood.bozong.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;

//nio客户端
class NioClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端已经启动........");
        //1.创建socket通信
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
        //2.切换异步非阻塞
        socketChannel.configureBlocking(false);
        //3.制定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(new Date().toString().getBytes());
        //4.切换到读取模式
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
        //5.关闭通道
        socketChannel.close();
    }
}

//nio服务器端
class NioServer{
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端被启动......");
        //1.创建服务通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.切换异步非阻塞
        serverSocketChannel.configureBlocking(false);
        //3.绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器中，并且监听已接收到的事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮训获取已经准备就绪的事件
        while (selector.select() > 0) {
            //7.获取当期选择器，有注册已经监听到的事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while(keyIterator.hasNext()) {
                //8.获取准备就绪事件
                SelectionKey key = keyIterator.next();
                //9.判断事件准备就绪
                if (key.isAcceptable()) {
                    //10.若接收就绪，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //12.将通道注册到服务器上
                    socketChannel.register(selector,SelectionKey.OP_ACCEPT);
                } else if (key.isReadable()) {
                    //13.获取当前选择就绪状态的通道
                    SocketChannel channel = (SocketChannel)key.channel();
                    //14.读取数据
                    int len = 0;
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while ((len = channel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                    channel.close();
                }
            }
        }
    }
}

public class Client {
}
