package com.example.websocketdemo.webSocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * TextWebSocketFrame表示一个文本帧
 */
public class WebSocketHandlerTest extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    /**
     * 处理消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        System.out.println("服务器收到消息："+msg.text());

        ctx.pipeline().writeAndFlush(new TextWebSocketFrame("服务器时间："+ LocalDateTime.now()+ msg.text()));
    }

    /**
     * 监听客户端连接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用handlerAdded"+ctx.pipeline().channel().id().asLongText());
    }

    /**
     * 断开连接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用handlerRemoved"+ctx.pipeline().channel().id().asLongText());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生异常："+cause.getMessage());
        ctx.close();
    }
}
