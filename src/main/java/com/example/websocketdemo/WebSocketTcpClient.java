package com.example.websocketdemo;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class WebSocketTcpClient {
    public static void main(String[] args) throws Exception{



                Socket socket = new Socket();
                SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(),7000);
                socket.connect(socketAddress);
                socket.getOutputStream().write(("abc1234").getBytes());
    }
}
