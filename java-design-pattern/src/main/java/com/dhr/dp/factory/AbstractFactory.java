package com.dhr.dp.factory;

import com.dhr.dp.factory.abstractfactory.product.AProductInf;
import com.dhr.dp.factory.abstractfactory.product.BProductInf;

/**
 * @Description :抽象工厂模式：针对产品族概念，一个工厂可以生产各种产品（包含各种生产产品的方法）,和工厂方法不同的是无法新增新品
 * Created by duanhr30063 on 2017/11/22.
 */

public interface AbstractFactory {

    /**
     * 创建A产品,如轿车
     *
     * @return
     */
    AProductInf createAProduct();

    /**
     * 创建B产品,如货车
     *
     * @return
     */
    BProductInf createBProduct();

}
