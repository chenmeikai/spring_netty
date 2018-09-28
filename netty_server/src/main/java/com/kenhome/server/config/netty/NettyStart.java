package com.kenhome.server.config.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 14:28 2018/9/28 0028
 * @Modified By:
 */
@Component
public class NettyStart implements CommandLineRunner {

    @Autowired
    private NettyServerListener nettyServerListener;

    @Override
    public void run(String... args) throws Exception {
        nettyServerListener.start();
    }
}
