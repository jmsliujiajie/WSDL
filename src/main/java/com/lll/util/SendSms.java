package com.lll.util;


import javax.servlet.http.HttpServlet;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


public class SendSms extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    public static final String URL = Constants.getConstant(Constants.SEND_MESSAGE_URL);

	public static String getXMLString(String phoneNo,String conent) {
		// A StringBuffer Object
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='GBK'?>");
		sb.append("<message>");
		sb.append("  <head>");
		sb.append("	    <menuid></menuid>");
		sb.append(" 		<process_code>cli_busi_SendSMSInfo</process_code>");
		sb.append(" 		<verify_code></verify_code>");
		sb.append(" 		<req_time>"+DateUtils.getFullDateTimePattern()+"</req_time>");
		sb.append(" 		<req_seq></req_seq>");
		sb.append(" 		<unicontact></unicontact>");
		sb.append(" 		<testflag></testflag>");
		sb.append(" 		<route>");
		sb.append(" 			<route_type>1</route_type>");
		sb.append(" 			<route_value>"+phoneNo+"</route_value>");
		sb.append(" 		</route>");
		sb.append(" 		<channelinfo>");
		sb.append(" 			<operatorid></operatorid>");
		sb.append(" 			<channelid>bsacNB</channelid>");
		sb.append(" 			<unitid>bsacNB</unitid>");
		sb.append(" 		</channelinfo>");
		sb.append("  </head>");
		sb.append("   <Body>");
		sb.append("   	<cli_busi_SendSMSInfo>");
		sb.append("    		<tagset>");
		sb.append("  				<ISRVCALL>0</ISRVCALL>");
		sb.append("   			<SMPARAM>"+conent+"</SMPARAM>"); 
		sb.append("   			<TEMPLATENO>SHOPCHANNEL</TEMPLATENO>"); 
		sb.append("   			<TELNUM>"+phoneNo+"</TELNUM>"); 
		sb.append("   			<DISPPORT>10086224</DISPPORT>"); 
		sb.append("  				<process_code>cli_busi_SendSMSInfo</process_code>");
		sb.append("  			</tagset>");
		sb.append("    </cli_busi_SendSMSInfo>");
		sb.append("   </Body>");
		sb.append("</message>");
		// return to String Formed
		return sb.toString();
	}

	public static String sendMsg(String phoneNo,String conent){
		
	    String ret = "";
	    try {
			HttpClient client = new DefaultHttpClient();

			HttpPost post = new HttpPost(URL);  

			StringEntity entity = null;

			entity = new StringEntity(getXMLString(phoneNo,"1" + conent), "GBK");

			post.setEntity(entity);  

			ResponseHandler<String> response = new BasicResponseHandler();  
			ret = client.execute(post, response);  
			//retCode ="100";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) {  

		try {  
//			System.out.println(sendMsg("13995557958", "1内容"));
		} catch (Exception e) {  
			e.printStackTrace();  
		}   


	}  

}