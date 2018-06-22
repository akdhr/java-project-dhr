package com.dhr.dp.chain;

/**
 * @Description :　　抽象处理者角色类
 *
 * 举例：申请聚餐费用审批，不同领导审批金额不同,有领导处理则结束，不能处理返回申请失败
 * Created by duanhr30063 on 2017/11/22.
 */

public abstract class Handler {

    /**
     * 下一个处理请求的对象
     */
    protected Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    /**
     * 处理请求的抽象方法
     * @param user
     * @param fee
     */
    public abstract String handlerReques(String user,double fee);
}
