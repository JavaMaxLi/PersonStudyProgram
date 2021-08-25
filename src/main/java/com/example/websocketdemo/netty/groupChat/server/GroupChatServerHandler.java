package com.example.websocketdemo.netty.groupChat.server;

import com.sun.org.apache.xpath.internal.operations.String;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.HttpObject;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理器
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<Object>{

    //构建一个全局的ChannelGroup用来管理,单例
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 当client连接的时候首先会出发handlerAdded方法,把当前的channel添加到channelGroup里，并通知所有连接的channel当前客户端已经上线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        //遍历所有channelGroup里面的channel并发送消息
        channelGroup.writeAndFlush(sdf.format(new Date())+"-[客户端]：" + ctx.channel().remoteAddress() + " 上线,加入聊天\n");
    }

    /**
     * 断开连接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        //遍历所有channelGroup里面的channel并发送消息
        channelGroup.writeAndFlush(sdf.format(new Date())+"-[客户端]：" + ctx.channel().remoteAddress() + " 离线\n");
    }

    /**
     * 表示channel处于活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[客户端}："+ctx.channel().remoteAddress() +" 上线\n");
    }

    /**
     * channel处于非活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[客户端}："+ctx.channel().remoteAddress() +" 离线\n");
    }

    /**
     * 发送消息 区别别的用户和自己
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush("[客户]:"+channel.remoteAddress()+msg+"\n");
            } else {
                ch.writeAndFlush("[自己]:"+channel.remoteAddress()+msg+"\n");
            }
        });
    }

    /**
     * 发生异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

