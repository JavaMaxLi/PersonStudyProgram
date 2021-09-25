package com.example.websocketdemo.netty.dubbo.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    //上下文
    private ChannelHandlerContext context;
    //参数
    private String param;
    //返回值
    private String result;

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    /**
     * 读取服务器返回的消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }

    /**
     * 客户端先调用call方法发送数据给服务器端然后等待
     * 服务器接收到消息处理返回给channelRead方法
     * channelRead拿到返回值唤醒call返回结果
     * @return
     * @throws Exception
     */
    @Override
    public synchronized Object call() throws Exception {
        context.writeAndFlush(param);
        wait();
        return result;
    }
}
