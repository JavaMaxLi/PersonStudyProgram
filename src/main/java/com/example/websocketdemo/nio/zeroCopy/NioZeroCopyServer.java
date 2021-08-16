package com.example.websocketdemo.nio.zeroCopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioZeroCopyServer {

    public static void main(String[] args) throws Exception{

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(6669));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //监听客户端
            SocketChannel socketChannel = serverSocketChannel.accept();
            long startTime = System.currentTimeMillis();
            int size = 0;
            int read = 0;
            while (true) {
                try {
                    read = socketChannel.read(buffer);

                } catch (Exception e) {
                    break;
                }
                if (read == -1) {
                    break;
                }
                size += read;
                buffer.rewind();
            }
            System.out.println("文件大小："+size+"，花费时间："+(System.currentTimeMillis()-startTime));
        }
    }
}
