package com.dhr.basics.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class ListTest {




    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();
        String testStr = "hello!";
        list.add(testStr);

        System.out.println(list.set(0,"world"));
        System.out.println(list.get(0));

        System.out.println(list.removeAll(list));
        System.out.println(list);

        LinkedList linkedList = new LinkedList();
        linkedList.add("q");
        linkedList.addFirst("123");
        linkedList.addLast("21");

        System.out.println(linkedList);
        linkedList.remove(null);
    }
}
