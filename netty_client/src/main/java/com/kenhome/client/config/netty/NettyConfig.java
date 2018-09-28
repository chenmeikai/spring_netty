package com.kenhome.client.config.netty;

import io.netty.channel.ChannelFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 16:14 2018/9/28 0028
 * @Modified By:
 */
@Configuration
public class NettyConfig {


    @Bean
    public ChannelFuture channelFuture(){
        String url="127.0.0.1";
        int port =9001;
        NettyClient client = new NettyClient(url,port);
        ChannelFuture channelFuture = client.connect(10);
        return  channelFuture;
    }

}
