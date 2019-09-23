package com.banggood.bozong.study.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class ServerNio implements Runnable {
    //多路复用器，选择器。用于注册通道的。
    private Selector selector;
    //定义了两个缓存分别用于度和写。初始化空间为1024
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public ServerNio(int port) {
        init(port);
    }

    public static void main(String[] args) {
        new Thread(new ServerNio(9999)).start();
    }

    private void  init(int port) {
        try {
            System.out.println("server starting at port" + port + " .......");
            this.selector = Selector.open();
            //开启服务通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //非阻塞
            serverSocketChannel.configureBlocking(false);
            //绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port));
            /**
             * 注册，并标记当前服务通道状态
             * OP_ACCEPT:连接成功的标记位
             * OP_READ:可以读取数据的标记
             * OP_WRITE:可以写入数据的标记
             * OP_CONNECT:连接建立后的标记
             */
            serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //阻塞方法，当至少一个通道被选中，此方法返回
                this.selector.select();
                //返回选中的通道标记集合,集合中保存的是通道的标记。相当于通道的ID。
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    //将本次要处理的通道从集合中删除，下面循环根据新的通道列表再次执行必要的业务逻辑
                    keys.remove();
                    //通道是否有效
                    if (key.isValid()) {
                        //阻塞状态
                        try {
                            if (key.isAcceptable()) {
                                accept(key);
                            }
                        } catch (Exception ex) {
                            key.cancel();
                        }
                        //可读状态
                        try {
                            if (key.isReadable()) {
                                read(key);
                            }
                        } catch (Exception ex) {
                            //断开连接，出现异常
                            key.cancel();
                        }
                        try {
                            //可写状态
                            if (key.isWritable()) {
                                write(key);
                            }
                        } catch (Exception ex) {
                            key.cancel();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) {
        try {
            //此通道为init方法注册到Selector上ServerSocketChannel
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            //阻塞方法，当客户端发起请求后返回。此通道和客户端一一对应。
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            //设置对应客户端的通道标记状态，此通道为读取数据使用
            channel.register(this.selector,SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            //清空读缓存
            this.readBuffer.clear();
            //获取通道
            SocketChannel channel = (SocketChannel) key.channel();
            //将通道中的数据读取到缓存中，通道中数据就是客户端发送给服务器的数据
            int readLength = channel.read(readBuffer);
            //检查客户端是否写入数据
            if (readLength == -1) {
                //关闭通道
                key.channel().close();
                //关闭连接
                key.channel();
                return;
            }
            /**
             * nio中最复杂的操作就是Buffer的控制。
             * Buffer中有一个游标。游标信息在操作后不会归零，如果直接访问Buffer的话，数据有不一致的可能。
             * flip是重置游标的方法。NIO编程中，flip是常用方法。
             */
            this.readBuffer.flip();
            //字节数组，保存具体数据的。remaining()是获取Buffer中具体数据长度的方法。
            byte[] datas = new byte[readBuffer.remaining()];
            //将Buffer中的有效数据保存到字节数组中
            readBuffer.get(datas);
            System.out.println("from " + channel.getRemoteAddress() + " client : " + new String(datas,"UTF-8"));
            //注册通道标记位写操作
            channel.register(this.selector,SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                key.channel().close();
                key.cancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void write(SelectionKey key) {
        this.writeBuffer.clear();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("put message for send to client > ");
            String line = reader.nextLine();
            //将控制台输入的字符串写入Buffer中。写入数据是一个字节数据。
            writeBuffer.put(line.getBytes("UTF-8"));
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            socketChannel.register(this.selector,SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
