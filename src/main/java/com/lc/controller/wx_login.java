package com.lc.controller;

import com.lc.bean.OAuthInfo;
import com.lc.service.NormalService;
import com.lc.util.WeChatCommonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import net.sf.json.JSONException;
import java.net.ConnectException;
import java.net.URL;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/**
 *  @描述：微信小程序  登陆专用
 *    ps： 小程序登陆
 ** @author LC
 *  创建时间：2018-7-2 下午23:30
 */
@SuppressWarnings("all")
@RestController
@Scope(value="prototype")
@RequestMapping("wx_login")
public class wx_login {

    Jedis jedis = new Jedis("39.106.19.130",6379);   //jedis

    @Autowired
    private NormalService normalService;

    /**
     *  @描述：微信小程序  登陆专用
     *    ps： 用来处理日常琐碎
     ** @author LC
     *  创建时间：2018-7-2 下午23:30
     */
    @RequestMapping(value = "wx_login")
    public Object wx_login(HttpServletResponse response, HttpServletRequest request
                           ){
        System.out.println("—————————————————-----————进入wx_login接口------------———————————————————");
        String code = request.getParameter("code");     //获取code
        String openid = "";
        String accessToken = "";

        if (null != code && !"".equals(code)) {
            // 根据code换取openId
            OAuthInfo oa = WeChatCommonUtil.getOAuthOpenId_XCX(code);
            if (!"".equals(oa) && null != oa) {
                openid = oa.getOpenId();
               // accessToken = oa.getAccessToken();
            }
        }
        // 获取微信用户信息
        System.out.println("openid为:"+openid);
        System.out.println("—————————————————-----————返回json数据------------———————————————————");

        return openid;
    }


    // 请求方法
    public static JSONObject httpsRequest(String requestUrl, String requestMethod,
                                          String outputStr) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
            return jsonObject;
        } catch (ConnectException ce) {
            System.out.println("连接超时：{}" + ce);
        } catch (Exception e) {
            System.out.println("https请求异常：{}" + e);
        }
        return null;
    }




}
