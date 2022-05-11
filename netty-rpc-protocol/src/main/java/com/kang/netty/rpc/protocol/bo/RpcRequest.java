package com.kang.netty.rpc.protocol.bo;

import java.io.Serializable;

/**
 * @author weikang.di
 * @date 2022/5/11 23:07
 */
public class RpcRequest implements Serializable {

    /**
     * 类名
     */
    private String className;

    /**
     * 请求目标方法
     */
    private String methodName;

    /**
     * 请求参数
     */
    private Object[] params;

    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }
}
