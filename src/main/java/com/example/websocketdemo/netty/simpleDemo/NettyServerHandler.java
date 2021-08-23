package com.example.websocketdemo.netty.simpleDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * 继承ChannelInboundHandlerAdapter成为真正的handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter{

    /**
     * 读取客户端发送的消息数据
     * @param ctx 上下文对象 包含管道pipeline ，通道channel，客户端地址
     * @param msg 用户发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //把任务添加到taskQueue队列，防止阻塞
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ByteBuf buf = (ByteBuf) msg;
                System.out.println("客户端"+ctx.channel().remoteAddress()+"发送的数据："+buf.toString(CharsetUtil.UTF_8)+"，第一个任务");
            }
        });

        //定时任务
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二个任务");
            }
        },5, TimeUnit.SECONDS);



    }

    /**
     * 读取完毕以后回复消息
     * @param ctx 上下文对象
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //将数据写入到缓存并刷新 write + flush
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端",CharsetUtil.UTF_8));
        System.out.println("服务器读取消息完毕！");
    }

    /**
     * 异常处理
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭上下文
        ctx.close();
    }
}
