package com.lc.controller;

import com.lc.service.NormalService;
import com.lc.util.AddSHA;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.apache.solr.common.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  @描述：微信小程序  获取推送接口
 ** @author LC
 *  创建时间：2018-9-1 下午23:30
 */
@RestController
@Scope(value="prototype")
@RequestMapping("wx_getMessage")
public class wx_getMessage {

    @Autowired
    private NormalService normalService;

    @RequestMapping("/getWX_Push")
    public void getWX_Message(HttpServletResponse response, HttpServletRequest request,
                                @RequestParam("signature")String signature,
                                @RequestParam("timestamp")String timestamp,
                                @RequestParam("nonce")String nonce,
                                @RequestParam("echostr")String echostr
                                ) throws AesException, ParserConfigurationException, IOException, SAXException {
        String encodingAesKey = "XOYn8KQneT4qhdpGVwB0JMnnl43eD0vIkXZRRvkTjKO";   //加密密钥
        String token = "choujiang";
        String appId = "wx2907f67feb4f299d";

        PrintWriter out =  response.getWriter();
        if(checkSignature(token,signature,timestamp,nonce)){
                out.print(echostr);
        }
        out.close();
        out = null;
    }

    public static boolean checkSignature(String token,String signature,String timestamp,String nonce){
        // System.out.println("###token:"+token+";signature:"+signature+";timestamp:"+timestamp+"nonce:"+nonce);
        boolean flag = false;
        if(signature!=null && !signature.equals("") && timestamp!=null && !timestamp.equals("") && nonce!=null && !nonce.equals("")){
            String sha1 = "";
            String[] ss = new String[] { token, timestamp, nonce };
            Arrays.sort(ss);
            for (String s : ss) {
                sha1 += s;
            }

            sha1 = AddSHA.SHA1(sha1);

            if (sha1.equals(signature)){
                System.out.println(sha1);
                flag = true;
            }
        }
        return flag;
    }

}
