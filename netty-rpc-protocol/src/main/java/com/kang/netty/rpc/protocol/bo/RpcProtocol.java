package com.kang.netty.rpc.protocol.bo;

import java.io.Serializable;

/**
 * @author weikang.di
 * @date 2022/5/11 23:05
 */
public class RpcProtocol<T> implements Serializable {

    /**
     * 消息头
     */
    private Header header;

    /**
     * 消息体
     */
    private T body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
