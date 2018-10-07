package com.kenhome.socket.config.netty;

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
public class WebSocketStart implements CommandLineRunner {

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void run(String... args) throws Exception {
        webSocketServer.start();
    }
}
