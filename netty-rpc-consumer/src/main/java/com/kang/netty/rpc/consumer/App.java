package com.kang.netty.rpc.consumer;

import com.kang.netty.rpc.api.UserService;
import com.kang.netty.rpc.consumer.proxy.RpcClientProxy;

/**
 * @author weikang.di
 * @date 2022/5/12 0:19
 */
public class App {

    public static void main(String[] args) {
        RpcClientProxy rcp = new RpcClientProxy();
        UserService userService = rcp.clientProxy(UserService.class, "127.0.0.1", 8888);
        System.out.println(userService.saveUser("Mic"));
    }
}
