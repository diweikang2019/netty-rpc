package com.kang.netty.rpc.protocol.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author weikang.di
 * @date 2022/5/11 23:52
 */
@Component
public class SpringBeanManager implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanManager.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clzz) {
        return applicationContext.getBean(clzz);
    }
}
