package com.kang.netty.rpc.provider;

import com.kang.netty.rpc.protocol.protocol.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.kang.netty.rpc.protocol.spring", "com.kang.netty.rpc.provider.service"})
@SpringBootApplication
public class NettyRpcProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyRpcProviderApplication.class, args);

        new NettyServer("127.0.0.1", 8888).startNettyServer();
    }

}
