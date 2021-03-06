package com.dhr.dp.factory;

import com.dhr.dp.factory.beans.Product;

/**
 * @Description :工厂方法模式（FACTORY METHOD）是对简单工厂模式进行了抽象化，符合“开闭原则”，实现了可扩展。
 * 意义：
 *      工厂方法(Factory Method)模式的意义是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类当中。
 * 核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，仅负责具体工厂子类必须实现的接口，
 * 这样进一步抽象化的好处是使得工厂方法模式可以使系统在不修改具体工厂角色的情况下引进新的产品。
 * 理解：
 *      工厂方法是针对每一种产品提供一个工厂类 。通过不同的工厂实例来创建不同的产品实例。在同一等级结构中， 支持增加任意产品
 *   1.产品工厂抽象接口
 *   2.具体生产产品工厂类
 *   3.具体产品类
 *
 * 场景：
 *      如组装手机的代工厂。从手机原料工厂获取外壳、显示屏、主板、按键、电池等配件进行组装。
 * 组装手机工厂只负责手机的装配，而不负责配件的生产，也不需要关心从手机原料工厂出来的配件是否改变，只要手机各个配置衔接的接口不变就行。
 * 比如原料工厂显示屏从TFT 的换成了UFB的显示屏，对于组装手机的代工厂来说，只要接口没变，只需要继续装配就行。
 * Created by duanhr30063 on 2017/11/22.
 */
public interface FactoryMethod {

    /**
     * 抽象工厂目的就是创建产品,具体创建什么产品不关心,后续新增产品也无需修改此接口
     * @return
     */
    Product create();

}
