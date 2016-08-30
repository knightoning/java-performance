/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

import java.lang.reflect.Proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;

/**
 * 
 * @author hujie
 * @version $Id: Proxy.java, v 0.1 2016��7��24�� ����2:53:41 hujie Exp $
 */
public class ProxyFactoryDB {

    /**
     * ʹ�� jdk ��̬��������ʵ��
     * 
     * @return
     */
    public static IDBQuery createJdkProxy(){
        
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), 
                             new Class[]{IDBQuery.class}, new JdkDBQueryHandler());
        
        return jdkProxy;
        
    }
    
    /**
     * ʹ�� cglib ��̬��������ʵ��
     * 
     * @return
     */
    public static IDBQuery createCglibProxy(){
        
        Enhancer enhancer = new Enhancer();
        
        //ָ��������������������߼�
        enhancer.setCallback(new CglibDBQueryInterceptor());
        
        //ָ��ʵ�ֵĽӿ�
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        
        //���ɴ������ʵ��
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();
        
        return cglibProxy;
    }
    
    /**
     * 
     * ʹ�� javassist ��̬��������ʵ�� �ô���������
     * 
     * @return
     * @throws Exception
     */
    public static IDBQuery createJavassistDynProxy() throws Exception{
        
        ProxyFactory proxyFactory = new ProxyFactory();
        
        //ָ���ӿ�
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
        
        Class proxyClass = proxyFactory.createClass();
        
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        
        ((ProxyObject)javassistProxy).setHandler(new JavassistDynDBQueryHandler());
        
        return javassistProxy;
    }
    
    
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception{
        
        ClassPool mPool = new ClassPool(true);
        
        //��������
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "javassistBytecodeProxy");
        
        //��Ҫʵ�ֵĽӿ�
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        
        //��ӹ�����
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        
        //�������ֶ���Ϣ��ʹ�ö�̬java����
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + "real;", mCtc));
        
        String dbQueryName = DBQuery.class.getName();
        
        //��ӷ���������ʹ�ö�̬java����ָ���ڲ��߼�
        mCtc.addMethod(CtNewMethod.make("public String request(){if(real==null)real=new}"+dbQueryName+"();return real.request();}", mCtc));
        
        //����������Ϣ���ɶ�̬��
        Class pc = mCtc.toClass();
        
        //���ɶ�̬���ʵ��
        IDBQuery byteCodeProxy = (IDBQuery) pc.newInstance();
        
        return byteCodeProxy;
    }
    
}
