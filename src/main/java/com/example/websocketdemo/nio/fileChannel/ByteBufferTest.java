package com.example.websocketdemo.nio.fileChannel;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@Slf4j
public class ByteBufferTest {

    public static void main(String[] args) {
        String str = "asdnskfksaljda1222231";
        ByteBuffer buffer = ByteBuffer.allocate(30);
       // for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(str.getBytes());
       // }
        StringBuffer sb = new StringBuffer();
        buffer.flip();
        while (buffer.hasRemaining()) {

            System.out.println(buffer.get());

        }

    }
}
