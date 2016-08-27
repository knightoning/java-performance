/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.chapter1.singleton;

/**
 * 单例枚举类
 * 
 * @author hujie
 * @version $Id: SingletonEnum.java, v 0.1 2016年7月16日 下午11:00:40 hujie Exp $
 */
public enum SingletonTypeEnum {
    
    SINGLETON("SINGLETON","非懒加载单例类型"),
    SINGLETON_LAZY("SINGLETON_LAZY","懒加载单例类型"),
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
