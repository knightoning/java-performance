/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

/**
 * 主题DB查询接口实现类
 * 
 * @author hujie
 * @version $Id: DBQuery.java, v 0.1 2016年7月24日 上午11:46:14 hujie Exp $
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
