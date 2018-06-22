package com.dhr.dp.chain.impl;

import com.dhr.dp.chain.Handler;

/**
 * @Description :具体处理者角色
 * 部门经理,审批金额只能在1000以内
 * Created by duanhr30063 on 2017/11/22.
 */

public class DeptManager extends Handler {
    public String handlerReques(String user, double fee) {
        String str = "";
        if (fee < 1000) {
            str = "成功：部门经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
        } else {
            //交由下一个人进行处理
            if (getNextHandler() != null) {
                return getNextHandler().handlerReques(user, fee);
            }
        }


        return str;
    }
}
