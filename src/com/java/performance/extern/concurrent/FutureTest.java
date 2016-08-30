/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

/**
 * 
 * @author hujie
 * @version $Id: FutureTest.java, v 0.1 2016��8��27�� ����3:01:49 hujie Exp $
 */
public class FutureTest {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        Client client = new Client();
        //������������أ���Ϊ�õ�����FutureData������RealData
        Data data = client.request("name");
        System.out.println("�������");
        
        try {
            //���������һ��sleep ���������ҵ���߼��Ĵ���
            //�ڴ�����Щҵ���߼��Ĺ����У�RealData���������Ӷ���������˵ȴ�ʱ��
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        //ʹ����ʵ������
        System.out.println("����="+ data.getResult());

    }

}
