package com.kang.netty.rpc.consumer.proxy;

import java.lang.reflect.Proxy;

/**
 * @author weikang.di
 * @date 2022/5/12 0:18
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls, final String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls}, new RpcInvokerProxy(host, port));
    }
}
