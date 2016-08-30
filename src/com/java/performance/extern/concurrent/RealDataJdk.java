/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.concurrent.Callable;

/**
 * jdk内置Future模式
 * 
 * @author hujie
 * @version $Id: RealDataN.java, v 0.1 2016年8月27日 下午5:16:31 hujie Exp $
 */
public class RealDataJdk implements Callable<String> {

    private String para;

    public RealDataJdk(String para) {
        this.para = para;
    }

    /** 
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public String call() throws Exception {

        //这里是真实的业务逻辑，其执行可能很慢
        StringBuffer sb = new StringBuffer();
        try {
            for (int i = 0; i < 10; i++) {
                sb.append(para);

                Thread.sleep(100);
            }
        } catch (Exception e) {
        }

        return sb.toString();
    }

}
