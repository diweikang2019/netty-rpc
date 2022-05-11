package com.kang.netty.rpc.protocol.bo;

import java.io.Serializable;

/**
 * @author weikang.di
 * @date 2022/5/11 23:09
 */
public class RpcResponse implements Serializable {

    private int code;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
