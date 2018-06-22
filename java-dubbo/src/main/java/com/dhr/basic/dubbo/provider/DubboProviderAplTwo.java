package com.dhr.basic.dubbo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dhr.basic.dubbo.service.HelloService;
import com.dhr.basic.dubbo.service.HelloServiceImpl;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/19.
 */

public class DubboProviderAplTwo {

    public static void provider() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-provider");
        application.setVersion("1.0");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.1.1.1:9090");
        ServiceConfig<HelloService> serviceConfig = new ServiceConfig<HelloService>();
        serviceConfig.setApplication(application);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setInterface(HelloService.class);
        serviceConfig.setRef(new HelloServiceImpl());
        serviceConfig.setCluster("failover");
        serviceConfig.export();

    }

    public static void main(String args[]) throws Exception {
        provider();
        System.out.println();
        while (true) {
            Thread.sleep(2000);
        }
    }
}
