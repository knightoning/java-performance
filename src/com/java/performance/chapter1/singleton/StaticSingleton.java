/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * 使用内部类来维护单例的实例
 * 1、延迟加载
 * 2、线程安全，不需要使用线程同步关键字，从而提升性能
 * @author hujie
 * @version $Id: StaticSingleton.java, v 0.1 2016年7月17日 上午11:40:02 hujie Exp $
 */
public class StaticSingleton {

    private StaticSingleton(){
        
        System.out.println("StaticSingleton is create");
    }
    
    private static class SingletonHolder{
        
        private static StaticSingleton instance = new StaticSingleton();
        
    }
    
    public static StaticSingleton getInstance(){
        
        return SingletonHolder.instance;
    }
}
