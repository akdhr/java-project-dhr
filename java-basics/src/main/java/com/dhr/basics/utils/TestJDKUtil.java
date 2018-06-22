package com.dhr.basics.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class TestJDKUtil {


    public static void main(String args[]) {

        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        Object[] arr = collection.toArray();
        System.out.println(arr);


    }
}
