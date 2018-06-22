package com.dhr.dp.chain.test;

import com.dhr.dp.chain.Handler;
import com.dhr.dp.chain.impl.DeptManager;
import com.dhr.dp.chain.impl.GeneralManager;
import com.dhr.dp.chain.impl.ProjectManager;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/11/22.
 */

public class ChainTest {
    public static void main(String[] args) {
        //先要组装责任链
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setNextHandler(h2);
        h2.setNextHandler(h1);
        //开始测试,申请交由项目经理审批,具体谁处理不关心,只关心处理结果
        String test1 = h3.handlerReques("张三", 300);
        System.out.println("test1 = " + test1);
        System.out.println("---------------------------------------");

        String test3 = h3.handlerReques("张三", 700);
        System.out.println("test3 = " + test3);
        System.out.println("---------------------------------------");

        String test5 = h3.handlerReques("张三", 1500);
        System.out.println("test5 = " + test5);

    }
}
