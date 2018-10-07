package com.kenhome.socket.config.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 10:06 2018/9/28 0028
 * @Modified By:
 */

@Component
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Resource
    private TextWebSocketFrameHandler textWebSocketFrameHandler;

    @Resource
    HeartBeatServerHandler heartBeatServerHandler;

    @Value("${netty.max_frame_length}")
    private Integer maxFrameLength;


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //websocket协议本身是基于http协议的，所以这边也要使用http解编码器
        pipeline.addLast(new HttpServerCodec());

        //心跳监听
        pipeline.addLast(new IdleStateHandler(10L,0L,0L,TimeUnit.SECONDS));
        pipeline.addLast(heartBeatServerHandler);

        //以块的方式来写的处理器
        pipeline.addLast(new ChunkedWriteHandler());
        //netty是基于分段请求的，HttpObjectAggregator的作用是将请求分段再聚合,参数是聚合字节的最大长度
        pipeline.addLast(new HttpObjectAggregator(8192));

        //参数指的是contex_path
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //自定义
        pipeline.addLast(textWebSocketFrameHandler);

    }


}
