package com.example.websocketdemo.groupchat;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String name;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            socketChannel = socketChannel.open(new InetSocketAddress(HOST,PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            name = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(name+"客户端准备启动");
        } catch (Exception e) {

        }
    }

    public void sendMsg(String msg) {
        msg = name + "说：" + msg;
        try{
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            socketChannel.write(buffer);
        } catch (IOException e) {

        }
    }

    public void readMsg() {
        try {
            int count = selector.select();
            if (count>0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        System.out.println(new String(buffer.array()));
                    }
                }
                iterator.remove();
            } else {
//                System.out.println("暂无可用通道。。。");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GroupChatClient client = new GroupChatClient();

        //开启一个线程每过3秒从客户端读数据
        new Thread() {
            @Override
            public void run() {
               while (true) {
                   client.readMsg();
                   try {
                       Thread.currentThread().sleep(3000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }.start();

        //发送数据给服务器端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            client.sendMsg(s);
        }
    }
}
