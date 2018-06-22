package com.dhr.dp.factory.concretefactory;

import com.dhr.dp.factory.FactoryMethod;
import com.dhr.dp.factory.beans.BProduct;
import com.dhr.dp.factory.beans.Product;

/**
 * @Description :具体产品B生产工厂
 * Created by duanhr30063 on 2017/11/22.
 */

public class BProductFactory implements FactoryMethod {
    public Product create() {
        return new BProduct();
    }
}
