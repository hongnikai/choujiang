package com.lc.util;

/**
 * User: WZD
 * Date: 2017/12/13
 * Time: 15:06
 */
public class SystemState {
    /**
     * 合同状态
     */
    public final  static int CONTRACT_SERVER_PUSH_STATE = 0;    //服务商已发起
    public final static int CONTRACT_USER_CONFIMED_STATE = 1; //用户已确认
    public final static int CONTRACT_FINISH_STATE = 2; //合同已完结
    /**
     * 合同阶段
     */
    public final static int CONCTRACT_STAGE_DONOTHING = 0;
    public final static int CONCTRACT_STAGE_SERVER_PUSHED = 1;
    public final static int CONCTRACT_STAGE_USER_CONFIMED = 2;

    /**
     * 订单状态
     */
    public final static int COMMODITY_ORDER_START = 0;
    public final static int COMMODITY_ORDER_PAYED = 1;
    public final static int COMMODITY_ORDER_SENDED = 2;
    public final static int COMMODITY_ORDER_RECIVED = 3;





}
