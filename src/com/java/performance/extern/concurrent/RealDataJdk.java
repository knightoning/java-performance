/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.concurrent.Callable;

/**
 * jdk����Futureģʽ
 * 
 * @author hujie
 * @version $Id: RealDataN.java, v 0.1 2016��8��27�� ����5:16:31 hujie Exp $
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

        //��������ʵ��ҵ���߼�����ִ�п��ܺ���
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
