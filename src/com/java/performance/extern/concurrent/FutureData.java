/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: FutureData.java, v 0.1 2016��8��27�� ����2:35:15 hujie Exp $
 */
public class FutureData implements Data {
    
    //FutureData ��RealData�İ�װ
    protected RealData realData = null;
    
    protected boolean isReady = false;

    /** 
     * ��ȴ�RealData�������
     * 
     * @see com.java.performance.extern.concurrent.Data#getResult()
     */
    @Override
    public synchronized  String getResult() {
        while(!isReady){
            //һֱ�ȴ���ֱ��RealData�������
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
        }
        //��RealDataʵ��
        return realData.result;
    }

    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        //RealData �Ѿ���ע�룬֪ͨgetResult()
        notifyAll(); 
    }
}
