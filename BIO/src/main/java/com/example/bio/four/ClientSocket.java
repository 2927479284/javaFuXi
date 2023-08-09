package com.example.bio.four;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入数据：");
                String msg = scanner.next();
                printStream.println(msg);
                printStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
