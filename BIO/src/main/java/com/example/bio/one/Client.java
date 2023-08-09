package com.example.bio.one;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{
        // 1.客户端连接 服务端
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2.从socket 对象中获取一个 输出流
        OutputStream outputStream = socket.getOutputStream();
        // 3.这里吧字节流包装成一个打印流 方便发送数据
        Scanner scanner = new Scanner(System.in);// 扫描键盘输入
        PrintStream printStream = new PrintStream(outputStream);
        while (true){
            System.out.println("请输入发送文本：");
            String msg = scanner.next();
            printStream.println(msg);
            printStream.flush();
        }

    }
}
