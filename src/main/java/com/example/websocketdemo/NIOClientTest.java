package com.example.websocketdemo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClientTest {

    public static void main(String[] args) {
        new NIOClientTest().client();
    }

    public void client() {
        try {
            //创建一个和服务器端连接的通道
            SocketChannel socketChannel = SocketChannel.open();
            //设置非阻塞
            socketChannel.configureBlocking(false);
            //设置连接服务器的信息
            boolean flag = socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(),6666));
            //连接不成功
            if (!flag) {
                if (!socketChannel.finishConnect()) {
                    System.out.println("连接需要时间，客户端不会阻塞，可以执行其他操作");
                }
            }
            String str = "hello,Nio,这是我第一个例子";
            ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
            socketChannel.write(buffer);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
