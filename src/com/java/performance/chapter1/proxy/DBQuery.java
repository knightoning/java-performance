/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

/**
 * ����DB��ѯ�ӿ�ʵ����
 * 
 * @author hujie
 * @version $Id: DBQuery.java, v 0.1 2016��7��24�� ����11:46:14 hujie Exp $
 */

public class DBQuery implements IDBQuery {

    public DBQuery(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
    }
    
    /** 
     * @see com.java.performance.chapter1.proxy.IDBQuery#request()
     */
    @Override
    public String request() {
        return null;
    }

}
