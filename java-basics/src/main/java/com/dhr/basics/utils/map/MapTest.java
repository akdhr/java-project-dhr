package com.dhr.basics.utils.map;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/8.
 */

public class MapTest {
    public static void main(String args[]) {
        /*
        HashMap map = new HashMap(131);
        String a = new String("hello");
        String b = new String("hello");
        map.put("h", a);
        map.put("j", b);
        System.out.println(a.hashCode() & map.size());
        System.out.println(b.hashCode() & map.size());
        Set<Map.Entry> set = map.entrySet();
        Map map1 = new LinkedHashMap();
        */


        Map<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("hello", "123");
        new Thread2(concurrentHashMap, "hello").run();
        new Thread1(concurrentHashMap, "hello").run();
        System.out.println(concurrentHashMap.get("hello"));

    }
}
