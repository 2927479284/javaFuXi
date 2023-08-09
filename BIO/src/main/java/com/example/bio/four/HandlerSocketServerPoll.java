package com.example.bio.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * socket线程池
 */
public class HandlerSocketServerPoll {

    private ThreadPoolExecutor executor;

    /**
     * 创建线程池
     * @param maxThreadNum 最大线程数量
     * @param queueSize 缓存任务数量
     */
    public HandlerSocketServerPoll(int maxThreadNum,int queueSize) {
        executor = new ThreadPoolExecutor(3,maxThreadNum,120, TimeUnit.SECONDS,new ArrayBlockingQueue<>(queueSize));
    }


    /**
     * 创建一个方法 用来提交任务给线程池进行暂时缓存，等待线程池来处理这个线程任务
     * @param runnable 任务
     */
    public void executor(Runnable runnable){
        executor.execute(runnable);
    }
}
