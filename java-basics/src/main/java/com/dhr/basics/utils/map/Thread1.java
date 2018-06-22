package com.dhr.basics.utils.map;

import java.util.Map;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/10.
 */

public class Thread1 implements Runnable {
    Map<String,String> map;
    String key;

    public Thread1(Map map, String key) {
        this.map = map;
        this.key = key;
    }

    @Override
    public void run() {
        try {
            map.put(key,"1234");
            System.out.println("thread1=" + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
