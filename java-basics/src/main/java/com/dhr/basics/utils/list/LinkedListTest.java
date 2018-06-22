package com.dhr.basics.utils.list;


import java.util.*;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class LinkedListTest {

    private Node first;
    private Node last;
    private int size;
//    final LinkedList.Node<E> l = last;
//    final LinkedList.Node<E> newNode = new LinkedList.Node<>(l, e, null);
//    last = newNode;
//        if (l == null)
//    first = newNode;
//        else
//    l.next = newNode;
//    size++;
//    modCount++;

    public void add(String e) {
        Node l = last;
        Node newNode = new Node(l, null, e);
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public static void main(String args[]) {
        /*LinkedListTest list = new LinkedListTest();
        list.add("123");
        list.add("1234");
        System.out.println(list);

        int oldCapacity = 9;
        //1.5倍增加
        int a = oldCapacity + (oldCapacity >> 1);
        System.out.println(a);
        //LIST CONVER SYNC
        Collections.synchronizedList(new ArrayList<>());
        */

        /*
        //数据量测试以及转换耗费时间
        ArrayList arrayList = new ArrayList();
        for (int i = 0;i< 100000000;i++){
            arrayList.add("hello_"+i);
        }
        long startTime = System.currentTimeMillis();
        //频繁插入和删除的arrayList转linkedList
        LinkedList linkedList = new LinkedList(arrayList);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
        //频繁遍历的linkedList转arrayList
        ArrayList newArrayList = new ArrayList(linkedList);
        System.out.println((System.currentTimeMillis() - endTime));
        */


        List list = new Vector();
    }
}
