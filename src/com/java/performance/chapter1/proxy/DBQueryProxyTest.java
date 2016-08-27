/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

/**
 * DB查询代理测试
 * 
 * @author hujie
 * @version $Id: DBQueryTest.java, v 0.1 2016年7月24日 下午12:01:12 hujie Exp $
 */
public class DBQueryProxyTest {
    
    public static final int CIRCLE = 30000000;
    
    public static void main(String[] args) throws Exception{
        
        //使用代理
        //IDBQuery q = new DBQueryProxy();
       // q.request();
        
        IDBQuery d = null;
        long begin = System.currentTimeMillis();
        //测试 JDK动态代理
        d=ProxyFactoryDB.createJdkProxy();
        System.out.println("createJdkProxy:"+(System.currentTimeMillis() - begin));
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        } 
        System.out.println("callJdkProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("JdkProxy 结束-----------------------------");
        
        begin=System.currentTimeMillis();
        //测试 CGLIB动态代理
        d=ProxyFactoryDB.createCglibProxy();
        System.out.println("createCglibProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("CglibProxy class:"+ d.getClass().getName());
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callCglibProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("CglibProxy 结束-----------------------------");
        
        begin=System.currentTimeMillis();
        //测试 Javassist动态代理
        d=ProxyFactoryDB.createJavassistDynProxy();
        System.out.println("createJavassistDynProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("JavassistDynProxy class:"+ d.getClass().getName());
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callJavassistDynProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("JavassistDynProxy 结束-----------------------------");
        
        begin=System.currentTimeMillis();
        //测试 Javassist动态代理
        d=ProxyFactoryDB.createJavassistBytecodeDynamicProxy();
        System.out.println("createJavassistBytecodeDynamicProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("JavassistBytecodeDynamicProxy class:"+ d.getClass().getName());
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callJavassistBytecodeDynamicProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("JavassistBytecodeDynamicProxy 结束-----------------------------");
        
    }
}
