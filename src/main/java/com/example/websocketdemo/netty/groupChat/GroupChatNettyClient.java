package com.example.websocketdemo.netty.groupChat;

import com.example.websocketdemo.base.ConstantFrame;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class GroupChatNettyClient implements ConstantFrame {

    public void run() {

        EventLoopGroup workGroup = new NioEventLoopGroup();
        //
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new GroupChatClientInit());

            ChannelFuture future = bootstrap.connect(LOCAL_HOST_NAME,PORT).sync();

            Channel channel = future.channel();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg+"\r\n");
            }

            //监听关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new GroupChatNettyClient().run();
    }

}
