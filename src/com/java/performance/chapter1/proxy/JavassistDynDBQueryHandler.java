/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;

/**
 * javassist 生成动态代理，通过使用代理工厂创建
 * 
 * @author hujie
 * @version $Id: JavassistDynDBQueryHandler.java, v 0.1 2016年7月24日 下午3:10:59 hujie Exp $
 */
public class JavassistDynDBQueryHandler implements MethodHandler {

    IDBQuery real = null;
    
    /** 
     * @see javassist.util.proxy.MethodHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
        
        if(real == null){
            real = new DBQuery();
        }
        return real.request();
    }

}
