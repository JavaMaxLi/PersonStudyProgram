package com.example.websocketdemo.nio.fileChannel;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception{

        RandomAccessFile randomAccessFile = new RandomAccessFile("E://aa.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        MappedByteBuffer map =  fileChannel.map(FileChannel.MapMode.READ_WRITE,0,11);
        map.put(1,(byte)'E');
        map.put(6,(byte)'w');
        map.put(7,(byte)'o');
        map.put(8,(byte)'r');
        map.put(9,(byte)'l');
        map.put(10,(byte)'d');
        randomAccessFile.close();
        System.out.println("修改成功");
    }
}
