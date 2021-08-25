package com.example.websocketdemo.netty.groupChat.server;

import com.example.websocketdemo.base.ConstantFrame;
import com.example.websocketdemo.groupchat.GroupChatServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 基于netty的简单群聊系统，服务器监听用户上下线，转发消息给客户端
 * 步骤如下：
 *      1:创建2个线程组分别是BoosGroup（处理client连接，accept监听）和WorkGroup（处理数据网络IO，并返回结果）
 *      2:创建ServerBootStrap设置服务器的配置（2线程组，端口号。队列大小，处理器）
 *      3:ChannelFuture异步监听返回结果
 *
 */
public class GroupChatNettyServer implements ConstantFrame {


    public void run() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //默认大小为cpu核数*2
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new GroupChatInitializer());

            System.out.println("netty服务器启动-------------------------------------");

            ChannelFuture future = bootstrap.bind(PORT).sync();


            //监听关闭
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new GroupChatNettyServer().run();
    }
}
