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
 * @version $Id: Proxy.java, v 0.1 2016年7月24日 下午2:53:41 hujie Exp $
 */
public class ProxyFactoryDB {

    /**
     * 使用 jdk 动态代理生成实例
     * 
     * @return
     */
    public static IDBQuery createJdkProxy(){
        
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), 
                             new Class[]{IDBQuery.class}, new JdkDBQueryHandler());
        
        return jdkProxy;
        
    }
    
    /**
     * 使用 cglib 动态代理生成实例
     * 
     * @return
     */
    public static IDBQuery createCglibProxy(){
        
        Enhancer enhancer = new Enhancer();
        
        //指定切入器，定义代理类逻辑
        enhancer.setCallback(new CglibDBQueryInterceptor());
        
        //指定实现的接口
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        
        //生成代理类的实例
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();
        
        return cglibProxy;
    }
    
    /**
     * 
     * 使用 javassist 动态代理生成实例 用代理工厂创建
     * 
     * @return
     * @throws Exception
     */
    public static IDBQuery createJavassistDynProxy() throws Exception{
        
        ProxyFactory proxyFactory = new ProxyFactory();
        
        //指定接口
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
        
        Class proxyClass = proxyFactory.createClass();
        
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        
        ((ProxyObject)javassistProxy).setHandler(new JavassistDynDBQueryHandler());
        
        return javassistProxy;
    }
    
    
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception{
        
        ClassPool mPool = new ClassPool(true);
        
        //定义类名
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "javassistBytecodeProxy");
        
        //需要实现的接口
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        
        //添加构造器
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        
        //添加类的字段信息，使用动态java代码
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + "real;", mCtc));
        
        String dbQueryName = DBQuery.class.getName();
        
        //添加方法，这里使用动态java代码指定内部逻辑
        mCtc.addMethod(CtNewMethod.make("public String request(){if(real==null)real=new}"+dbQueryName+"();return real.request();}", mCtc));
        
        //基于以上信息生成动态类
        Class pc = mCtc.toClass();
        
        //生成动态类的实例
        IDBQuery byteCodeProxy = (IDBQuery) pc.newInstance();
        
        return byteCodeProxy;
    }
    
}
