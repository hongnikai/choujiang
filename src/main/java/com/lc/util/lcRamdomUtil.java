package com.lc.util;

import java.sql.Time;
import java.util.UUID;
import java.util.Arrays;
import java.util.Random;
/**
 * 随机数
 * @author lc (●'◡'●)
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

	/**
	 * 随机id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		return str;
	}


}
