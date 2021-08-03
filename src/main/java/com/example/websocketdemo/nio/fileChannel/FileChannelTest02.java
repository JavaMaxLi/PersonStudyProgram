package com.example.websocketdemo.nio.fileChannel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;

public class FileChannelTest02 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:\\aa.txt");
            FileChannel fileChannel = fileInputStream.getChannel();
            try {
                while (true) {
                    buffer.clear();
                    int read = fileChannel.read(buffer);
                    System.out.println("read=="+read);
                    if (read == -1) {
                        break;
                    }
                    System.out.println(new String(buffer.array()));
                }
            } catch (IOException e) {
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
