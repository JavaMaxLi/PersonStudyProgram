package com.example.websocketdemo.nio.fileChannel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {


    public static void main(String[] args) {
        String str = "重复写入写入到a.txt文件中12312312";
        FileOutputStream out = null;
        ByteBuffer byffer = ByteBuffer.allocate(1024);
        try {
            out = new FileOutputStream("E:\\aa.txt");
            FileChannel fileChannel = out.getChannel();
            byffer.put(str.getBytes());
            byffer.flip();
            try {
                fileChannel.write(byffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
