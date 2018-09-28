package com.kenhome.client.config.netty;

import com.kenhome.server.utils.ObjectCodec;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 10:06 2018/9/28 0028
 * @Modified By:
 */

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private ClientHandler clientHandler;

    private Integer maxFrameLength=65535;


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(maxFrameLength
                , 0, 2, 0, 2));
        pipeline.addLast(new LengthFieldPrepender(2));
        pipeline.addLast(new ObjectCodec());
        //自定义处理器，用于处理连接和接收消息
        pipeline.addLast(clientHandler);
    }


}
