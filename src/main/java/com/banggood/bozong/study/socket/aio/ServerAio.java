package com.banggood.bozong.study.socket.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerAio {
    //线程池
    private ExecutorService service;
    //线程组
    private AsynchronousChannelGroup group;
    //服务端通道
    private AsynchronousServerSocketChannel serverSocketChannel;

    public ServerAio(int port) {
        init(9999);
    }

    private void init(int port) {
        try {
            System.out.println("server starting at port : " + port + " ...");
            //定长线程池
            service = Executors.newFixedThreadPool(4);
            //使用线程组
            //group = AsynchronousChannelGroup.withThreadPool(service);
            //serverSocketChannel = AsynchronousServerSocketChannel.open(group);
            //开启服务端通道，通过静态方法创建的
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            //绑定监听端口,服务器启动成功未监听请求。
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("server started .");
            //开始监听
            //AIO开发中，监听是一个类似递归的监听操作。每次监听到客户端请求后，都需要处理逻辑开启下一次的监听
            //下一次的监听，需要服务器的资源继续支持
            serverSocketChannel.accept(this,new ServerHandlerAio());
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerAio(9999);
    }

    public ExecutorService getService() {
        return service;
    }

    public void setService(ExecutorService service) {
        this.service = service;
    }

    public AsynchronousChannelGroup getGroup() {
        return group;
    }

    public void setGroup(AsynchronousChannelGroup group) {
        this.group = group;
    }

    public AsynchronousServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public void setServerSocketChannel(AsynchronousServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }
}
