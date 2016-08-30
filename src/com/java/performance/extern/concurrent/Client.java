/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * Client ��Ҫʵ���˻�ȡFutureData����������RealData���̲߳��ڽ��������
 * ���ٷ���FutureData
 * 
 * @author hujie
 * @version $Id: Client.java, v 0.1 2016��8��27�� ����2:31:43 hujie Exp $
 */
public class Client {
    
    public Data request(final String queryStr){
        
        final FutureData future = new FutureData();
        
        new Thread(){
            public void run(){
                //RealData�������
                //�����ڵ������߳��н���
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        //FutureData �ᱻ��������
        return future;
    }

}
