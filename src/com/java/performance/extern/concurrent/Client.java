/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * Client 主要实现了获取FutureData，开启构造RealData的线程并在接受请求后
 * 快速返回FutureData
 * 
 * @author hujie
 * @version $Id: Client.java, v 0.1 2016年8月27日 下午2:31:43 hujie Exp $
 */
public class Client {
    
    public Data request(final String queryStr){
        
        final FutureData future = new FutureData();
        
        new Thread(){
            public void run(){
                //RealData构造很慢
                //所以在单独的线程中进行
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        //FutureData 会被立即返回
        return future;
    }

}
