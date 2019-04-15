package com.lc.util;

//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SendVerificodeUtil {
	
	public static String aLiAppKey = "23531363";
	public static String aLiSecret = "0b904aa8f96ae609d257521161e99920";
	
	public static void sendVerificode(String mobile, String code)  {
//		try {
//			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", aLiAppKey, aLiSecret);
//			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//			req.setExtend( "" );
//			req.setSmsType( "normal" );
//			req.setSmsFreeSignName( "普易网科技" );
//			req.setSmsParamString( "{code:'"+code+"'}" );
//			req.setRecNum( mobile );
//			req.setSmsTemplateCode( "SMS_31730058" );
//			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
//		} catch (ApiException e) {
//			e.printStackTrace();
//		}
//



	}
	
}
