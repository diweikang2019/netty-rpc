package com.kang.netty.rpc.protocol.protocol;

import com.kang.netty.rpc.protocol.bo.RpcProtocol;
import com.kang.netty.rpc.protocol.bo.RpcRequest;
import com.kang.netty.rpc.protocol.handler.RpcClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author weikang.di
 * @date 2022/5/12 0:04
 */
public class NettyClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClient.class);

    private final Bootstrap bootstrap;
    private final EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    private String serviceAddress;
    private int servicePort;

    public NettyClient(String serviceAddress, int servicePort) {
        LOGGER.info("Begin Init Netty Client, {}, {}", serviceAddress, servicePort);
        bootstrap = new Bootstrap();

        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new RpcClientInitializer());

        this.serviceAddress = serviceAddress;
        this.servicePort = servicePort;
    }

    public void sendRequest(RpcProtocol<RpcRequest> protocol) throws InterruptedException {
        final ChannelFuture future = bootstrap.connect(this.serviceAddress, this.servicePort).sync();
        future.addListener(listener -> {
            if (future.isSuccess()) {
                LOGGER.info("connect rpc server {} success.", this.serviceAddress);
            } else {
                LOGGER.info("connect rpc server {} failed.", this.serviceAddress);
                future.cause().printStackTrace();
                eventLoopGroup.shutdownGracefully();
            }
        });
        LOGGER.info("begin transfer data");
        future.channel().writeAndFlush(protocol);
    }
}
