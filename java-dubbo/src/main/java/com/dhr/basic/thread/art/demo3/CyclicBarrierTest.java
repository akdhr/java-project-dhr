package com.dhr.basic.thread.art.demo3;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/16.
 */

public class CyclicBarrierTest implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4, this);
    private Executor executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String, Integer> sheetCount = new ConcurrentHashMap<String, Integer>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    sheetCount.put(Thread.currentThread().getName(), 1);
                    try {
                        c.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("--------------------");
    }

    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetCount.entrySet()) {
            result += sheet.getValue();
        }
        sheetCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String args[]) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.count();
    }
}
