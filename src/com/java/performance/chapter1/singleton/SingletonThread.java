/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

import org.apache.commons.lang3.StringUtils;

/**
 * 多线程测试
 * 
 * @author hujie
 * @version $Id: SingletonThread.java, v 0.1 2016年7月16日 下午10:53:20 hujie Exp $
 */
public class SingletonThread implements Runnable{

    private String singletonName;
    
    public SingletonThread(String singletonName){
        this.singletonName = singletonName;
    }
    
    @Override
    public void run() {
        
        long startTime = System.currentTimeMillis();
        
        for(int i=0; i < 100000; i++){
            
            //非懒加载创建单例
            if(StringUtils.equals(singletonName, SingletonTypeEnum.SINGLETON.getCode())){
                Singleton.getInstance();
            }
           
            //懒加载创建单例
            if(StringUtils.equals(singletonName, SingletonTypeEnum.SINGLETON_LAZY.getCode())){
                LazySingleton.getInstance();
            }
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println(Thread.currentThread().getName() +"spend:" + (endTime - startTime));

    }

}
