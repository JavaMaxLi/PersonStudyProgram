package com.example.websocketdemo.io.zeroCopy;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IoZeroCopyServer {

    public static void main(String[] args) throws Exception{

        //创建一个serversocket服务
        ServerSocket serverSocket = new ServerSocket(6668);
        //循环监听
        while (true) {
            //监听客户端请求
            Socket socket = serverSocket.accept();
            //获取客户端请求的输入流
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int fileSize = 0;
            //循环读取文件
            while (true) {
                int read = inputStream.read(bytes);
                if (read == -1) {
                    break;
                }
                fileSize += read;


            }
            System.out.println("服务器读到的数据大小："+fileSize);
        }

    }
}
