/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

import java.io.Serializable;

/**
 * �����л��ĵ���
 * �����ƻ�����
 * 
 * @author hujie
 * @version $Id: SerSingleton.java, v 0.1 2016��7��17�� ����11:52:04 hujie Exp $
 */
public class SerSingleton implements Serializable{
    
    /** Serializable  */
    private static final long serialVersionUID = 1L;
    
    
    private String name;
    
    private SerSingleton(){
        
        System.out.println("SerSingleton is create....");
        
        name = "SerSingleton";
    }
    
    private static SerSingleton instance = new SerSingleton();
    
    public static SerSingleton getInstance(){
        
        return instance;
    }
    
    public static void createString(){
        
        System.out.println("createString in Singleton");
        
    }
    
    private Object readResolve(){
        
        return instance;
    }
    
    

}
