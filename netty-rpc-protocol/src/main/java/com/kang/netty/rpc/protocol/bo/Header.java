package com.kang.netty.rpc.protocol.bo;

import java.io.Serializable;

/**
 * @author weikang.di
 * @date 2022/5/11 23:02
 */
public class Header implements Serializable {

    /**
     * 魔数 2字节
     */
    private short magic;

    /**
     * 序列化方式  1个字节
     */
    private byte serialType;

    /**
     * 消息类型  1个字节
     */
    private byte reqType;

    /**
     * 请求id  8个字节
     */
    private long requestId;

    public Header(short magic, byte serialType, byte reqType, long requestId, int length) {
        this.magic = magic;
        this.serialType = serialType;
        this.reqType = reqType;
        this.requestId = requestId;
        this.length = length;
    }

    public short getMagic() {
        return magic;
    }

    public void setMagic(short magic) {
        this.magic = magic;
    }

    public byte getSerialType() {
        return serialType;
    }

    public void setSerialType(byte serialType) {
        this.serialType = serialType;
    }

    public byte getReqType() {
        return reqType;
    }

    public void setReqType(byte reqType) {
        this.reqType = reqType;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 消息体长度，4个字节
     */
    private int length;
}
