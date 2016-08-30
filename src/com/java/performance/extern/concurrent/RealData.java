/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: RealData.java, v 0.1 2016年8月27日 下午2:37:24 hujie Exp $
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String para) {

        //RealData的构造可能会很慢，需要用户等待很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        try {
            for (int i = 0; i < 10; i++) {
                sb.append(para);
                //这里使用sleep，代替一个很慢的操作过程
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("RealData 异常" + e);
        }

        result = sb.toString();
    }

    /** 
     * @see com.java.performance.extern.concurrent.Data#getResult()
     */
    @Override
    public String getResult() {
        return result;
    }

}
