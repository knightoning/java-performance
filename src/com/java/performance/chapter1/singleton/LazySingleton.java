/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * 单例（延迟加载机制）
 * 1、对于静态成员变量instance 初始值赋予null,确保系统启动时没有额外的负载
 * 2、在getInstance()工厂方法中，判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
 * 3、getInstance()方法必须是同步，否则在多线程环境下，可能导致多个实例被创建
 * @author hujie
 * @version $Id: LazySingleton.java, v 0.1 2016年7月16日 下午10:35:09 hujie Exp $
 */
public class LazySingleton {

    private LazySingleton(){
        System.out.println("LazySingleton is create...");
    }
    
    private static LazySingleton instance = null;
    
    public static synchronized LazySingleton getInstance(){
        
        if(instance == null){
            instance = new LazySingleton();
        }
        
        return instance;
    }
}
