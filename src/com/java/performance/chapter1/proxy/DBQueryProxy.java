/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

/**
 * DB��ѯ����
 * 
 * @author hujie
 * @version $Id: DBQueryProxy.java, v 0.1 2016��7��24�� ����11:53:50 hujie Exp $
 */
public class DBQueryProxy implements IDBQuery {

    private DBQuery real = null;
    /** 
     * @see com.java.performance.chapter1.proxy.IDBQuery#request()
     */
    @Override
    public String request() {
        
        //��������Ҫʱ���Ŵ�����ʵ���󣬴������̱Ƚ���
        if(real == null){
            real = new DBQuery();
        }
        
        //�ڶ��߳��£�����һ������࣬������Futureģʽ
        return real.request();
    }

}
