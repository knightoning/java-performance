/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理
 * 
 * @author hujie
 * @version $Id: JdkDBQueryHandler.java, v 0.1 2016年7月24日 下午2:50:05 hujie Exp $
 */
public class JdkDBQueryHandler implements InvocationHandler {
    
    IDBQuery real = null;

    /** 
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        if(real == null){
            real = new DBQuery();
        }
        return real.request();
    }

}
