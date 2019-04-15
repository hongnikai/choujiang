package com.lc.util;

import java.sql.Time;
import java.util.UUID;
/**
 * 随机数
 * @author LC (●'◡'●) 
 * @return
 */
public class lcRamdomUtil {
	
	
	/**
	 * 随机订单号    32位数  (￢︿̫̿￢☆) 
	 * @return
	 */
	public static String getRamdomString(){
		UUID uuid=UUID.randomUUID();
	    String str=uuid.toString();
	    String new_str = str.replace("-", "");
		return new_str;
	}
	
	
	/**
	 * 随机订单号 6位数可调 (●ˇ∀ˇ●)  
	 * @return
	 */
	public static String getFourRamdomString(){
		
		 String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     char[] rands = new char[6]; 
	     for (int i = 0; i < rands.length; i++) 
	     { 
	         int rand = (int) (Math.random() * a.length()); 
	         rands[i] = a.charAt(rand); 
	     } 
		return new String(rands);
	}
	
	/**
	 * 随机订单号 6位数+当前时间串er (●'◡'●)  
	 * @return
	 */
	public static String getSixPlusTimeStampRamdomString(){
		TimeUtil t=new TimeUtil();
		String six_ram= lcRamdomUtil.getFourRamdomString();
		long time=t.timeMath();
		String six_plus_time=(six_ram+time);
		return six_plus_time;
	}
	
}
