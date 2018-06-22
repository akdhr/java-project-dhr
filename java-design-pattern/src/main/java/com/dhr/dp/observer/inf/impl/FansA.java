package com.dhr.dp.observer.inf.impl;

import com.dhr.dp.observer.inf.Observer;

/**
 * @Description :具体观察者A
 * Created by duanhr30063 on 2017/11/30.
 */

public class FansA implements Observer {

    private String fansAname = "脑残粉——A";

    public void update(String message, String name) {

        System.out.println(fansAname + ":看到" + name + "发布了：" + message);
    }


}
