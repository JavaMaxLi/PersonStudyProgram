package com.example.websocketdemo.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.*;

public class WebSocketTcpServer {
    public static void main(String[] args) throws Exception{
        byte[] bytes = new byte[10];
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(200);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(6666));
        ThreadPoolExecutor thread = new ThreadPoolExecutor(5,8,60, TimeUnit.SECONDS,linkedBlockingQueue);
        while(true) {
            System.out.println("客户端正在等待请求");
            Socket socket = serverSocket.accept();

            thread.execute(()->{
                try {
                    while(true) {
                        System.out.println("正在等待read。。。。。。。");
                        int read = socket.getInputStream().read(bytes);
                        if (read == -1) {
                            break;
                        }
                        String result = new String(bytes,"UTF-8");
                        System.out.println((Thread.currentThread().getName()+"服务器获取到的数据：")+result);
                        Thread.sleep(10);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
