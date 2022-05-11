package com.kang.netty.rpc.protocol.bo;

import io.netty.util.concurrent.Promise;

/**
 * @author weikang.di
 * @date 2022/5/11 23:57
 */
public class RpcFuture<T> {

    private Promise<T> promise;

    public RpcFuture(Promise<T> promise) {
        this.promise = promise;
    }

    public Promise<T> getPromise() {
        return promise;
    }

    public void setPromise(Promise<T> promise) {
        this.promise = promise;
    }
}
