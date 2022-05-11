package com.kang.netty.rpc.protocol.protocol;

import com.kang.netty.rpc.protocol.handler.RpcServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author weikang.di
 * @date 2022/5/12 0:02
 */
public class NettyServer {

    private String serverAddress;
    private int serverPort;

    public NettyServer(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void startNettyServer() {
        System.out.println("Begin Start Netty Server");
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new RpcServerInitializer());
        try {
            ChannelFuture future = bootstrap.bind(this.serverAddress, this.serverPort).sync();
            System.out.println("Server Started Success On Port " + this.serverPort);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
