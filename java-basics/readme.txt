IO体系结构分类
    --流式
        --字节流（8位二进制）
            --InputStream （二进制格式操作）  抽象类，基于字节的输入操作，是所有输入流的父类。定义了所有输入流都具有的共同特征。
            --OutputStream（二进制格式操作） 抽象类。基于字节的输出操作。是所有输出流的父类。定义了所有输出流都具有的共同特征。
        --字符流（（16位二进制,一个字符占两个字节）
            --Writer （文件格式操作）：抽象类，基于字符的输入操作。
            --Reader （文件格式操作）：抽象类，基于字符的输出操作。
    --非流式
    --其他


备注:
RandomAccessFile（随机文件操作）：它的功能丰富，可以从文件的任意位置进行存取（输入输出）操作。




重点掌握字符、字节流读取



数据结构及算法：

简单的链表，数组，堆栈，队列，图，几个排序算法
