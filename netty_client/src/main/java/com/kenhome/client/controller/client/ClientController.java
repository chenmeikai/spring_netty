package com.kenhome.client.controller.client;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 16:44 2018/9/28 0028
 * @Modified By:
 */

@RestController
public class ClientController {

    @Autowired
    private ChannelFuture channelFuture;

    @GetMapping("sendMessage")
    public String sendMessage(String message){

        channelFuture.channel().writeAndFlush(message);
        return  "success";

    }
}
