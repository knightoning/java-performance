/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * 单例
 * 缺点：无法对instance 实例做延迟加载，单例创建过程比较慢
 * 
 * @author hujie
 * @version $Id: Singleton.java, v 0.1 2016年7月16日 下午9:40:10 hujie Exp $
 */
public class Singleton {

    /**
     * 单例构造器
     */
    private Singleton(){
        System.out.println("Singleton is create");
    }
    
    /**
     * 静态实例化静态对象
     */
    private static Singleton instance = new Singleton();
    
    /**
     * 获取单例对象
     * 
     * @return 单例对象
     */
    public static Singleton getInstance(){
        return instance;
    }
    
    /**
     * 创建单例对象方法
     */
    public  static void createString(){
        
        System.out.println("createString in Singleton");
    }
    
}
