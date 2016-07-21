package com.lll.axisWs;

//http://127.0.0.1:8008/HallCMS/services/hallCMSWs
import java.util.ResourceBundle;

import javax.xml.namespace.QName;

import net.sf.json.JSONObject;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class WebServiceClient extends WsPubSecur {

	//超时时间毫秒数
	private final static long TOMS = 60*1000*15;//15分钟
	private static String HALLCMS_WS_ADDR = "http://127.0.0.1:8080/esbWS/services/";
	
	/** ----------------调用发送短信接口------------------- */
	public static String QN_safetyReport = "http://safetyReport.sitech.com";//命名空间
	public static String SN_safetyReport = "SAFETYREPORT";//service name 
	
	 
	
	public static String runClinet(String qName, String serverName,String funcName, String pin) {
		JSONObject jsonObject = new JSONObject();
		String outJsonParam = null; //
		System.out.println("入参：" + pin);
		try {
			// 创建一个RPC的客户端实例
			RPCServiceClient rpcServiceClient = new RPCServiceClient();
			// 拿到相关的配置
			Options options = rpcServiceClient.getOptions();
			String targetWsAddr = HALLCMS_WS_ADDR+serverName;
			System.out.println("targetWsAddr = ["+targetWsAddr+"]");
			// 创建一个远程的访问地址
			EndpointReference target = new EndpointReference(targetWsAddr);

			options.setTo(target);
			//设置超时时间
			options.setTimeOutInMilliSeconds(TOMS);
			// 创建一个Qname的命名空间,默认的是域名倒过来写,第二个参数的写方法名
			QName arg0 = new QName(qName, funcName);
			//String jsonParamArr[] = new String[] { jsonParamDes,"ESB" };//给ESB平台使用的参数2个，返回明文
			String jsonParamArr[] = new String[] { pin};//前后台调用的入参参数，返回加密串
			// 出参数组的实例
			@SuppressWarnings("rawtypes")
			Class[] getJsonObj = new Class[] { String.class };
			// 返回的数组实例.
			Object[] response = rpcServiceClient.invokeBlocking(arg0, jsonParamArr, getJsonObj);
			// 拿到请求的对象，转为字符串既是json串
			String outJsonParamDes = response[0].toString();
			System.out.println("加密出参：" + outJsonParamDes);
			rpcServiceClient.cleanup();
			// 解密出参
			System.out.println("出参：" + outJsonParam);
			if (outJsonParam == null) {
				jsonObject.put("retCode", "SYSERR07");
				jsonObject.put("retMsg", "获取服务出参错误！");
				outJsonParam = jsonObject.toString();
			}
		} catch (AxisFault e) {
			System.out.println("e.getMessage()[" + e.getMessage()+"]");
			e.printStackTrace();
			
			if(e.getMessage().indexOf("Connection refused")!=-1){
				jsonObject.put("retCode", "SYSERR03");
				jsonObject.put("retMsg", "调用服务网络地址错误或网络不通！");
				outJsonParam = jsonObject.toString();
			}else if(e.getMessage().indexOf("timed out")!=-1){
				jsonObject.put("retCode", "SYSERR04");
				jsonObject.put("retMsg", "调用服务网络超时！");
				outJsonParam = jsonObject.toString();
			}else if (jsonObject.size() == 0) {
				jsonObject.put("retCode", "SYSERR05");
				jsonObject.put("retMsg", "调用服务系统错误！");
				outJsonParam = jsonObject.toString();
			}else{
				jsonObject.put("retCode", "SYSERR06");
				jsonObject.put("retMsg", "未知系统错误！");
				outJsonParam = jsonObject.toString();
			}
		}
		System.out.println("---------outJsonParam---------"+outJsonParam);
		return outJsonParam;
	}

}
