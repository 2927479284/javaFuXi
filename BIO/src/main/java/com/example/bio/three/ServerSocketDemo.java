package com.example.bio.three;

import java.net.Socket;

/**
 * 实现一个服务端连接多个客户端
 * 一个客户端进来创建一个对应的服务端线程
 */
public class ServerSocketDemo {

    public static void main(String[] args) {
        System.out.println("====服务端已启动====");
        try {
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(8888);
            while (true){
                Socket accept = serverSocket.accept();
                new ServerSocketThreeImpl(accept).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
