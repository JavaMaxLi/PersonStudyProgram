package com.example.websocketdemo.netty.httpServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //加入一个netty提供的httpServerCodec
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        pipeline.addLast("HttpServerHandlerTest",new HttpServerHandlerTest());

    }
}
