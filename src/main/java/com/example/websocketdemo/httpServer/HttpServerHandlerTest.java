package com.example.websocketdemo.httpServer;

import com.example.websocketdemo.bean.UserBean;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;

public class HttpServerHandlerTest extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {

        //判断是不是httpRequest请求
        if (httpObject instanceof HttpRequest) {
            System.out.println("httpObject类型:"+httpObject.getClass());

            System.out.println("pipeline的hashcode:"+ctx.pipeline().hashCode()+"，handler的hashcode"+this.hashCode());

            UserBean user = new UserBean();
            user.setName("李小锋").setAge(23).setAddress("杭州市钱塘新区");

            user.toString();
            ByteBuf buf = Unpooled.copiedBuffer(user.toString(), CharsetUtil.UTF_8);
            //获取HttpRequest对象
            HttpRequest request = (HttpRequest) httpObject;
            //创建URI统一资源标识符,过滤特定资源
            URI uri = new URI(request.uri());
            if("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求得到页面图标：favicon.ico");
                return;
            }
            //构造一个httpResponse响应
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,buf);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"application/json");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,buf.readableBytes());

            //将构建好的response返回

            ctx.writeAndFlush(response);

        }

    }
}
