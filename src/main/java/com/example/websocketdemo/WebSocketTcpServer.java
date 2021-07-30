package com.example.websocketdemo;

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
        byte[] bytes = new byte[1024];
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(200);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));
        ThreadPoolExecutor thread = new ThreadPoolExecutor(5,8,60, TimeUnit.SECONDS,linkedBlockingQueue);
        while(true) {
            System.out.println("客户端正在等待请求");
            System.out.println("等待队列数目已经超过："+linkedBlockingQueue.size());
            Socket socket = serverSocket.accept();

            thread.execute(()->{
                try {
                    socket.getInputStream().read(bytes);
                    String result = new String(bytes);
                    System.out.println((Thread.currentThread().getName()+"服务器获取到的数据：")+result);
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
