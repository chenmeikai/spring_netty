package com.kenhome.client.config.netty;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 14:28 2018/9/28 0028
 * @Modified By:
 */
//@Component
public class NettyStart implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        String url="127.0.0.1";
        int port =9001;
        NettyClient client = new NettyClient(url,port);
        ChannelFuture channelFuture = client.connect(10);
    }
}
