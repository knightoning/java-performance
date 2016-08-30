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
 * @version $Id: Worker.java, v 0.1 2016��8��24�� ����3:29:36 hujie Exp $
 */
public class Worker implements Runnable{
    
    //������У�����ȷ��������
    protected Queue<Object> workQueue;
    
    //������������
    protected Map<String,Object> resultMap;
    
    public void setWorkQueue(Queue<Object> workQueue){
        this.workQueue = workQueue;
    }
    
    public void setResultMap(Map<String,Object> resultMap){
        this.resultMap = resultMap;
    }
    
    //����������߼�����������ʵ�־����߼�
    public Object handle(Object input){
        return input;
    }

    /** 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true){
            //��ȡ������
            Object input = workQueue.poll();
            if(input == null){
                break;
            }
            //����������
            Object re = handle(input);
            //��������д������
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

}
