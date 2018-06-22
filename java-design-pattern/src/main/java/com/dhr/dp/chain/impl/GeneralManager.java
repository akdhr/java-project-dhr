package com.dhr.dp.chain.impl;

import com.dhr.dp.chain.Handler;

/**
 * @Description :具体处理者角色
 * 总经理,审批全部处理
 * Created by duanhr30063 on 2017/11/22.
 */

public class GeneralManager extends Handler {
    public String handlerReques(String user, double fee) {
        String str = "";
        if (fee >= 1000) {
            //简单测试，不区分不同部门人员
            str = "成功：总经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
        } else {
            //如果还有后继的处理对象，继续传递
            if (getNextHandler() != null) {
                return getNextHandler().handlerReques(user, fee);
            }
        }
        return str;
    }
}
