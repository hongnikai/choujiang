package com.lc.util;

import java.util.Random;

public class Constants {
	
	public static final String SPEADER = System.getProperty("file.separator");

	public static final Integer sun = 10;
	
	public static final String orUrl = "http://qr.topscan.com/api.php?w=200&m=0&";
	
	public static String getRandom4() {
		Random random = new Random();
		String result = "";
		for (int i = 0; i < 4; i++) {
			result += random.nextInt(10);
		}
		return result;
	}
	
	/**
	 * 失败
	 */
	public static final String FAILED = "1";

	/**
	 * 成功
	 */
	public static final String SUCCESS = "0";
	
	/**
	 * 域名地址
	 */
	public static final String URL = "http://www.kongtiaoguanjia.com/air";
	
	/**
	 *  阿里大鱼
	 */
	public static final String aLiAppKey = "LTAIcMHwv0ZOxnzg";
	public static final String aLiSecret = "FReNHZR8WWwUip469Z9aX8NYKEcrOS";
	public static final String REGISTID = "SMS_105460048";// 用户验证,短信模板Id

	
	/**
	 * 极光推送
	 */
	public static final String jPushKey = " 16397fbec60e467203808f98";
	public static final String jPushSecret = "3e2d5d881820c0bbd095b969";
	
	
	/**
	 * 支付宝支付
	 */
	/*public static final String ALPayAppId = "2017102509514571";
	public static final String ALPublicKey= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr/oczO/Or7SVg47+gutbplg45IlXiPdfBplxN/yGon+T4xCA6HfJ3zQb5e7ra9nDnK5PufhXg9SBSKjHDkk0lgHU18nDLwv2L+gC/9+HGxKi5ju8DfbTRb5AFvh0pbSoXaaurVT/z3ywNiaHj1yOJX+66gvonB7/XbEDVpkqQUYVtJlj/cl2wq0GKyv/DUDPrKRHEYU0hzNPp/Kgt2r9mRbt78Z+TOp555ZudXeUyBMBQGkeKCtV3d1FSNsmVNTVFhVFy70a/Jaeyw/MXDZdcYub3az6IpoG+CZZL53E50QUDfucoGwaALQRD/2JXcsaE816sZrl/ObeWTPyp5SwYQIDAQAB";
	public static final String ALNotifyURL = URL+"/pay/ALPaySuccess.action";
	public static final String ALAppPrivateKey ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCv+hzM786vtJWDjv6C61umWDjkiVeI918GmXE3/Iaif5PjEIDod8nfNBvl7utr2cOcrk+5+FeD1IFIqMcOSTSWAdTXycMvC/Yv6AL/34cbEqLmO7wN9tNFvkAW+HSltKhdpq6tVP/PfLA2JoePXI4lf7rqC+icHv9dsQNWmSpBRhW0mWP9yXbCrQYrK/8NQM+spEcRhTSHM0+n8qC3av2ZFu3vxn5M6nnnlm51d5TIEwFAaR4oK1Xd3UVI2yZU1NUWFUXLvRr8lp7LD8xcNl1xi5vdrPoimgb4JlkvncTnRBQN+5ygbBoAtBEP/YldyxoTzXqxmuX85t5ZM/KnlLBhAgMBAAECggEBAKL6aSIEFs/z12T4Ug6+Gyt8GXTPHhrjv0ZFZe4MGkT1EuoApuKlznjBsfTJyY8hJ2E8run1blfRv8qjRXedpO4o1A7l9bbkxSSpI94GDwKrx+KjAA+OwSyefozHnoC5SBU0AiLVzfVD7Y65MGM9vQhNu7Z3QP8WVjtXbVgOkmvQCtX7vX/ONUlgfbLyKGlqnIhOIfVDhxf+t9QRJnPF15xfL55bIKxcHQcg2Ky5YzZrwWm11DoFBgp3d66nRj2Z9FXfK20HWhpkD5NjkHYu2iriwuv60VjlMOnSe4nrYbVQsqeKMtfu4n0/fVY/6wrAsbN6T1FkCMPY/uyPLJj+reECgYEA4tGHuHyN9l9NBZZHikOGinNzGjTdTIQ/Wcy59ttLojScXnU3tq7fiRTKrnWfFZERqYqYYsnX73Ztpa8u4KPb8Bd5fI9mWKqNwIvARsZYj5sVVFp5aRZU7Yqea4wXA6P6B3VP783Y4Vxp8B3Rv4pWMLVhaVhkCDLqLiNZ31Cb/jMCgYEAxp4Soj6cN9hEM+wdqxjw3505xRdX/K4z1aegNPUBg85VDm0d6sdSmkuifAUIgw/vuuNwCUd6K1L3FpUOAH/xxEyjio8p4s57jHWN7Zq6aERn+2ViEwGUc+TlRQMFRZiC3uim+ZOSVXCfUO/A0i7Hw1L3ekUw89KvX7ZiBFLomxsCgYEA3FmadIvsjpD/DpJ0Zco8Bn0qMSdyZkeEFAVkFIHu9GIQF2PhAETbPR1J2jrClf0dH4xZhn94nFZ9Jx0NeYc2wATOLUhSsYjftVMPNLK0jq6nBg/vKzxavXqRdQHfydWfrWc2hU2BiU5yTKdrgZ0vJprPS7xnUd/EyZXmVaDGKykCgYAF1kNp7TkeEwb+F6RPkO4TREWcWzFExcHUN5bnt4OR4hBx2hcU/UKaMjrWNjen0mITNffm7ejTOR711O+SaDAsuqvbuJVciwDqgdHn97IeulPr+XDGajd4qHNscchH4VGHR4MQtpuIU0T7VfBuvN02Ckwnlbz4jWqF/5Al3GHlnQKBgH6gqEfv1qpOEBeHZ9KE8WGdznsFYApwIuUmTFMeHt8CPCCdiX+SoXGF1HnhMPLGxit1PrucebcoSOr4dxBFcxbR3Zk77LhiEL8mufFKKeso8vDdEKOVnnSR47Amz5P5DU8+5ty2PLK1atDxAa/TAihpXKNvGfANkHbvgGuijDbM";
	*/
	public static final String ALPayAppId = "2017102609527788";
	public static final String ALPublicKey= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgFDqN30tncS/38q+N8NUl7R/nnciVjTwk0B+HOVUV1UOtShB3T2Xe6tIuMn6RPD2HVT1J8LJTiYz9Shr8MHtF3ZxQOflCDICF3WafelY2HvQ4iVPAFwgzlP3D6DYDynXZpOzytm+H/pKMZuAltfxuAlvuzjVpX54/Yb0TqRAPLvKOM3ECDJdg8OAbRun0yFbUPyB8QbXISyu1nYBWTZyp+Byq0P7DBwJjhwzXnc1KJvZhtrsoJqGZ208IBv3vIkl6f89QS+C0KF+Lso7pkusyOzbn8JTROJBwdZQXZZKXrGTOV/fsQrdahAIRqCiGadkPYO0B+8mGrJ2kfpePmA1MwIDAQAB";
	public static final String ALNotifyURL = URL+"/pay/ALPaySuccess.action";
	public static final String ALAppPrivateKey ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCopAVcbE7LgWi/cDBsrgMpQakQ+kBE/gApybDj95Agt4m+wy4gH+OmRik5Lmr7T0Tl63AKBSNuX3IS89Lv6BhemWXp8m6HTUj0pIQBhnWexsMz5Ay4HDC/2iWNw9L9RegnmP+Vpe3t63eQA+5YuwP1TtKTEbLVwtUHLF5Ex+7T3XrmWw1v+FNZFSj2SEK9K7GlBWMcrhLnODdo8zFh/71Li8EtpY5b1gL2tLrisfyc8+BKDfZA6h5A1BNSJA5mKY/dL6bYyp/+uvOUo2trM7nvx3mABhlfEC0TeHvQArIzECzAHf2bZPiEgtw1AhDggSWWSNUfLlS3cVuut3AowfZnAgMBAAECggEBAKYGvQRt2PE/mWmHwRTuCEywyQre5TFHQ8/gMldtXibnqyP0sk+MNap4PpN+IHMEapdVQDuNLYG3U+5Wv9/TB1LzAMPfGnP4YZAA+7kosFm942YN6XvEvTXURc6Y8PrKvTFmzpF9B46JmG9ff2M50z7J+EQ0U3Vh2Cq0wqZCk91d/I9DtIstm1O7cfpsvWsHO1JzxQ2NQcll5WIffYBQ2RybCmii0gVNcvev7bQtTL6timnADTnERQJQjpGkTDwoiof4BQGUNE3TCKppMsaDh+vletiI/GTCc76sV0FgddDdGOVkTVnNwOeRRzrYsAdgLBU0WzhzihbGLbPC62qAWCECgYEA8dG/8M26YxrPjnjeg8wMtkTr4VoLtt8w0cJvfd8YHGpO7ApceqEX0xqWCrpDj302/L5SVLHvCaS6ozn2wVAWsYi9mDbM9QFxboXUluUrp5By+ZLav/7WAziBT7pVcF29VXMluNS1dFnK84PT7Kos8HoqB7A6E1lx6ZXz+lXycpcCgYEAsoeyKTY6iDuMBv/D2lwPU/WjT6CK4Zr5VBbeSxIBp6SZQZGE6EpkQw0S4vnPlGZ8GpexlsRgShykhqyAhSjw5fQpwwSXZJovQW8/VWVG5gkdRDFRuJX5aqOy9rhgn82TNLzyCVLcLozxKuqf+7Ol4HUcMaqNzJq9ATEsn5oIpLECgYA/jaisWOVLdphmEU4pxU7x+Fsl9sxtW2sxNbCnnCJyFV54mqCDeiMQ0EPuvdVTuMzi0AJDUCBKoIiMrYc0dx//uLhbcMuc+KwfJ/0fS0uV1ljhTr8/BnKolgkmMwqRZZGFC6Y2VXD7Cz5Tkan44SC+ctzo+F/LBg7yHP7qI/x8MQKBgDc51Ln85XRY/0L3AW3dxnwRY1hxcCTD3NbPUCpmwo5KU4I98qAsywEW3T3LSxQ7864CONRLoQGsBJUIbaVDeemYcwa5t99N9spGEJBpCNqF/UCoBQCVnBcJ1oWNmY41eJD61eBeenAH915wP9cLxoc9kuAmQ0EEqOziekxQyNWxAoGBANKwpANX3fPwr1iOJGXEDqjlm/GdGQD/mWOoQba6sb3RADwfRL38Bh99qLhfBVrgikYATeMNENr8VYH4AiyjOJh9wWw3a3kn2bYQagdFCzWUS0h0QCbJ7peJydK6lvJi6ma03ep4lQo1uPI03pK5slOgNTtyNZF/PX/S9psU8YFD";
	
	
	
