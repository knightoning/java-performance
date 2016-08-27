/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例测试
 * 
 * @author hujie
 * @version $Id: SingletonTest.java, v 0.1 2016年7月16日 下午10:20:31 hujie Exp $
 */
public class SingletonTest {

    private static ExecutorService  executor  = Executors.newFixedThreadPool(5) ;
    
    public static void main(String[] args){
        
        //Singleton.createString();
        //executor.execute(new SingletonThread("SINGLETON"));
        //executor.execute(new SingletonThread("SINGLETON_LAZY"));
        SingletonThread singletonThread = new SingletonThread("SINGLETON_LAZY");
    }
}
