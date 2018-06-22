package com.dhr.dp.observer.inf.impl;

import com.dhr.dp.observer.inf.Observed;
import com.dhr.dp.observer.inf.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :dhr博客
 * Created by duanhr30063 on 2017/11/30.
 */

public class BlogDhr implements Observed {

    /**
     * 博主名称
     */
    private String blogName = "dhr";
    /**
     * 观察者集合（存放粉丝）
     */
    private List<Observer> observerList = new ArrayList<Observer>();


    public void addFansObserver(Observer observer) {
        if (!observerList.contains(observer))
            observerList.add(observer);
    }

    public void removeFansObserver(Observer observer) {
        if (observerList.contains(observer))
            observerList.remove(observer);
    }

    public void notice(String message) {
        for (Observer observer : observerList) {
            observer.update(message, blogName);
        }
    }


}
