package com.dhr.basic.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dhr.basic.dubbo.service.HelloService;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/19.
 */

public class DubboConsumerAPl {
    public static void consumer() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-consumer");
        application.setVersion("1.0");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.1.1.1:9090");
        ReferenceConfig<HelloService> referenceConfig = new ReferenceConfig<HelloService>();
        referenceConfig.setApplication(application);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(HelloService.class);


        HelloService helloService = referenceConfig.get();
        System.out.println(helloService.sayHello());

    }

    public static void main(String args[]) throws Exception {
        consumer();
        while (true) {
            consumer();
            Thread.sleep(2000);
        }
    }
}
