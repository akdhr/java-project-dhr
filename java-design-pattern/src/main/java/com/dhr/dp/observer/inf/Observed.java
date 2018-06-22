package com.dhr.dp.observer.inf;

/**
 * @Description :被观察者接口
 * Created by duanhr30063 on 2017/11/30.
 */
public interface Observed {

    /**
     * 添加关注的粉丝
     *
     * @param observer
     */
    void addFansObserver(Observer observer);

    /**
     * 移除关注的粉丝
     *
     * @param observer
     */
    void removeFansObserver(Observer observer);

    /**
     * 被观察者（博主）发布动态后通知观察者（粉丝）
     *
     * @param message
     */
    void notice(String message);


}
