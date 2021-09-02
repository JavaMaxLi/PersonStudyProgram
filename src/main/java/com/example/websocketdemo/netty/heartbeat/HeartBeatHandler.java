package com.example.websocketdemo.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;

            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    System.out.println("服务器3秒内没有读操作，读空闲");
                    break;
                case WRITER_IDLE:
                    System.out.println("服务器5秒内没有写操作，写空闲");
                    break;
                case ALL_IDLE:
                    System.out.println("服务器7秒内没有读和写操作，空闲");
                    break;
            }
        }
    }
}
