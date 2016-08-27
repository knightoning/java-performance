/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.proxy;

/**
 * DB查询代理
 * 
 * @author hujie
 * @version $Id: DBQueryProxy.java, v 0.1 2016年7月24日 上午11:53:50 hujie Exp $
 */
public class DBQueryProxy implements IDBQuery {

    private DBQuery real = null;
    /** 
     * @see com.java.performance.chapter1.proxy.IDBQuery#request()
     */
    @Override
    public String request() {
        
        //在真正需要时，才创建真实对象，创建过程比较慢
        if(real == null){
            real = new DBQuery();
        }
        
        //在多线程下，返回一个虚假类，类似于Future模式
        return real.request();
    }

}
