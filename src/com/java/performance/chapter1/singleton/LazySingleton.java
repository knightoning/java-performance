/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * �������ӳټ��ػ��ƣ�
 * 1�����ھ�̬��Ա����instance ��ʼֵ����null,ȷ��ϵͳ����ʱû�ж���ĸ���
 * 2����getInstance()���������У��жϵ�ǰ�����Ƿ��Ѿ����ڣ��������򷵻أ����������ٽ�������
 * 3��getInstance()����������ͬ���������ڶ��̻߳����£����ܵ��¶��ʵ��������
 * @author hujie
 * @version $Id: LazySingleton.java, v 0.1 2016��7��16�� ����10:35:09 hujie Exp $
 */
public class LazySingleton {

    private LazySingleton(){
        System.out.println("LazySingleton is create...");
    }
    
    private static LazySingleton instance = null;
    
    public static synchronized LazySingleton getInstance(){
        
        if(instance == null){
            instance = new LazySingleton();
        }
        
        return instance;
    }
}
