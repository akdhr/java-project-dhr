package com.dhr.basics.thread.reentrantlock;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;


/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/12.
 */

public abstract class AbstractQueuedSynchronizerTest extends AbstractOwnableSynchronizerTest implements java.io.Serializable {


    private static final long serialVersionUID = 3298020064035931824L;

    /**
     * Creates a new {@code AbstractQueuedSynchronizer} instance
     * with initial synchronization state of zero.
     */
    protected AbstractQueuedSynchronizerTest() {

    }

    //节点定义
    static final class Node {
        /**
         *  这两个常量用于表示这个结点支持共享模式还是独占模式，
         *  共享模式指的是允许多个线程获取同一个锁而且可能获取成功，
         *  独占模式指的是一个锁如果被一个线程持有，其他线程必须等待。
         *  多个线程读取一个文件可以采用共享模式，而当有一个线程在写文件时不会允许另一个线程写这个文件，这就是独占模式的应用场景
         */
        /**
         * 标记表示节点在共享模式下等待
         */
        static final Node SHARED = new Node();
        /**
         * 标记表示节点在独占模式下等待
         */
        static final Node EXCLUSIVE = new Node();


        static final int CANCELLED = 1;
        static final int SIGNAL = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;
        /**
         * Status field, taking on only the values:
         * SIGNAL:     The successor of this node is (or will soon be)
         * blocked (via park), so the current node must
         * unpark its successor when it releases or
         * cancels. To avoid races, acquire methods must
         * first indicate they need a signal,
         * then retry the atomic acquire, and then,
         * on failure, block.
         * CANCELLED:  This node is cancelled due to timeout or interrupt.
         * Nodes never leave this state. In particular,
         * a thread with cancelled node never again blocks.
         * CONDITION:  This node is currently on a condition queue.
         * It will not be used as a sync queue node
         * until transferred, at which time the status
         * will be set to 0. (Use of this value here has
         * nothing to do with the other uses of the
         * field, but simplifies mechanics.)
         * PROPAGATE:  A releaseShared should be propagated to other
         * nodes. This is set (for head node only) in
         * doReleaseShared to ensure propagation
         * continues, even if other operations have
         * since intervened.
         * 0:          None of the above
         * <p>
         * The values are arranged numerically to simplify use.
         * Non-negative values mean that a node doesn't need to
         * signal. So, most code doesn't need to check for particular
         * values, just for sign.
         * <p>
         * The field is initialized to 0 for normal sync nodes, and
         * CONDITION for condition nodes.  It is modified using CAS
         * (or when possible, unconditional volatile writes).
         */
        volatile int waitStatus;
        /*当前节点 指向前驱节点*/
        volatile Node prev;
        /*当前节点 指向后继节点*/
        volatile Node next;
        /* 线程入队这个节点。初始化建设和清零后使用。*/
        volatile Thread thread;
        /**
         * 链接到下一个节点等待条件，或特殊价值共享。因为只当访问条件队列处于独占模式时，我们只需要一个简单的链接队列在等待时保存节点
         * 条件.然后将它们转移到队列中。重新获得。而且因为条件只能是排他性的， 我们通过使用特殊值表示共享来保存字段。  模式。
         * <p>
         * 独占模式下（条件只能是排他性）,用于存放等待节点并放入队列中。
         * 共享模式下 （nextWaiter == SHARED）
         */
        volatile Node nextWaiter;

        Node() {
        }

        Node(Thread thread, Node node) {
            this.nextWaiter = node;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
        }

        /**
         * 是否共享模式
         *
         * @return
         */
        final boolean isShared() {
            //共享模式下 （nextWaiter == SHARED）,false代表独占模式
            return nextWaiter == SHARED;
        }

