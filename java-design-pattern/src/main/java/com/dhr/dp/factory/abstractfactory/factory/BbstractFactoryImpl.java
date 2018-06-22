package com.dhr.dp.factory.abstractfactory.factory;

import com.dhr.dp.factory.AbstractFactory;
import com.dhr.dp.factory.abstractfactory.product.AProductInf;
import com.dhr.dp.factory.abstractfactory.product.BProductInf;
import com.dhr.dp.factory.abstractfactory.product.impl.AProductInfImpl;
import com.dhr.dp.factory.abstractfactory.product.impl.BProductInfImpl;

/**
 * @Description :抽象工厂具体实现类（创建不同产品线A,生产不同产品,但无法新增产品）
 * * Created by duanhr30063 on 2017/11/22.
 */

public class BbstractFactoryImpl implements AbstractFactory {

    public AProductInf createAProduct() {
        return new AProductInfImpl();
    }

    public BProductInf createBProduct() {
        return new BProductInfImpl();
    }
}
