package com.banggood.bozong.study.socket.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class ClientAio {
    private AsynchronousSocketChannel channel;

    public ClientAio(String host,int port) {
        init(host,port);
    }

    private void init(String host, int port) {
        try {
            channel = AsynchronousSocketChannel.open();
            channel.connect(new InetSocketAddress(host,port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String line) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(line.getBytes("UTF-8"));
            buffer.flip();
            channel.write(buffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer).get();
            buffer.flip();
            System.out.println("from server : " + new String(buffer.array(),"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doDestory() {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ClientAio client = new ClientAio("localhost",9999);
        try {
            System.out.println("enter message send to server >");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            client.write(line);
            client.read();
        } finally {
            client.doDestory();
        }
    }
}
