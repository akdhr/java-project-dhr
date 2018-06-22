package com.dhr.basics.generics;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/4.
 */

public class Shape<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
