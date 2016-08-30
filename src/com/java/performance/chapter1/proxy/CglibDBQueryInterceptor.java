/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib��̬�������ɶ���
 * 
 * @author hujie
 * @version $Id: CglibDBQueryInterceptor.java, v 0.1 2016��7��24�� ����3:00:00 hujie Exp $
 */
public class CglibDBQueryInterceptor  implements MethodInterceptor{

    IDBQuery real = null;
    
    /** 
     * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
     */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2,
                            MethodProxy arg3) throws Throwable {
        
        if(real == null){
            real =new DBQuery();
        }
        
        return real.request();
    }

}
