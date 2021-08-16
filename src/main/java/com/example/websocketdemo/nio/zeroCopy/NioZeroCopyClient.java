package com.example.websocketdemo.nio.zeroCopy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NioZeroCopyClient {

    public static void main(String[] args)  throws Exception{

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(6669));

        FileInputStream inputStream = new FileInputStream("springclould.rar");
        FileChannel fileChannel = inputStream.getChannel();

        System.out.println("文件传输大小:"+fileChannel.size());
        long startTime = System.currentTimeMillis();
        long count = fileChannel.transferTo(0,fileChannel.size(),socketChannel);

        System.out.println("发送总字节数："+count+",花费时间："+(System.currentTimeMillis()-startTime));
        fileChannel.close();
    }
}
