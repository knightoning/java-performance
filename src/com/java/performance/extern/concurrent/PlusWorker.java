/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: PlusWorker.java, v 0.1 2016年8月24日 下午4:02:41 hujie Exp $
 */
public class PlusWorker extends Worker{
    
    public Object handle(Object input){
        Integer i = (Integer)input;
        return i*i*i;
    }

}
