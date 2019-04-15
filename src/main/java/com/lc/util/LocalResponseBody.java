package com.lc.util;

import java.util.ArrayList;

/**
 *                            _ooOoo_
 *                           o8888888o
 *                           88" . "88
 *                           (| -_- |)
 *                           O\  =  /O
 *                        ____/`---'\____
 *                      .'  \\|     |//  `.
 *                     /  \\|||  :  |||//  \
 *                    /  _||||| -:- |||||-  \
 *                    |   | \\\  -  /// |   |
 *                    | \_|  ''\---/''  |   |
 *                    \  .-\__  `-`  ___/-. /
 *                  ___`. .'  /--.--\  `. . __
 *               ."" '<  `.___\_<|>_/___.'  >'"".
 *              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *              \  \ `-.   \_ __\ /__ _/   .-` /  /
 *         ======`-.____`-.___\_____/___.-`____.-'======
 *                            `=---='
 *        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                      佛祖保佑       永无BUG
 *    @Author: wzd
 *    @Date: 2017/12/5 13:19
 *    @Description: 移动端响应信息
 */
public class LocalResponseBody<T> {
    private String responseState; // 0失败,1成功
    private String msg;
    private T data;

    public LocalResponseBody() {
    }

    public LocalResponseBody(String responseState, String msg, T data) {
        this.responseState = responseState;
        this.msg = msg;
        this.data = data;
    }

    public LocalResponseBody(String responseState, String msg) {
        this.responseState = responseState;
        this.msg = msg;
    }

    public LocalResponseBody(String msg) {
        this.msg = msg;
    }

    public String getResponseState() {
        return responseState;
    }

    public void setResponseState(String responseState) {
        this.responseState = responseState;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public LocalResponseBody doFail(T t){
        if(t != null){
            if(msg != null) return new LocalResponseBody("0", msg, t);
            return new LocalResponseBody("0", "操作失败", t);
        }else {
            if(msg != null) return new LocalResponseBody("0", msg, new ArrayList<String>());
            return new LocalResponseBody("0", "操作失败", new ArrayList<String>());
        }
    }
    public LocalResponseBody doSuccess(T t){
        if(t != null){
            if(msg != null) return new LocalResponseBody("1", msg, t);
            return new LocalResponseBody("1", "操作成功", t);
        }else {
            if(msg != null) return new LocalResponseBody("1", msg, new ArrayList<String>());
            return new LocalResponseBody("1", "操作成功", new ArrayList<String>());
        }
    }
    public LocalResponseBody doSearchFail(T t){
        if(t != null){
            if(msg != null) return new LocalResponseBody("0", msg, t);
            return new LocalResponseBody("0", "查询失败", t);
        }else {
            if(msg != null) return new LocalResponseBody("0", msg, new ArrayList<String>());
            return new LocalResponseBody("0", "查询失败", new ArrayList<String>());
        }
    }
    public LocalResponseBody doSearchSuccess(T t){
        if(t != null){
            if(msg != null) return new LocalResponseBody("1", msg, t);
            return new LocalResponseBody("1", "查询成功", t);
        }else {
            if(msg != null) return new LocalResponseBody("1", msg, new ArrayList<String>());
            return new LocalResponseBody("1", "查询成功", new ArrayList<String>());
        }
    }

    @Override
    public String toString() {
        return "{" +
                "responseState:'" + responseState + '\'' +
                ", msg:'" + msg + '\'' +
                '}';
    }
}
