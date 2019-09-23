package com.banggood.bozong.study.socket.aio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Scanner;

public class ServerHandlerAio implements CompletionHandler<AsynchronousSocketChannel, ServerAio> {
    /**
     * 业务逻辑处理,当请求到来后，监听成功，应该做什么。
     * 一定要实现的逻辑：为下一次客户端请求开启监听。accept方法调用。
     * result参数：就是和客户端直接建立关联的通道。
     * 无论是BIO、NIO、AIO，一旦连接建立，两端是平等的。
     * result中有通道中的所有相关数据。如：OS操作系统准备好的读取数据缓存，或等待返回数据的缓存。
     * @param result
     * @param attachment
     */
    @Override
    public void completed(AsynchronousSocketChannel result, ServerAio attachment) {
        //处理下一次的客户端请求。类似递归
        attachment.getServerSocketChannel().accept(attachment,this);
        doRead(result);
    }

    private void doRead(AsynchronousSocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * 异步读操作，read(Buffer destination,A attachment,CompletionHandler<Integer,? super A></>)
         * destination：目的地，是处理客户端传递数据的中转缓存，可以不使用。
         * attachment：处理客户端传递数据的对象，通常使用Buffer处理。
         * handler：处理逻辑
         */
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            /**
             * 业务逻辑，读取客户端传输数据
             * attachment：在completed方法执行的时候，OS已经将客户端请求数据写入Buffer中了。
             * 但是未复位，使用前一定要复位
             * @param result
             * @param attachment
             */
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                try {
                    System.out.println(attachment.capacity());
                    attachment.flip();
                    System.out.println("from client : " + new String(attachment.array(),"UTF-8"));
                    doWrite(channel);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private void doWrite(AsynchronousSocketChannel channel) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            System.out.println("enter message send to client > ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            buffer.put(line.getBytes("UTF-8"));
            //重点：必须复位
            buffer.flip();
            //write()方法是一个异步操作。具体实现由OS实现。可以增加get方法，实现阻塞，等待OS的写操作结束。
            channel.write(buffer);
            //增加get方法，实现阻塞，等待OS的写操作结束
            //channel.write(buffer).get();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常处理逻辑
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, ServerAio attachment) {
        exc.printStackTrace();
    }
}
