package com.dhr.dp.observer.inf.impl;

import com.dhr.dp.observer.inf.Observer;

/**
 * @Description :具体观察者B
 * Created by duanhr30063 on 2017/11/30.
 */

public class FansB implements Observer {

    private String fansBname = "忠实粉——B";

    public void update(String message, String name) {
        System.out.println(fansBname + ":看到" + name + "发布了：" + message);
    }


}
