package com.dhr.dp.factory.concretefactory;

import com.dhr.dp.factory.FactoryMethod;
import com.dhr.dp.factory.beans.AProduct;
import com.dhr.dp.factory.beans.Product;

/**
 * @Description :具体产品A生产工厂
 * Created by duanhr30063 on 2017/11/22.
 */

public class AProductFactory implements FactoryMethod {
    public Product create() {
        return new AProduct();
    }
}
