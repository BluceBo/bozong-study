package com.banggood.bozong.study.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
* @description:
* @author:  blucebo 
* @createDate:  2019/1/20 15:44
* @updateUser:  blucebo
* @updateDate:  2019/1/20 15:44
* @updateRemark:
* @version: 1.0
*/
public class TcpClient {

    public static void main(String[] args) throws IOException {
        System.out.println("socket tcp 客户端启动.....");
        Socket socket = new Socket("127.0.0.1",8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("哈哈".getBytes());
        socket.close();
    }
}
