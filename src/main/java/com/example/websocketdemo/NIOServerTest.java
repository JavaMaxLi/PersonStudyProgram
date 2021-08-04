package com.example.websocketdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServerTest {

    public static void main(String[] args) {
        new NIOServerTest().startup();
    }

    public void startup() {
        ServerSocketChannel serverSocketChannel = null;

        try {
            //获取到一个serverSocketChannel通道
            serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //获取一个selector
            Selector selector = Selector.open();
            //绑定端口号6666
            serverSocketChannel.socket().bind(new InetSocketAddress(6666));
            //把serverSocketChannel注册到selector上
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //循环等待客户端连接
            while (true) {
                //等待1秒，查看是否有事件发生
                if (selector.select(1000) == 0) {
                    System.out.println("服务器等待1秒，无客户端连接");
                }
                //如果大于0，就获取到SelectionKey集合，
                //遍历集合里面的key的时间进行相应的操作
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                //循环SelectionKey集合
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //连接操作
                    if (selectionKey.isAcceptable()) {
                        //等待连接,因为SelectionKey已经获取到了事件集合，如果有连接请求，会马上执行下面操作
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        System.out.println("client 请求连接到server"+socketChannel.hashCode());
                        //将socketChannel设置为非阻塞
                        socketChannel.configureBlocking(false);
                        //连接以后将socketChannel注册到selector上，关注事件为OP_READ，同时关联一个ByteBuffer
                        socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                    //读操作
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        //将socketChannel设置为非阻塞
                        socketChannel.configureBlocking(false);
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        socketChannel.read(buffer);
                        System.out.println("socketChannel。hashCode:"+socketChannel.hashCode()+",客户端读操作："+new String(buffer.array()));
                        //执行完毕以后关闭通道防止重复执行
                        socketChannel.close();
                    }
                    //执行完毕手动移除SelectionKey,防止重复操作
                    iterator.remove();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
