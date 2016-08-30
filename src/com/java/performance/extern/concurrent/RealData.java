/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: RealData.java, v 0.1 2016��8��27�� ����2:37:24 hujie Exp $
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String para) {

        //RealData�Ĺ�����ܻ��������Ҫ�û��ȴ��ܾã�����ʹ��sleepģ��
        StringBuffer sb = new StringBuffer();
        try {
            for (int i = 0; i < 10; i++) {
                sb.append(para);
                //����ʹ��sleep������һ�������Ĳ�������
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("RealData �쳣" + e);
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
