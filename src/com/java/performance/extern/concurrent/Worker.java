/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author hujie
 * @version $Id: Worker.java, v 0.1 2016年8月24日 下午3:29:36 hujie Exp $
 */
public class Worker implements Runnable{
    
    //任务队列，用于确定子任务
    protected Queue<Object> workQueue;
    
    //子任务处理结果集
    protected Map<String,Object> resultMap;
    
    public void setWorkQueue(Queue<Object> workQueue){
        this.workQueue = workQueue;
    }
    
    public void setResultMap(Map<String,Object> resultMap){
        this.resultMap = resultMap;
    }
    
    //子任务处理的逻辑，在子类中实现具体逻辑
    public Object handle(Object input){
        return input;
    }

    /** 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            //获取子任务
            Object input = workQueue.poll();
            if(input == null){
                break;
            }
            //处理子任务
            Object re = handle(input);
            //将处理结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

}
