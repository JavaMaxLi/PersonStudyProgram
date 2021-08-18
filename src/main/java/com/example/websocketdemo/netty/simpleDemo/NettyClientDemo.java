package com.example.websocketdemo.netty.simpleDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClientDemo {

    public static void main(String[] args) throws Exception{

        //创建客户端NioEventLoopGroup事件循环组
        NioEventLoopGroup work = null;
        try{
            work = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            //设置线程组，客户端通道，处理器
            bootstrap.group(work)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            //客户端连接服务器
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
        }

    }
}