        /**
         * 查询前驱节点
         *
         * @return
         * @throws NullPointerException
         */
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }


    }

    /**
     * Head of the wait queue, lazily initialized.  Except for
     * initialization, it is modified only via method setHead.  Note:
     * If head exists, its waitStatus is guaranteed not to be
     * CANCELLED.
     */
    private transient volatile Node head;
    /**
     * Tail of the wait queue, lazily initialized.  Modified only via
     * method enq to add new wait node.
     */
    private transient volatile Node tail;
    /**
     * The synchronization state.
     */
    private volatile int state;

    protected final int getState() {
        return state;
    }

    protected final void setState(int newState) {
        state = newState;
    }

    public final void acquire(int arg) {
        if (!tryAcquire(arg) && acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
    }

    static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }

    /**
     * 父类定于，交于子类具体实现
     *
     * @param arg
     * @return
     */
    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryRelease(int arg) {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates and enqueues node for current thread and given mode.
     * 当前线程指定模式（独占模式下等待）的节点创建和入队(等待节点，准备入队)
     *
     * @param
     * @return
     */
    private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        Node pred = tail;
        //取队尾节点并判空
        if (pred != null) {
            //当前节点的prev指向旧的队尾节点
            node.prev = pred;
            //设置新的队尾节点
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
        //队尾节点为空,则插入空NODE，然后插入队尾
        enq(node);
        return node;
    }

    /**
     * Inserts node into queue, initializing if necessary. See picture above.
     * 1.判断tail是否存在,不存在创建一个空的Node作为head节点;若存在直接执行2
     * 2.将新的node插入队尾并返回
     *
     * @param node
     * @return
     */
    private Node enq(final Node node) {
        for (; ; ) {
            Node t = tail;
            if (t == null) {
                //队列tail == null ,必须初始化一个空Node当做head节点,并设置tail = head;
                // 当t == null 此时体现出空的for循环的作用,在设置空的头结点之后并设置tail = head,tail不在为null,此时将node插入队尾并返回
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }

        }
    }

    /**
     * Acquires in exclusive uninterruptible mode for thread already in
     * queue. Used by condition wait methods as well as acquire.
     *
     * @param node the node
     * @param arg  the acquire argument
     * @return {@code true} if interrupted while waiting
     */
    final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            //保证队列的FIFO特性
            for (; ; ) {
                final Node p = node.predecessor();
                //如果当前节点的前驱节点是头结点(实际是空NODE),则再次尝试获取锁
                if (p == head && tryAcquire(arg)) {
                    //如果node的前驱节点为head并且获取锁成功,则设置node为head节点
                    setHead(node);
                    p.next = null;//help GC 将旧的head节点剔除queue中,交由gc进行管理
                    failed = false;//新的node添加成功,更改失败状态为false
                    return interrupted;
                }
                //p!=head 或者 不可获取锁(不是head一直循环等待,直到head然后跳出并返回true)
                if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            //TODO 针对以上操作最后判断failed状态,是否取消node入队操作
            if (failed)
                cancelAcquire(node);
        }
    }


    private void setHead(Node node) {
        head = node;
        node.thread = null;//TODO why set thread is null
        node.prev = null;
    }

    /**
     * Checks and updates status for a node that failed to acquire.
     * Returns true if thread should block. This is the main signal
     * control in all acquire loops.  Requires that pred == node.prev.
     *
     * @param pred node's predecessor holding status
     * @param node the node
     * @return {@code true} if thread should block
     */
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;
        if (ws == Node.SIGNAL)  // SIGNAL = -1       如果前节点status为signal，直接返回。（表示后节点可放心休眠）
            return true;
        if (ws > 0) {           //CANCELLED = 1      前节点为cancel状态，则跳过前节点，并关联到前面第一个不为cancel状态的节点
            /*
             * Predecessor was cancelled. Skip over predecessors and
             * indicate retry.
             */
            do {
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
        } else {                //前节点为propagate、conditions、0 等状态则修改为为signal状态。
             /*
             * waitStatus must be 0 or PROPAGATE.  Indicate that we
             * need a signal, but don't park yet.  Caller will need to
             * retry to make sure it cannot acquire before parking.
             */
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }

    /**
     * Convenience method to park and then check if interrupted
     *
     * @return {@code true} if interrupted
     */
    private final boolean parkAndCheckInterrupt() {
        //blocker the synchronization object responsible for this thread parking(当前线程停止同步锁控制对象)
        LockSupport.park(this);
        //返回线程是否中断
        return Thread.interrupted();
    }

    private void cancelAcquire(Node node) {
        if (node == null)
            return;
        //将包含的线程删除，
        node.thread = null;
        Node pred = node.prev;
        //跳过当前节点前面已经处于canceled状态的节点
        while (pred.waitStatus > 0) {
            node.prev = pred = pred.prev;
        }
        Node predNext = pred.next;
        //将当前节点状态设置为cancel
        node.waitStatus = Node.CANCELLED;
        //如果当前节点是尾节点，设置当前节点的前节点为尾节点，并且把前节点（已经成为尾节点）的next指针置为空，完成出队操作。如下图所示
        if (node == tail && compareAndSetTail(node, pred)) {
            compareAndSetNext(pred, predNext, null);
        } else {
            //TODO
        }
    }

    public final boolean release(int arg) {
        if (tryRelease(arg)) {
            Node h = head;
            if (h != null && h.waitStatus != 0)
                unparkSuccessor(h);
            return true;
        }
        return false;
    }

    private void unparkSuccessor(Node node) {
        int ws = node.waitStatus;
        if (ws < 0) {
            compareAndSetWaitStatus(node, ws, 0);
        }
        Node s = node.next;
        if (s == null || s.waitStatus > 0) {
            s = null;
            for (Node t = tail; t != null && t != node; t = t.prev)
                if (t.waitStatus <= 0)
                    s = t;
        }
        if (s != null)
            LockSupport.unpark(s.thread);
    }


    public class ConditionObjectTest implements Condition, Serializable {
        private static final long serialVersionUID = 6023642987403603720L;

        private transient Node firstWaiter;

        private transient Node lastWaiter;

        public ConditionObjectTest() {
        }

        @Override
        public void await() throws InterruptedException {

        }

        @Override
        public void awaitUninterruptibly() {

        }

        @Override
        public long awaitNanos(long nanosTimeout) throws InterruptedException {
            return 0;
        }

        @Override
        public boolean await(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public boolean awaitUntil(Date deadline) throws InterruptedException {
            return false;
        }

        @Override
        public void signal() {

        }

        @Override
        public void signalAll() {

        }
    }


    //直接操作内存,可不用实现锁机制
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;
    private static final long nextOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizerTest.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizerTest.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizerTest.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizerTest.Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizerTest.Node.class.getDeclaredField("next"));

        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, headOffset, expect, update);
    }

    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    /**
     * CAS waitStatus field of a node.
     */
    private static final boolean compareAndSetWaitStatus(Node node, int expect, int update) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset, expect, update);
    }

    /**
     * CAS next field of a node.
     */
    private static final boolean compareAndSetNext(Node node, Node expect, Node update) {
        return unsafe.compareAndSwapObject(node, nextOffset, expect, update);
    }
}
