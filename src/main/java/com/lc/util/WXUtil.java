package com.lc.util;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.lc.util.MD5Util;


/**
 * 微信参数工具类
 * @author MengJinyue
 *
 */
public class WXUtil {
	
	/**
	 * 随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "GBK");
	}

	/**
	 * 时间戳
	 * @return
	 */
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	/**
	 * 随机订单号
	 * @return
	 */
	public static String getTrade_No() { // length表示生成字符串的长度
	/*	String currTime = TenpayUtil.getCurrTime();
		//8位日期
		String strTime = currTime.substring(8, currTime.length());
		//四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		//10位序列号,可以自行调整。
		String strReq = strTime + strRandom;
		*/
		
		lcRamdomUtil lc=new lcRamdomUtil();
		Long currTime=System.currentTimeMillis();
		String c=currTime.toString();
		String strReq=(c+lc.getFourRamdomString());
		
		return strReq;
	}
	
	/**
	 * 客户端的ip地址
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader(" x-forwarded-for ");
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" WL-Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
//	public String getPackage(String transaction_id,String nonce_str,String out_trade_no) {
//		TreeMap<String, String> treeMap = new TreeMap<String, String>();
//		treeMap.put("appid", ConstantUtil.APP_ID);
//		treeMap.put("mch_id", ConstantUtil.PARTNER);
//		treeMap.put("transaction_id", transaction_id);
//		treeMap.put("nonce_str", nonce_str);
//		treeMap.put("out_trade_no", out_trade_no);
//		
//		StringBuilder sb = new StringBuilder();
//		for (String key : treeMap.keySet()) {
//			sb.append(key).append("=").append(treeMap.get(key)).append("&");
//		}
//		sb.append("key=" + ConstantUtil.PARTNER_KEY);
//		String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
//		treeMap.put("sign", sign);
//
//		StringBuilder xml = new StringBuilder();
//		xml.append("<xml>\n");
//
//		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
//			if ("body".equals(entry.getKey()) || "sign".equals(entry.getKey())) {
//				xml.append("<" + entry.getKey() + "><![CDATA[").append(entry.getValue()).append("]]></" + entry.getKey() + ">\n");
//			} else {
//				xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
//			}
//		}
//		xml.append("</xml>");
//		return xml.toString();
//	}
}
