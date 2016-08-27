/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: FutureTest.java, v 0.1 2016年8月27日 下午3:01:49 hujie Exp $
 */
public class FutureTest {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        Client client = new Client();
        //这里会立即返回，因为得到的是FutureData而不是RealData
        Data data = client.request("name");
        System.out.println("请求完成");
        
        try {
            //这里可以用一个sleep 代替对其他业务逻辑的处理
            //在处理这些业务逻辑的过程中，RealData被创建，从而充分利用了等待时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        //使用真实的数据
        System.out.println("数据="+ data.getResult());

    }

}
