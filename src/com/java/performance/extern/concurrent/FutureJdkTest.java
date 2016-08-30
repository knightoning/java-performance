/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author hujie
 * @version $Id: FutureJdkTest.java, v 0.1 2016��8��27�� ����5:23:49 hujie Exp $
 */
public class FutureJdkTest {

    /**
     * 
     * @param args
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //����FutureTask
        FutureTask<String> future = new FutureTask<String>(new RealDataJdk("a"));
        
        ExecutorService executor = Executors.newFixedThreadPool(1);
        
        //ִ��FutureTask,�൱�������е�client.request("a")��������
        //�����￪���߳̽���RealData��call()ִ��
        executor.submit(future);
        System.out.println("�������");
        
        try {
            //������Ȼ��������������ݲ���������ʹ��sleep��������ҵ���߼��Ĵ���
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        //�൱�������е�data.getResult(),ȡ��call()�����ķ���ֵ
        //�����ʱcall()����û��ִ����ɣ�����Ȼ��ȴ�
        System.out.println("����="+future.get());
    }

}
