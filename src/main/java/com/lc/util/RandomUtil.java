package com.lc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

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
 *    @Date: 2017/12/7 13:19
 *    @Description: 
 */
public class RandomUtil{
    /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }
    public static String getSimpleDate(){
        Date d  = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(d);
    }
    public static String getRandomId(int length){
        if(length > 13){
            String ID = UUID.randomUUID().toString().replaceAll("-", "");
            ID = ID.substring(0, length-14);
            return getSimpleDate()+ ID;
        } else {
            return UUID.randomUUID().toString().substring(0, length);
        }
    }
    /**
     * 产生8位随机数(0000-9999)String 类型
     * @author lc
     * @return 8位随机数
     */
    public static String getEightRandom(){
    	 Random random = new Random();
         String Random = random.nextInt(10000) + "";
         int randLength = Random.length();
         if(randLength<8){
             for(int i=1; i<=8-randLength; i++)
                 Random = "0" + Random  ;
         }
    	return Random;
	}

}
