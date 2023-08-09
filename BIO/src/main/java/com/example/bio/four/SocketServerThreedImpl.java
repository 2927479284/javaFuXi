package com.example.bio.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketServerThreedImpl extends Thread{

    private Socket socket;

    public SocketServerThreedImpl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 1.socket 获取出输入流
        try {
            InputStream inputStream = socket.getInputStream();
            // 2.进行转换
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // 3.读取内容
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println("当前线程："+Thread.currentThread().getName() + " 服务端获取到的内容："+msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
