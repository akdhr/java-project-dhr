package com.dhr.basics.utils.list;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/2.
 */

public class Node {
     Node prev;
     Node next;
     String item;



    public Node (Node prev,Node next,String item){
        this.prev = prev;
        this.next = next;
        this.item = item;
    }

}
