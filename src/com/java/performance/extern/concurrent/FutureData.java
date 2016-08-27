/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: FutureData.java, v 0.1 2016年8月27日 下午2:35:15 hujie Exp $
 */
public class FutureData implements Data {
    
    //FutureData 是RealData的包装
    protected RealData realData = null;
    
    protected boolean isReady = false;

    /** 
     * 会等待RealData构造完成
     * 
     * @see com.java.performance.extern.concurrent.Data#getResult()
     */
    @Override
    public synchronized  String getResult() {
        while(!isReady){
            //一直等待，直到RealData构造完成
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
        }
        //由RealData实现
        return realData.result;
    }

    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        //RealData 已经被注入，通知getResult()
        notifyAll(); 
    }
}
