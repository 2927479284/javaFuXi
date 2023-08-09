package com.example.bio.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 实现多线程
 */
public class ServerSocketThreeImpl extends Thread{

    private Socket socket;
    public ServerSocketThreeImpl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 1.从socket中获取出他的字节输入流
            InputStream inputStream = socket.getInputStream();
            // 2.用缓冲字符输入流包装一下字节输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println("当前线程："+Thread.currentThread().getName() + "服务端获取到的内容："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
