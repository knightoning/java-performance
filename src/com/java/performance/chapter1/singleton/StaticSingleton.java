/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * ʹ���ڲ�����ά��������ʵ��
 * 1���ӳټ���
 * 2���̰߳�ȫ������Ҫʹ���߳�ͬ���ؼ��֣��Ӷ���������
 * @author hujie
 * @version $Id: StaticSingleton.java, v 0.1 2016��7��17�� ����11:40:02 hujie Exp $
 */
public class StaticSingleton {

    private StaticSingleton(){
        
        System.out.println("StaticSingleton is create");
    }
    
    private static class SingletonHolder{
        
        private static StaticSingleton instance = new StaticSingleton();
        
    }
    
    public static StaticSingleton getInstance(){
        
        return SingletonHolder.instance;
    }
}
