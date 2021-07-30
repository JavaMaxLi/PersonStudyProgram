package com.example.websocketdemo;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class WebSocketTcpClient {
    public static void main(String[] args) throws Exception{



            for (int i = 0; i < 10; i++) {
                Socket socket = new Socket();
                SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(),8080);
                socket.connect(socketAddress);
                socket.getOutputStream().write(("客户端第"+i+"个请求").getBytes());
            }
    }
}
