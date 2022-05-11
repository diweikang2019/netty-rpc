package com.kang.netty.rpc.protocol.handler;

import com.kang.netty.rpc.protocol.bo.Header;
import com.kang.netty.rpc.protocol.bo.RpcProtocol;
import com.kang.netty.rpc.protocol.bo.RpcRequest;
import com.kang.netty.rpc.protocol.bo.RpcResponse;
import com.kang.netty.rpc.protocol.constants.ReqType;
import com.kang.netty.rpc.protocol.spring.SpringBeanManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author weikang.di
 * @date 2022/5/11 23:49
 */
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcRequest>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcRequest> msg) throws Exception {
        System.out.println("Invoke Rpc Client Request");
        RpcProtocol<RpcResponse> resProtocol = new RpcProtocol();
        Header header = msg.getHeader();
        header.setReqType(ReqType.RESPONSE.code());
        Object result = invoke(msg.getBody());

        RpcResponse response = new RpcResponse();
        response.setCode(000000);
        response.setMessage("success");
        response.setData(result);

        resProtocol.setHeader(header);
        resProtocol.setBody(response);

        ctx.writeAndFlush(resProtocol);
    }

    private Object invoke(RpcRequest request) {
        try {
            Class<?> clazz = Class.forName(request.getClassName());
            Object bean = SpringBeanManager.getBean(clazz);
            Method method = clazz.getDeclaredMethod(request.getMethodName(), request.getParameterTypes());
            return method.invoke(bean, request.getParams());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
