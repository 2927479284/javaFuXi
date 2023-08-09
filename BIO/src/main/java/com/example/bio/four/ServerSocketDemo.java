package com.example.bio.four;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步IO通信服务端开发
 */
public class ServerSocketDemo {

    public static void main(String[] args) {
        try {
            // 1.创建服务端
            ServerSocket serverSocket = new ServerSocket(8888);
            HandlerSocketServerPoll handlerSocketServerPoll = new HandlerSocketServerPoll(6, 10);
            while (true){
                Socket accept = serverSocket.accept();
                SocketServerThreedImpl socketServerThreed = new SocketServerThreedImpl(accept);
                handlerSocketServerPoll.executor(socketServerThreed);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
