package com.dhr.basic.dubbo.service;

import com.alibaba.dubbo.rpc.service.EchoService;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/19.
 */

public class HelloServiceImpl implements HelloService {
    public String sayHello() {
        return "hello dubbo.";
    }

    public String writeHello() {
        System.out.println("test result cache !!!");
        //回声测试,可用于监控服务调用流程是否正常
        EchoService echoService = (EchoService) new HelloServiceImpl();
        echoService.$echo("OK");

        return "test";
    }
}
