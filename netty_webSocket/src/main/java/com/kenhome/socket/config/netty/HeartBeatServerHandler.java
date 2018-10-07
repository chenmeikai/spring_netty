package com.kenhome.socket.config.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author cmk
 * @Description 心跳监听处理
 * @Date 2018\10\6 0006 20:00
 */
@Component
@Slf4j
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                /*读超时*/
                log.info("===客户端===(READER_IDLE 读超时)");
                log.info("关闭该chanel)");
                ctx.channel().close();
            } else if (event.state() == IdleState.WRITER_IDLE) {
                /*写超时*/
                log.info("===客户端===(WRITER_IDLE 写超时)");
            } else if (event.state() == IdleState.ALL_IDLE) {
                /*总超时*/
                log.info("===客户端===(ALL_IDLE 总超时)");
            }
        }
    }

}
