package com.dhr.basic.thread.art.demo2.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description :注释
 * <p>
 * <p>
 * .ArrayBlockingQueue：一个由数组结构组成的有界阻塞队列。
 * ·LinkedBlockingQueue：一个由链表结构组成的有界阻塞队列。
 * ·PriorityBlockingQueue：一个支持优先级排序的无界阻塞队列。
 * ·DelayQueue：一个使用优先级队列实现的无界阻塞队列。
 * ·SynchronousQueue：一个不存储元素的阻塞队列。
 * ·LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
 * ·LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。
 * <p>
 * <p>
 * <p>
 * Created by duanhr30063 on 2018/3/15.
 */

public class ConcurrentLinkedQueueTest {
    /**
     * ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列
     * 数据结构:
     * ConcurrentLinkedQueue 结构:
     * private transient volatile Node<E> head;
     * private transient volatile Node<E> tail;
     * 默认情况下head节点存储的元素为空，tail节点等于head节点。
     * Node(内部类使用)结构:
     * volatile E item;       元素内容
     * volatile Node<E> next; 指向下一个节点的指针
     */
    private ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    private ArrayBlockingQueue arrayBlockingQueu = new ArrayBlockingQueue(100);

    public void add(Object object) {
        queue.add(object);
        arrayBlockingQueu.poll();
        arrayBlockingQueu.add(null);
    }

    public void get(Object object) {
        queue.poll();
    }
}
