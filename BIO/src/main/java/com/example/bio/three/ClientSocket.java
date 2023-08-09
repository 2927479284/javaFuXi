package com.example.bio.three;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            // 1.连接服务端
            Socket socket = new Socket("127.0.0.1", 8888);
            // 2.获取出一个输出流
            OutputStream outputStream = socket.getOutputStream();
            // 3.将这个输出流进行转换，转换成打印流方便传输数据
            PrintStream printStream = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入传输数据：");
                String message = scanner.next();
                printStream.println(message);
                printStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
