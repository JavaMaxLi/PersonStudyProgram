package com.example.websocketdemo.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {

    //选择器
    private Selector selector;
    //监听的通道
    private ServerSocketChannel serverSocketChannel;
    public static final int PORT = 6667;

    public static void main(String[] args) {
        GroupChatServer server = new GroupChatServer();
        server.startup();
    }

    public GroupChatServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startup() {

        try {
            while (true) {
                int count = selector.select();
                //判断是否有事件需要处理
                if (count>0) {
                    //处理事件
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        //监听连接事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress()+"上线");
                        }
                        //读取事件
                        if (key.isReadable()) {
                            readData(key);

                        }
                    }
                    iterator.remove();
                } else {
                    //System.out.println("等待。。。");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData(SelectionKey key) {
        SocketChannel socketChannel = null;
      try{
          socketChannel = (SocketChannel) key.channel();
          ByteBuffer buffer = ByteBuffer.allocate(1024);
          int count = socketChannel.read(buffer);
          if (count>0) {
              String str = new String(buffer.array());
              //输出读到消息
              System.out.println("form Client:"+str);
              //并转发给客户端，不包括当前发送的客户端
              sendMsgToClient(str, socketChannel);
          }
      }catch (IOException e) {
         // e.printStackTrace();
          try {
              System.out.println(socketChannel.getRemoteAddress()+"下线了");
              //取消注册
              key.cancel();
              //关闭通道
              socketChannel.close();
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }
      }
    }

    public void sendMsgToClient(String msg, SocketChannel except) {
       try {
           System.out.println("服务器正在转发消息中。。。");
           for(SelectionKey selectionKey : selector.keys()) {
               Channel channel = selectionKey.channel();
              // SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
               //排除当前客户端
               if (channel instanceof SocketChannel && channel != except) {
               //if (socketChannel != except) {
                   SocketChannel socketChannel = (SocketChannel) channel;
                   ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                   socketChannel.write(byteBuffer);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();

       }
    }
}
