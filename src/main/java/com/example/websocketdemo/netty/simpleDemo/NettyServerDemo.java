package com.example.websocketdemo.netty.simpleDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty入门服务端
 */
public class NettyServerDemo {

    public static void main(String[] args) throws Exception{
        NioEventLoopGroup bossGroup = null;
        NioEventLoopGroup workGroup = null;
        try{
            //创建BossGroup和 WorkGroup
            //bossGroup只处理连接请求，客户端业务处理是由workGroup处理
            //
            bossGroup = new NioEventLoopGroup();
            workGroup = new NioEventLoopGroup();

            //创建服务器端启动对象，设置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置线程组
            bootstrap.group(bossGroup,workGroup)
                    //使用NioServerSocketChannel做为服务器通道实现
                    .channel(NioServerSocketChannel.class)
                    //设置线程队列等待连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //设置保持连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //创建一个通道初始化对象 匿名对象
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //为pipeline管道添加处理器
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }

                    });

            //绑定端口号并同步,并生成一个ChannelFuture对象
            ChannelFuture channelFuture = bootstrap.bind(8888).sync();

            //给ChannelFuture注册监听器
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("监听端口成功8888");
                    }
                }
            });

            //对关闭的通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

}
