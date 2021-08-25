package com.example.websocketdemo.netty.httpServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * http服务器
 */
public class HttpServerTest {

    public static void main(String[] args) {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerChannelInitializer());
            //绑定端口号并监听
            ChannelFuture channelFuture = bootstrap.bind(8888).sync();

            //
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isDone()) {
                        System.out.println("准备开始监听端口8888");
                    }
                    if (channelFuture.isSuccess()) {
                        System.out.println("正在监听端口8888");
                    }
                    if (channelFuture.isCancelled()) {
                        System.out.println("正在取消当前操作");
                    }
                }
            });

            //监听channelFuture关闭事件
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
