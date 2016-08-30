/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * ����ö����
 * 
 * @author hujie
 * @version $Id: SingletonEnum.java, v 0.1 2016��7��16�� ����11:00:40 hujie Exp $
 */
public enum SingletonTypeEnum {
    
    SINGLETON("SINGLETON","�������ص�������"),
    SINGLETON_LAZY("SINGLETON_LAZY","�����ص�������"),
    ;
    
    private SingletonTypeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String code;
    
    private String desc;
    
}
