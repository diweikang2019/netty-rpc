package com.kang.netty.rpc.protocol.serializer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weikang.di
 * @date 2022/5/11 23:32
 */
public class SerializerManager {

    private final static ConcurrentHashMap<Byte, Serializer> serializer = new ConcurrentHashMap<>();

    static {
        Serializer json = new JsonSerializer();
        Serializer java = new JavaSerializer();
        serializer.put(json.getType(), json);
        serializer.put(java.getType(), java);
    }

    public static Serializer getSerializer(byte key) {
        Serializer iSerializer = serializer.get(key);
        if (serializer == null) {
            return new JavaSerializer();
        }
        return iSerializer;
    }
}
