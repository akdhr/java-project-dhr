package com.dhr.basics.thread.reentrantlock;

import java.io.Serializable;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/12.
 */

public abstract class AbstractOwnableSynchronizerTest implements Serializable {

    /**
     * Use serial ID even though all fields transient.
     */
    private static final long serialVersionUID = 1556815303216916496L;

    //供子类使用的空构造方法
    protected AbstractOwnableSynchronizerTest() {
    }

    private transient Thread exclusiveOwnerThread;

    //设置当前拥有独占访问的线程。 null 参数表示没有线程拥有访问。此方法不另外施加任何同步或 volatile 字段访问
    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    /**
     * 返回由 setExclusiveOwnerThread 最后设置的线程；如果从未设置，则返回 null。此方法不另外施加任何同步或 volatile 字段访问。
     *
     * @return 所有者线程
     */
    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

}
