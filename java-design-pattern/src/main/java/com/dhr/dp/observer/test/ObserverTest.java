package com.dhr.dp.observer.test;

import com.dhr.dp.observer.inf.impl.BlogDhr;
import com.dhr.dp.observer.inf.impl.FansA;
import com.dhr.dp.observer.inf.impl.FansB;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/11/30.
 */

public class ObserverTest {


    public static void main(String args[]) {
        FansA fansA = new FansA();
        FansB fansB = new FansB();


        BlogDhr blogDhr = new BlogDhr();
        //博主新增粉丝
        blogDhr.addFansObserver(fansA);
        blogDhr.addFansObserver(fansB);
        blogDhr.notice("哈哈哈,今天是个好日子...");
    }
}
