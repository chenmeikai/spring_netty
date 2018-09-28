package com.kenhome.client.config.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 自定义处理器
 *
 * @author cmk
 * @date 2018/9/27 - 上午21:40
 */
//@Component
//@Sharable
@Slf4j
public class ClientHandler extends SimpleChannelInboundHandler {


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client say : " + msg.toString());
        //返回客户端消息 - 我已经接收到了你的消息
        ctx.writeAndFlush("接收到消息: " + msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RemoteAddress : " + ctx.channel().remoteAddress() + " active !");
        ctx.writeAndFlush("连接成功！");
        super.channelActive(ctx);
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端关闭");
        super.channelInactive(ctx);
    }
}
