package com.example.websocketdemo.nio.fileChannel;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 使用MappedByteBuffer直接对文件在内存中修改(堆外内存)
 */
@Slf4j
public class ByteBufferTest {

    public static void main(String[] args) {
        /*String str = "asdnskfksaljda1222231";
        ByteBuffer buffer = ByteBuffer.allocate(30);
       // for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(str.getBytes());
       // }
        StringBuffer sb = new StringBuffer();
        buffer.flip();
        while (buffer.hasRemaining()) {

            System.out.println(buffer.get());

        }*/

        readOnlyBuffer();
    }

    public static String readOnlyBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        for (int i = 0; i < 7; i++) {
            buffer.putInt(i);
        }
        buffer.flip();
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.getInt());
        }
        return "success";
    }
}
