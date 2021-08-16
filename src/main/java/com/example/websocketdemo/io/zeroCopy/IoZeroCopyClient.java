package com.example.websocketdemo.io.zeroCopy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IoZeroCopyClient {

    public static void main(String[] args) throws Exception{
        Socket socket  = new Socket("localhost",6668);
        String file = "springclould.rar";
        InputStream inputStream = new FileInputStream(file);
        long start = System.currentTimeMillis();
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int fileSize = 0;
        int read = 0;
        while ((read = inputStream.read(bytes))!= -1) {
            fileSize += read;
            outputStream.write(bytes);
        }
        System.out.println("一共使用时间："+(System.currentTimeMillis()-start)+"，文件大小为："+fileSize);
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