	/**
	 * 微信公众平台支付
	 */
	public static final String GZ_WXApiKey = "336fbe49696b85f2d85204b7567a46db";//apiKey
	public static final String GZ_WXMchid = "1498909912";//商户号
//	public static final String GZ_WXAppid = "wx939dc2bcf784af5a";//appId
//	public static final String GZ_WXAppSerect = "anhuiduiduileSHENGYIxinglongdaji";
	public static final String GZ_WXNotifyUrl = URL+"/payController/weixinNotify.do";//异步通知地址
	public static final String GATEURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
									   
	/**
	 * 微信开放平台APP支付
	 */
	public static final String WXApiKey = "9ce5c0de5eabbd6d3737f4a773b87162";//商户平台API密钥
	public static final String WXMchid = "1491851242";
	public static final String WXNotifyUrl = URL+"/pay/app/tenpay/notify.action";//异步通知地址
	
	/**
	 *	app(微信开放平台)
	 */
	public static final String AppID = "wx8d939e7aa2822024";
	public static final String AppSecret = "9ce5c0de5eabbd6d3737f4a773b87162";
	
	/**
	 * 微信公众号
	 */
	public static final String GZ_AppID = "wx2e41b2b702627f02";
	public static final String GZ_AppSecret = "226fbe49696b85f2d85204b7567a46db";
	
	/**
	 * 微信小程序
	 */
	public static final String XCX_AppID = "wx2907f67feb4f299d";
	public static final String XCX_AppSecret ="8b58493dfe5afa79385d92183c817408";
	
}
