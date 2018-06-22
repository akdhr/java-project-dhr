##Java 类库和常用类库介绍——序
###Java 类库概念： 
    Java 的应用程序接口 (API) 以包的形式来组织，每个包提供了大量的相关类、接口和异常处理类，这些包的集合就是 Java 的类库
 
包名以 Java 开始的包是 Java 核心包 (Java Core Package) ；
包名以 Javax 开始的包是 Java 扩展包 (Java Extension Package) ，例如 javax.swing 包；
 
常用的 Java 核心包 (Java Core Package)
1.       java.lang      Java 编程语言的基本类库
2.       java.applet     创建 applet 需要的所有类
3.       java.awt       创建用户界面以及绘制和管理图形、图像的类
4.       java.io        通过数据流、对象序列以及文件系统实现的系统输入、输出
5.       java.net       用于实现网络通讯应用的所有类
6.       java.util       集合类、时间处理模式、日期时间工具等各类常用工具包
其它还有
7.       java.sql        访问和处理来自于 Java 标准数据源数据的类
8.       java.test       以一种独立于自然语言的方式处理文本、日期、数字和消息的类和接口
9.       java.security    设计网络安全方案需要的一些类
10.   java.beans     开发 Java Beans 需要的所有类
11.   java.math      简明的整数算术以及十进制算术的基本函数
12.   java.rmi       与远程方法调用相关的所有类
 
常用的 Java 扩展包 (Java Extension Package)
1.  javax.accessibility  定义了用户界面组件之间相互访问的一种机制
2.  javax.naming.*     为命名服务提供了一系列类和接口
3.  javax.swing.*       提供了一系列轻量级的用户界面组件，是目前 Java 用户界面常用的包
 
 
注 1 ：最重要且常用的是 1 和 6 ，已用黑体标出的为，需重点掌握
注 2 ：在使用 Java 时，除了 java.lang 外，其他的包都需要 import 语句引入之后才能使用。
 

重点讲解内容：java.lang和java.util。
java.lang 包
这个包称为 java 语言包，是由编译器自动引入的。程序中不必用 import 语句就可以使用。它所包含的类和接口对所有实际的 Java 程序都是必要的。
1.       object 类
2.       数学类 (Math)
3.       数据类型类
4.       线程类
5.       字符串类 (String 类和 StringBuffer 类 )
6.       系统及运行类 (System 类和 Runtime 类 )
7.       错误和异常处理类 (Throwable 、 Exception 、 Error)
8.       过程类 (process)
 
 
java.util 包
1. 日期类、日历类（ Data 、 Calendar 、 GregorianCalendar ）
2. 随机数类（ Random ）
3. 位运算类（ BitSet ）
4. 矢量类（ Vector ）
5. 数据结构类（ Stack ）
6. 散列表类（ Hashtable ）
7. StringTokenizer类


集合
Collection：集合顶层接口
AbstractCollection：集合抽象类

关联数组
Map：顶层接口
AbstractMap：抽象类实现，提供了子类的通用操作
HashMap：哈希表实现，并发非安全
IdentityHashMap：根据==判断key相等的哈希表
LinkedHashMap：能够记录访问或者插入顺寻的哈希表，在拉链结构的基础上多了一个链表结构
Properties：属性文件类
SortedMap：排序接口
EnumMap：以枚举类型作key的map实现，内部采用两个数组实现，一个保存key，一个保存对应的value
NavigableMap：导航接口
TreeMap：基于红黑树实现
WeakHashMap：基于弱引用实现，与垃圾收集器协同工作，弱键在垃圾收集器回收对象时可以被回收
ConcurrentHashMap：基于段来实现，可以极大的提高访问并发量，因为每次锁定时只锁定一个段，而不是整个哈希表
Dictionary：顶层接口，代表老接口，不能用null做key或者value
HashTable：继承Dictionay的哈希表实现，并发安全

队列
Queue：队列顶层接口
LinkedList：列表实现的队列
AbstractQueue：队列抽象类，提供了子类操作的模版方法
PriorityQueue：
Deque：
ArrayDeque：

列表
List：列表顶层接口
AbstractList：列表抽象类
AbstractSequentialList：
ArrayList：数组实现
CopyOnWriteArrayList：数组实现，在列表发生写操作时重新复制一份新的数组
LinkedList：带头节点的双向循环列表
Stack：栈
Vector：并发安全的数组实现

键集
Set：健集顶层接口
AbstractSet：抽象健集类
HashSet：内部使用了HashMap
SortedSet：排序健集接口
NavigibleSet：导航健集接口
TreeSet：内部使用TreeMap
LinkedHashSet：内部使用LinkedArrayList
CopyOnWriteSet：写时复制健集，内部使用了CopyOnWriteList
BitSet：

迭代器
Iterator：迭代器顶层接口
ListIterator：同时支持向前和向后的迭代器

观察者
Observer：观察者接口
Observable：被观察者接口

比较器
Comparable(lang)：自然比较器，依靠类继承的方式来实现
Comparator：依靠类组合的方式来实现

工具：
Collections：集合工具类
Arrays：数组工具类


学习步骤：
java.lang包开始


###1.java中深浅拷贝
    参考: http://blog.csdn.net/shuaishuai3409/article/details/51685082;
    总结：在java中使用clone()方法如何判别深浅拷贝呢，就是判断拷贝后的对象是否相等，
    即判断两对象的地址是否相同。B=clone(A),A==B为真否
###2.java中LIST
    1.查询和插入性能差别以及之间的切换(LinkedList linkedList = new LinkedList(arrayList))
    2.线程安全性arrylist和linkedlist非线程安全(转换为安全:Collections.synchronizedList(new ArrayList<>()))
###2.java中MAP
    