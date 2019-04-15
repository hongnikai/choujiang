package com.lc.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.lc.bean.OAuthInfo;
import com.lc.bean.UserInfo;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;



@SuppressWarnings("ALL")
public class WeChatCommonUtil {
	// app第三方微信登录 参数配置
	public static String API_SECRET = Constants.AppSecret;
	public static String APPID = Constants.AppID;
	
	
	//公众号微信登录 参数配置
	public static String GZ_SECRET = Constants.GZ_AppSecret;
	public static String GZ_APPID = Constants.GZ_AppID;
	
	//小程序 微信登陆参数配置
	public static String XCX_AppID = Constants.XCX_AppID;
	public static String XCX_AppSecret = Constants.XCX_AppSecret;
	
	
	/**
	 * 获取授权Access Token(app第三方微信登录)
	 * @param code
	 * @return
	 */
	public static OAuthInfo getOAuthOpenId_App(String code) {
        OAuthInfo oAuthInfo = null;
        String o_auth_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        try {
			String requestUrl = o_auth_openid_url.replace("APPID", XCX_AppID).replace("SECRET", XCX_AppSecret).replace("CODE", code);
      
			JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
			System.out.println("==============授权access_token信息:"+jsonObject+"==============");
			// 如果请求成功
			if (null != jsonObject) {
			    try {
			        oAuthInfo = new OAuthInfo();
			        oAuthInfo.setOpenId(jsonObject.getString("openid"));
			        oAuthInfo.setAccessToken(jsonObject.getString("access_token"));
			    } catch (JSONException e) {
			        oAuthInfo = null;
			        System.out.println(e.getMessage());
			    }
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
        
        return oAuthInfo;
    }
	
	/**
	 * app获取用户信息(app第三方微信登录)
	 * @param access_token 授权得到的access_token
	 * @param openid  授权获取的openid
	 * @return
	 */
	public static JSONObject getUserInfo_App(String access_token,String openid ) {
		UserInfo userInfo = null;
		String userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        String requestUrl = userinfo_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);;
		System.out.println("==============requestUrl:"+requestUrl+"==============");

		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		System.out.println("==============用户信息:"+jsonObject+"==============");
		
		// 如果请求成功
		if (null != jsonObject) {
			try {
                //等一系列的信息
			} catch (JSONException e) {
				userInfo = null;
				// 获取token失败
				System.out.println(e.getMessage() );
			}
		}
		return jsonObject;
	}
	
	/**
	 * 获取授权Access Token(公众号)
	 * @param code
	 * @return
	 */
	public static OAuthInfo getOAuthOpenId(String code) {
        OAuthInfo oAuthInfo = null;
        String o_auth_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        try {
			String requestUrl = o_auth_openid_url.replace("APPID", GZ_APPID).replace("SECRET", GZ_SECRET).replace("CODE", code);
      
			JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
			System.out.println("==============授权access_token信息:"+jsonObject+"==============");
			// 如果请求成功
			if (null != jsonObject) {
			    try {
			        oAuthInfo = new OAuthInfo();
			        oAuthInfo.setOpenId(jsonObject.getString("openid"));
			        oAuthInfo.setAccessToken(jsonObject.getString("access_token"));
			    } catch (JSONException e) {
			        oAuthInfo = null;
			        System.out.println(e.getMessage());
			    }
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
        
        return oAuthInfo;
    }
	
	/**
	 * 获取全局Access Token(公众号)
	 * @return
	 */
	public static OAuthInfo getOAuth() {
        OAuthInfo oAuthInfo = null;
        try {
			String o_auth_openid_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
			String requestUrl = o_auth_openid_url.replace("APPID", GZ_APPID).replace("SECRET", GZ_SECRET);
      
			JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
			System.out.println("==============全局access_token信息:"+jsonObject+"==============");
			//oAuthInfo是作者自己把那几个属性参数写在一个类里面了。
			// 如果请求成功
			if (null != jsonObject) {
			    try {
			        oAuthInfo = new OAuthInfo();
			        oAuthInfo.setAccessToken(jsonObject.getString("access_token"));
			    } catch (JSONException e) {
			        oAuthInfo = null;
			        System.out.println(e.getMessage());
			    }
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
        
        return oAuthInfo;
    }
	
	/**
	 * 获取jsapi_ticket
	 * @param accessToken
	 * @return
	 */
	public static String getJsapiTicket (String accessToken){
		String o_auth_openid_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
		String requestUrl = o_auth_openid_url.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		System.out.println("==============获取jsapi_ticket信息:"+jsonObject+"==============");
		String ticket = null;
		// 如果请求成功
		if (null != jsonObject) {
		    try {
		    	ticket = jsonObject.getString("ticket");
		    	System.out.println("ticket值:"+ticket);
		    } catch (JSONException e) {
		        System.out.println(e.getMessage());
		    }
		}
		return ticket;
		
	}
	
	/**
	 * 网页授权获取用户信息(公众号)
	 * @param access_token 授权得到的access_token
	 * @param openid  授权获取的openid
	 * @return
	 */
	public static UserInfo getUserInfo(String access_token,String openid ) {
		UserInfo userInfo = null;
		String userinfo_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
        String requestUrl = userinfo_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);;
		System.out.println("==============requestUrl:"+requestUrl+"==============");

		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		System.out.println("==============用户信息:"+jsonObject+"==============");
		
		// 如果请求成功
		if (null != jsonObject) {
			try {
				userInfo = new UserInfo();
				String subscribe = jsonObject.getString("subscribe");
				userInfo.setSubscribe(subscribe);
				if (subscribe.equals("1")) {
					userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
					userInfo.setNickname(jsonObject.getString("nickname"));
					userInfo.setSex(jsonObject.getString("sex"));
					userInfo.setCity(jsonObject.getString("city"));
					userInfo.setCountry(jsonObject.getString("country"));
					userInfo.setProvince(jsonObject.getString("province"));
					userInfo.setSubscribe_time(jsonObject.getString("subscribe_time"));
					if (jsonObject.getString("unionid") != null) {
						userInfo.setUnionid(jsonObject.getString("unionid"));
					}
				}
				
				userInfo.setOpenid(jsonObject.getString("openid"));
				
				//等一系列的信息
			} catch (JSONException e) {
				userInfo = null;
				// 获取token失败
				System.out.println(e.getMessage() );
			}
		}
		return userInfo;
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
	
	/**
	 * 网页授权获取用户信息(小程序)
	 * @param access_token 授权得到的access_token
	 * @param openid  授权获取的openid
	 * @return
	 */
	public static OAuthInfo getOAuthOpenId_XCX(String code) {
		  OAuthInfo oAuthInfo = null;
	        String o_auth_openid_url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code="+ code +"&grant_type=authorization_code";
	        try {
				String requestUrl = o_auth_openid_url.replace("APPID", XCX_AppID).replace("SECRET", XCX_AppSecret).replace("CODE", code);
	      
				JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
				System.out.println("==============授权access_token信息:"+jsonObject+"==============");
				// 如果请求成功
				if (null != jsonObject) {
				    try {
				        oAuthInfo = new OAuthInfo();
				        oAuthInfo.setOpenId(jsonObject.getString("openid"));
				        oAuthInfo.setSession_key(jsonObject.getString("session_key"));
				    } catch (JSONException e) {
				        oAuthInfo = null;
				        System.out.println(e.getMessage());
				    }
				}
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
	        
	        return oAuthInfo;
    }
	
	
	
	
	
	
	
}
