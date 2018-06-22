package com.dhr.dp.factory.test;

import com.dhr.dp.factory.AbstractFactory;
import com.dhr.dp.factory.FactoryMethod;
import com.dhr.dp.factory.SimpleFactory;
import com.dhr.dp.factory.abstractfactory.factory.AbstractFactoryImpl;
import com.dhr.dp.factory.concretefactory.AProductFactory;
import com.dhr.dp.factory.concretefactory.BProductFactory;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/11/22.
 */

public class FactotyTest {

    public static void main(String args[]) throws Exception {
        //1.简单工厂模式(工厂类)
        Object object =  SimpleFactory.getProduct("A");
        System.out.println(object.toString());

        //2.工厂方法（对简单工厂的抽象）
        //当新增一个产品时，只需创建一个产品类和具体产品生产工厂即可,抽象工厂无需修改,符合“开闭原则”
        FactoryMethod A_factoryMethod = new AProductFactory();
        A_factoryMethod.create();
        FactoryMethod B_factoryMethod = new BProductFactory();
        B_factoryMethod.create();

        //3.抽象工厂(工厂接口+实现类;产品线接口+实现类)
        //A产品线实现生产不同产品
        AbstractFactory abstractFactory_A = new AbstractFactoryImpl();
        abstractFactory_A.createAProduct();
        abstractFactory_A.createBProduct();
        //B产品线实现生产不同产品
        AbstractFactory abstractFactory_B = new AbstractFactoryImpl();
        abstractFactory_B.createAProduct();
        abstractFactory_B.createBProduct();

    }
}
