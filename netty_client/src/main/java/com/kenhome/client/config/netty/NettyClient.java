package com.kenhome.client.config.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author cmk
 * @date 2018/9/28 - 14:52
 */

@Slf4j
public class NettyClient {

    private Bootstrap bootstrap;
    private EventLoopGroup worker;
    private int port;
    private String url;
    private int MAX_RETRY_TIMES = 10;

    public NettyClient(String url, int port) {
        this.url = url;
        this.port = port;
        bootstrap = new Bootstrap();
        worker = new NioEventLoopGroup();
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
    }

    public void close() {
        log.info("关闭资源");
        worker.shutdownGracefully();
    }

    public ChannelFuture connect(int retry) {
        try {
            ClientInitializer clientInitializer = new ClientInitializer();
            bootstrap.handler(clientInitializer);
            ChannelFuture sync = bootstrap.connect(url, port).sync();
            Channel channel = sync.channel();
            channel.writeAndFlush("发送消息");

            return sync;
        } catch (InterruptedException e) {
            retry++;
            if (retry > MAX_RETRY_TIMES) {
                throw new RuntimeException("连接失败");
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                log.info("第{}次尝试....失败", retry);
                return connect( retry);
            }
        }
    }
}
