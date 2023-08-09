package com.example.bio.one;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception{
        System.out.println("====服务端已启动====");
        // 1.定义一个服务端socker
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2.监听客户端的请求
        Socket accept = serverSocket.accept();
        // 3.从socket管道中获取出一个字节输入流对象
        InputStream inputStream = accept.getInputStream();
        // 4.把字节输入流包装成一个缓冲字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String msg;
        while ((msg = bufferedReader.readLine()) != null){
            System.out.println("服务端接收到的数据：" + msg);
        }
    }
}
