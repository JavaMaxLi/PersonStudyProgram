package com.example.websocketdemo.netty.simpleDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty入门服务端
 */
public class NettyServerDemo {

    public static void main(String[] args) {
        //创建BossGroup和 WorkGroup
        //bossGroup只处理连接请求，客户端业务处理是由workGroup处理
        //
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        //创建服务器端启动对象，设置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
    /*    bootstrap.group(bossGroup,workGroup)//设置线程组
                .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel做为服务器通道实现
                .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列等待连接个数
                .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持连接状态
                .childHandler(new)//创建一个通道初始化对象 匿名对象*/

    }

}
