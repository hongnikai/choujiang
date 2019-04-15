package com.lc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.rmi.CORBA.Util;
/**
 *  @描述：获取系统时间
 *  @author LC   (●'◡'●)  lc
 *  创建时间：2018-3-2 上午9:35
 */
public class TimeUtil {

	public static String getSystemTimeFormart(){

		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String eva_time = simple.format(System.currentTimeMillis());

		return eva_time;
	}

	/**
	 *  @描述：
	 *  @return 	long类型当前系统时间   返回时间戳
	 */
	public static long timeMath(){
		return System.currentTimeMillis();
	}

	/**
	 *  @描述：
	 *  @return 	输出时间戳  long类型
	 * @throws ParseException
	 */
	public static long getRequestTimeStampLong(String time) throws ParseException{
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(time);
		long ts = date.getTime();
		//res = String.valueOf(ts);
		return ts;
	}




	public static void main(String[] args) {
		TimeUtil t = new TimeUtil();
		System.out.println(t.timeMath());


	}


}
