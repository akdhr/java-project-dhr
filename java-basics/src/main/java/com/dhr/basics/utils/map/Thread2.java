package com.dhr.basics.utils.map;

import java.util.Map;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/10.
 */

public class Thread2 implements Runnable {
    Map map;
    String key;

    public Thread2(Map map, String key) {
        this.map = map;
        this.key = key;
    }

    @Override
    public void run() {
        try {
            map.put(key, "thread2");
            Thread.sleep(5000);
            System.out.println("thread2=" + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
