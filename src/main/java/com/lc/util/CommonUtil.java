package com.lc.util;

import java.util.Random;
import java.util.UUID;

import com.lc.util.TenpayUtil;

public class CommonUtil {
	
	//获取4位置随机数
	public static String getRandom4(){
		
		Random random = new Random(); 
		String result="";

		for(int i=1;i<=4;i++){
			result+=random.nextInt(10);   
		}	
		
		return result;
	}	
	
	/**
	 * 随机订单号
	 * @return
	 */
	public static String getTrade_No() { // length表示生成字符串的长度
		String currTime = TenpayUtil.getCurrTime();
		//8位日期
		String strTime = currTime.substring(14, currTime.length());
		//四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		//10位序列号,可以自行调整。
		String strReq = strTime + strRandom;
//		String strReq = UUID.randomUUID().toString().replace("-", "");
		return strReq;
	}
	
	
}
