/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * ����
 * ȱ�㣺�޷���instance ʵ�����ӳټ��أ������������̱Ƚ���
 * 
 * @author hujie
 * @version $Id: Singleton.java, v 0.1 2016��7��16�� ����9:40:10 hujie Exp $
 */
public class Singleton {

    /**
     * ����������
     */
    private Singleton(){
        System.out.println("Singleton is create");
    }
    
    /**
     * ��̬ʵ������̬����
     */
    private static Singleton instance = new Singleton();
    
    /**
     * ��ȡ��������
     * 
     * @return ��������
     */
    public static Singleton getInstance(){
        return instance;
    }
    
    /**
     * �����������󷽷�
     */
    public  static void createString(){
        
        System.out.println("createString in Singleton");
    }
    
}
