package com.dhr.basic.thread.communication.waitAndNotify.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}
