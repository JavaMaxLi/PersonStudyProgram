package com.example.websocketdemo.nio.fileChannel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest02 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(80);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:\\aa.txt");
            FileChannel fileChannel = fileInputStream.getChannel();
            try {
                fileChannel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                String str = new String(buffer.array());
                System.out.println(str);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
