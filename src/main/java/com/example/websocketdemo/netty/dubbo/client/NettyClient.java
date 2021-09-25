package com.example.websocketdemo.netty.dubbo.client;

import com.example.websocketdemo.netty.dubbo.service.HelloService;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NettyClient {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,8,2000, TimeUnit.SECONDS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy());

    private static NettyClientHandler clientHandler;

    /**
     * 反射创建服务类进行服务，使用线程池提交任务获取返回值
     * @param serviceClass
     * @return
     */
    public Object getBean(final Class<?> serviceClass) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class<?>[]{serviceClass},(proxy, method, args) -> {
            if (clientHandler == null) {
                initClient();
            }
            clientHandler.setParam(args[0].toString());
            return threadPoolExecutor.submit(clientHandler).get();
        });
    }

    public static void initClient(){

        clientHandler = new NettyClientHandler();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try{

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(clientHandler);
                        }
                    });
            bootstrap.connect("127.0.0.1",6000).sync();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
          //  workGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient();
        HelloService helloService = (HelloService) client.getBean(HelloService.class);
        String result = helloService.hello("你好，Dubbo");
        System.out.println("调用的结果"+result);
    }
}
