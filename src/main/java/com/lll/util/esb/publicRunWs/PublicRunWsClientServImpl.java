/***
 *  2013年6月13日16:32:41
 *  读取配置文件中的IP和端口
 *  调用的服务均为参数
 *  
 *  author：何敬伟
 */

package com.lll.util.esb.publicRunWs;

import java.rmi.RemoteException;
import java.util.ArrayList;
import org.apache.axis2.AxisFault;
import org.apache.log4j.*;

import com.lll.util.esb.PublicRunWsClientInterface;
import com.lll.util.esb.SdCrmSysUtil;
import com.lll.util.esb.publicRunWs.PublicRunWsStub.SrvReturnBean;
import com.lll.util.esb.publicRunWs.PublicRunWsStub.TxdoBuf;

public class PublicRunWsClientServImpl  implements PublicRunWsClientInterface{
	private static Logger sysLog = Logger.getLogger("console" );
	public static void main(String[] args ) throws AxisFault {
		
		//测试返回出参为一维数组
//		String esbIp =  new SdCrmStaticVar().ESB_IP_PORT;
//		String servName = "sMainCodeQryWS";
//		String serverPath = "http://"+esbIp+"/esbWS/services/"+servName+"?wsdl";
//		String param[] = new String[] {"1", "01", "11", "aaaaxp",	"abc123", "15045695882", "" };
//		ArrayList al = new PublicRunWsClientServImpl().invokESBServer(serverPath,param);
//		
//		String result[][] = (String[][]) al.get(2 );
//		String retCode    = (String) al.get(0 );
//		String retMsg     = (String) al.get(1 );
//		
//		System.out.println("--------retCode---------------"+retCode);
//		System.out.println("--------retMsg----------------"+retMsg);
//		
//		for(int i = 0; i < result.length; i++ ) {
//			for(int j = 0; j < result[i].length; j++ ) {
//				System.out.println("result["+i+"]["+j+"]="+result[i][j]);
//			}
//		}
		
		
//		//测试返回出参为二维数组
//		String esbIp =  System.getProperty("ESB_IP_PORT");
		String esbIp =  "10.110.26.23:61000";
		String servName = "s3068QueryWS";
		String serverPath = "http://"+esbIp+"/esbWS/services/"+servName+"?wsdl";
		System.out.println("serverPath = "+serverPath);
		String param[] = new String[] { "15045695882","aaaaxp",	"abc123"};
		
		ArrayList al = new PublicRunWsClientServImpl().invokESBServer(serverPath,param,0);
		
		String result[][] = (String[][]) al.get(2 );
		String retCode    = (String) al.get(0 );
		String retMsg     = (String) al.get(1 );
		
		System.out.println("--------retCode---------------"+retCode);
		System.out.println("--------retMsg----------------"+retMsg);
		
		for(int i = 0; i < result.length; i++ ) {
			for(int j = 0; j < result[i].length; j++ ) {
				System.out.println("result["+i+"]["+j+"] = "+result[i][j]);
			}
			System.out.println();
		}
		
	}


	
	public ArrayList invokESBServer(String serverPath, String[] param ,int transFlag){
		/**
		 * 调用webservice服务返回二维数组，类似服务返回的二维数组
		 * 2013年6月13日17:02:42
		 * 
		 * 入参：
		 * 	serverName  =  调用的服务名称
		 *  param       =  调用的服务需要的入参
		 *  transFlag   =  返回数组转置标志，0=需要转置，否则不需要转置，服务集成平台返回的是转置后的数组
		 * 出参：
		 *  服务返回的二维数组， retCode，retMsg 装入 ArrayList
		 */
		sysLog.info("invokESBServer : serverPath=["+serverPath+"]");
		PublicRunWsStub stub          = null;
		String          resultArr[][] = new String[][]{};
		ArrayList       retArrayList  = new ArrayList();  //生产环境若支持jdk1.6直接使用泛型
		String          retCode       = "";
		String          retMsg        = "";
		
		try {
			stub                                         = new PublicRunWsStub(serverPath );
			PublicRunWsStub.CallService request          = new PublicRunWsStub.CallService();
			request.setParams( param);
			PublicRunWsStub.CallServiceResponse response = stub.callService(request );
			SrvReturnBean srb                            = response.get_return();
			
			retCode = srb.getRetCode();
			retMsg  = srb.getRetMsg();
			
			if(retCode!=null){//系统或调用IP端口等没有错误
				TxdoBuf[] tb = null;
				if(response.get_return()!=null){
					tb = srb.getRetMatrix();
				}
				 
				/**
				 * 由于服务集成平台把出参二维数组转置，还需要转回来，否则在智能终端也要进行转换
				 */
				
				String tempArr[][] = new String[tb.length][];
				for(int i = 0; i < tb.length; i++ ) {
					String tblb[] = tb[i].getBuffer(); // 第二行开始放返回出参数组
					tempArr[i]    = new String[tblb.length];
					for(int j = 0; j < tblb.length; j++ ) {
						
						tempArr[i][j] = tblb[j];
					}
				}
				if(transFlag==0){
					resultArr =  new SdCrmSysUtil().transArrays(tempArr ); // 数组转置
				}else{
					resultArr = tempArr;
				}
			}else{
				retCode   = "000444";
				retMsg    = "客户端调用服务集成平台失败";
			}
			
			
		}catch(AxisFault e ) {
			retCode   = "000445" ;
			retMsg    = "客户端程序运行异常：AxisFault" ;
			resultArr = new String[][]{};
			e.printStackTrace();
			
		}catch(RemoteException e ) {
			retCode   = "000446" ;
			retMsg    = "客户端程序运行异常：RemoteException" ;
			resultArr = new String[][]{};
			e.printStackTrace();
			
		}catch(Exception e ) {
			retCode   = "000447" ;
			retMsg    = "客户端程序运行异常：Exception" ;
			resultArr = new String[][]{};
			e.printStackTrace();
			
		}
		sysLog.info("retCode = ["+retCode+"],retMsg=["+retMsg+"],resultArr.length=["+resultArr.length+"]" );
		retArrayList.add(0, retCode   );
		retArrayList.add(1, retMsg    );
		retArrayList.add(2, resultArr );
		return retArrayList;
	}
}
