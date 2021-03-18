package com.ruoyi.mq.bean;

/**
 * @author japhet_jiu
 * @version 1.0
 */
public class SysConstant {

    /**
     * 测试队列
     */
    public static final String QUEUE_TEST_HELLO = "QUEUE_TEST_HELLO";

    /**死信交换机**/
    public static final String SYS_ORDER_DELAY_EXCHANGE = "SYS_ORDER_DELAY_EXCHANGE";
    /**接收死信队列消息**/
    public static final String SYS_ORDER_RECEIVE_EXCHANGE = "SYS_ORDER_RECEIVE_EXCHANGE";
    /**死信接收队列**/
    public static final String SYS_ORDER_RECEIVE_QUEUE = "SYS_ORDER_RECEIVE_QUEUE";
    /**延时队列**/
    public static final String SYS_ORDER_DELAY_QUEUE = "SYS_ORDER_DELAY_QUEUE";
    /**路由key**/
    public static final String SYS_ORDER_RECEIVE_KEY = "SYS_ORDER_RECEIVE_KEY";
    /**死信队列路由key**/
    public static final String SYS_ORDER_DELAY_KEY = "SYS_ORDER_DELAY_KEY";

    /**集客消息交换机**/
    public static final String SYS_NG_EXCHANGE = "SYS_Ng_EXCHANGE";
    public static final String SYS_NG_KEY = "SYS_NG_KEY";
    public static final String SYS_NG_QUEUE = "SYS_NG_QUEUE";

    /**审批交换机**/
    public static final String SYS_SP_EXCHANGE = "SYS_SP_EXCHANGE";
    public static final String SYS_SP_KEY = "SYS_SP_KEY";
    public static final String SYS_SP_QUEUE = "SYS_SP_QUEUE";

    /**发票核销**/
    public static final String SYS_FPHX_EXCHANGE = "SYS_FPHX_EXCHANGE";
    public static final String SYS_FPHX_KEY = "SYS_FPHX_KEY";
    public static final String SYS_FPHX_QUEUE = "SYS_FPHX_QUEUE";

    /**审核核销**/
    public static final String SYS_PRO_AUDIT_EXCHANGE = "SYS_PRO_AUDIT_EXCHANGE";
    public static final String SYS_PRO_AUDIT_KEY = "SYS_PRO_AUDIT_KEY";
    public static final String SYS_PRO_AUDIT_QUEUE = "SYS_PRO_AUDIT_QUEUE";
}
