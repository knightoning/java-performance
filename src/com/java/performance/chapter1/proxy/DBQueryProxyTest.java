/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

/**
 * DB��ѯ�������
 * 
 * @author hujie
 * @version $Id: DBQueryTest.java, v 0.1 2016��7��24�� ����12:01:12 hujie Exp $
 */
public class DBQueryProxyTest {
    
    public static final int CIRCLE = 30000000;
    
    public static void main(String[] args) throws Exception{
        
        //ʹ�ô���
        //IDBQuery q = new DBQueryProxy();
       // q.request();
        
        IDBQuery d = null;
        long begin = System.currentTimeMillis();
        //���� JDK��̬����
        d=ProxyFactoryDB.createJdkProxy();
        System.out.println("createJdkProxy:"+(System.currentTimeMillis() - begin));
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        } 
        System.out.println("callJdkProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("JdkProxy ����-----------------------------");
        
        begin=System.currentTimeMillis();
        //���� CGLIB��̬����
        d=ProxyFactoryDB.createCglibProxy();
        System.out.println("createCglibProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("CglibProxy class:"+ d.getClass().getName());
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callCglibProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("CglibProxy ����-----------------------------");
        
        begin=System.currentTimeMillis();
        //���� Javassist��̬����
        d=ProxyFactoryDB.createJavassistDynProxy();
        System.out.println("createJavassistDynProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("JavassistDynProxy class:"+ d.getClass().getName());
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callJavassistDynProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("JavassistDynProxy ����-----------------------------");
        
        begin=System.currentTimeMillis();
        //���� Javassist��̬����
        d=ProxyFactoryDB.createJavassistBytecodeDynamicProxy();
        System.out.println("createJavassistBytecodeDynamicProxy:"+(System.currentTimeMillis()-begin));
        System.out.println("JavassistBytecodeDynamicProxy class:"+ d.getClass().getName());
        begin=System.currentTimeMillis();
        for(int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callJavassistBytecodeDynamicProxy:"+(System.currentTimeMillis() - begin));
        System.out.println("JavassistBytecodeDynamicProxy ����-----------------------------");
        
    }
}
