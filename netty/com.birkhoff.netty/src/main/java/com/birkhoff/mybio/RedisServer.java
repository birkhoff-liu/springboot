package com.birkhoff.lambda;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("XXXX 来连接了");

            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println("收到客户端的消息" + new String(bytes));
        }
    }
}
