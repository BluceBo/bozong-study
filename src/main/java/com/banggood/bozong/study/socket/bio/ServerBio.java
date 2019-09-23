package com.banggood.bozong.study.socket.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBio {
    public static void main(String[] args) {
        int port = genPort(args);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Handler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            serverSocket = null;
        }
    }

    private static int genPort(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.parseInt(args[0]);
            } catch (Exception ex) {
                return 9999;
            }
        }else {
            return 9999;
        }
    }

    static class Handler implements Runnable {
        Socket socket = null;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                String readMessage = null;
                while (true) {
                    System.out.println("server reading......");
                    if ((readMessage = reader.readLine()) == null) {
                        break;
                    }
                    System.out.println(readMessage);
                    writer.println("server recive : " + readMessage);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                socket = null;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                reader = null;
                if (writer != null) {
                    writer.close();
                }
                writer = null;
            }
        }
    }
}
