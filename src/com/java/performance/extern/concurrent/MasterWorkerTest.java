/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.Map;
import java.util.Set;

/**
 * 
 * @author hujie
 * @version $Id: MasterWorkerTest.java, v 0.1 2016年8月24日 下午4:05:09 hujie Exp $
 */
public class MasterWorkerTest {

    public static  void main(String[] args){
        
        Master  m = new Master(new PlusWorker(),5);
        for(int i=0;i<100;i++){
            m.submit(i);
        }
        m.execute();
        
        int re = 0;
        Map<String,Object> resultMap = m.getResultMap();
        
        System.out.println("resultMap="+resultMap);
        System.out.println("m.isCompleted="+m.isCompleted());
        
        while(resultMap.size()>0 || !m.isCompleted()){
            
            Set<String> keys = resultMap.keySet();
            
            String key = null;
            
            for(String k :keys){
                key = k;
                break;
            }
            
            Integer i = null;
            if(key != null){
                i = (Integer)resultMap.get(key) ;
            }
            
            if(i != null){
                re += i;
            }
            
            if(key != null){
                resultMap.remove(key);
            }
            
        }
        
        System.out.println("re="+re);
        
    }
}
