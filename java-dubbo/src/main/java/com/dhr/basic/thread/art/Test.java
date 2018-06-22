package com.dhr.basic.thread.art;

import com.dhr.basic.thread.art.demo2.queue.ArrayBlockingQueueTest;
import com.dhr.basic.thread.art.demo2.ReadThread;
import com.dhr.basic.thread.art.demo2.WriteThread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/13.
 */

public class Test {

    public static void main(String args[]) throws Exception{
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        System.out.println(threadMXBean.findMonitorDeadlockedThreads());
//        System.out.println(threadMXBean.getAllThreadIds().length);
//        long[] threadIds = threadMXBean.getAllThreadIds();
//        for (int i = 0; i < threadIds.length; i++) {
//            System.out.println(threadMXBean.getThreadCpuTime(threadIds[i]));
//        }
//        AtomicInteger ai = new AtomicInteger();

        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();
        //扩容只针对segment进行扩容、二hashmap扩容针对整个容器进行扩容，一旦扩容后没有新的元素进入，则进行了一次无效的扩容
        concurrentHashMap.put("a", 1);
        concurrentHashMap.put("b", 2);
        concurrentHashMap.put("c", "");
        concurrentHashMap.put("c", "");

        ArrayBlockingQueueTest test = new ArrayBlockingQueueTest(5);
        ReadThread thread = new ReadThread(test);
        thread.start();
//        Thread.sleep(5000);
        WriteThread writeThread = new WriteThread(test);
        writeThread.start();
    }
}
