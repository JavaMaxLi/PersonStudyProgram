package com.example.websocketdemo.nio.fileChannel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * ByteBuffer聚合和分散
 */
public class ScatteringAndGathering {
    public static void main(String[] args) {
        new ScatteringAndGathering().test1();
    }

    public String test1() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
            serverSocketChannel.socket().bind(inetSocketAddress);
            ByteBuffer[] byteBuffers = new ByteBuffer[2];
            byteBuffers[0] = ByteBuffer.allocate(10);
            byteBuffers[1] = ByteBuffer.allocate(5);
            SocketChannel socketChannel = serverSocketChannel.accept();
            int messageLength = 15;
            while (true) {
                long readLength = 0;
                while (readLength < messageLength) {
                    long len =  socketChannel.read(byteBuffers);
                    readLength += len;
                    System.out.println("读到字节readLength："+readLength);

                    Arrays.asList(byteBuffers).stream().map(
                            buffer -> "pos="+buffer.position()+",limit="+buffer.limit()).forEach(System.out::println);
                }
                Arrays.asList(byteBuffers).forEach(byteBuffer -> {
                    byteBuffer.flip();
                });

                long writeLength = 0;
                while(writeLength < messageLength) {
                    long write = socketChannel.write(byteBuffers);
                    writeLength += write;
                    System.out.println("写入控制台显示writeLength："+writeLength);

                }
                Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());
            }

        } catch (Exception e) {

        } finally {

        }

        return "success";
    }
}
