package com.example.websocketdemo.nio.fileChannel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest03 {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        FileChannel outFileChannel = fileOutputStream.getChannel();
        outFileChannel.write(byteBuffer);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
