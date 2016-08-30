/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.java.performance.extern.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author hujie
 * @version $Id: FutureJdkTest.java, v 0.1 2016年8月27日 下午5:23:49 hujie Exp $
 */
public class FutureJdkTest {

    /**
     * 
     * @param args
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //构造FutureTask
        FutureTask<String> future = new FutureTask<String>(new RealDataJdk("a"));
        
        ExecutorService executor = Executors.newFixedThreadPool(1);
        
        //执行FutureTask,相当于上例中的client.request("a")发送请求
        //在这里开启线程进行RealData的call()执行
        executor.submit(future);
        System.out.println("请求完毕");
        
        try {
            //这里依然可以做额外的数据操作，这里使用sleep代替其他业务逻辑的处理
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        //相当于上例中的data.getResult(),取得call()方法的返回值
        //如果此时call()方法没有执行完成，则依然会等待
        System.out.println("数据="+future.get());
    }

}
