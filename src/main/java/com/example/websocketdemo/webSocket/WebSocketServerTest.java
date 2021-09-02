package com.example.websocketdemo.webSocket;

import com.example.websocketdemo.netty.heartbeat.HeartBeatHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class WebSocketServerTest {

    public static void main(String[] args) throws Exception{

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();

                        //基于http协议，使用http编解码器
                        pipeline.addLast(new HttpServerCodec());
                        //以块的方式写，添加ChunkedWriteHandler处理器
                        pipeline.addLast(new ChunkedWriteHandler());
                        //http数据在传输过程中是分段的，
                        //可以使用HttpObjectAggregator聚合多个块
                        //大量数据请求会被分成多个http请求
                        pipeline.addLast(new HttpObjectAggregator(8192));

                        //webSocket的数据是以帧的形式传递，
                        //浏览器请求时 ws://localhost:8888/hello 请求的uri
                        //WebSocketServerProtocolHandler将http协议升级成为ws协议，保持长连接
                        pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                        pipeline.addLast(new WebSocketHandlerTest());
                    }
                });

        //绑定端口号并同步,并生成一个ChannelFuture对象
        ChannelFuture channelFuture = server.bind(8888).sync();


        //对关闭的通道进行监听
        channelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();

    }
}
