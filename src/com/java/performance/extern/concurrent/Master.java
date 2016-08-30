/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Master����
 * 
 * @author hujie
 * @version $Id: Master.java, v 0.1 2016��8��24�� ����2:26:14 hujie Exp $
 */
public class Master {

    //�������
    protected Queue<Object>       workQueue = new ConcurrentLinkedQueue<Object>();

    //Worker����
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();

    //������������
    protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    //Master���죬��Ҫһ��worker�����߼�������Ҫ��worker��������
    public Master(Worker worker, int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    //�ύһ������
    public void submit(Object job) {
        workQueue.add(job);
    }

    //�����ӽ������
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    //��ʼ�������е�Worker���̣����д���
    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }

    //�Ƿ����е������񶼽���
    public boolean isCompleted() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

}
