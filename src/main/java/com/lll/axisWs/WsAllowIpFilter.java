package com.lll.axisWs;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.lll.util.JSONTool;

public class WsAllowIpFilter implements Filter {

	// 不允许访问webservice服务的IP地址，在init方法中初始化
	private static ArrayList<String> deniedIPList = new ArrayList<String>();
	private static Logger logger = Logger.getLogger(WsAllowIpFilter.class);
	private static final String markLine = "log4jMarkLine";

	public boolean isIPDenied(String ipAddr) {
		
		boolean retB = false;
		for (String clientIpAddr : deniedIPList) {
			System.out.println(ipAddr + "-------ipAddr--clientIpAddr------" + clientIpAddr);
			if (clientIpAddr.equals(ipAddr)) {// 找到了
				retB = true;
				break;
			}
		}
		return retB;
	}

	public void destroy() {
		System.out.println("------------WsAllowIpFilter------------destroy----------------");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("------------WsAllowIpFilter------------doFilter----------------");
		HttpServletRequest request = (HttpServletRequest) req;
		//String clientIP = request.getRemoteHost();
		//此处应该是
		String clientIP = request.getRemoteAddr();
		System.out.println("clientIP：" + clientIP);
		logger.info("log4j日志 -- clientIP：" + clientIP);
		System.out.println("start...");

		if (!isIPDenied(clientIP)) {
			System.out.println("-------------isIPDenied--------------------false-----");

			// --------------记日志，查看非法访问记录--------------------
			StringBuffer sb = new StringBuffer();
			String oprDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			String loginNo = "";
			String serverIp = getLocalIP();
			String function_code = "WS01";
			String retCode = "NOTALLOW";
			String retMsg = "不被允许的访问";
			String loginAccept = "-1";
			String excepStackTrace = "org.apache.axis2.AxisFault: First Element must contain the local name, Envelope , but found html";
			String operMemo = "非法访问者记录日志";

			sb.append(markLine);
			sb.append("{");
			sb.append("\"loginNo\":\"" + loginNo + "\",");
			sb.append("\"clientIp\":\"" + clientIP + "\",");
			sb.append("\"serverIp\":\"" + serverIp + "\",");
			sb.append("\"functionCode\":\"" + function_code + "\",");
			sb.append("\"retCode\":\"" + retCode + "\",");
			sb.append("\"retMsg\":\"" + retMsg + "\",");
			sb.append("\"oprDate\":\"" + oprDate + "\",");
			sb.append("\"loginAccept\":\"" + loginAccept + "\",");
			sb.append("\"excepStackTrace\":\"" + excepStackTrace + "\",");
			sb.append("\"operMemo\":\"" + operMemo + "\"");
			sb.append("}");
			logger.info(sb.toString());

			throw new ServletException("你没有权限调用此webservice！");
		} else {
			System.out.println("-------------isIPDenied--------------------true-----");
			chain.doFilter(req, res);
		}

	}

	/**
	 * 初始化的时候取得可以访问的IP数组
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("------------WsAllowIpFilter------------init----------------");
		// 读取配置文件
		String deniedIPJson = ResourceBundle.getBundle("sys_config").getString("DENIEDIPJSON");
		System.out.println(deniedIPJson);
		ArrayList<HashMap<String, String>> deniedIPListMap = JSONTool.getListMap_F_JsonStr(deniedIPJson);
		for (HashMap<String, String> hashMap : deniedIPListMap) {
			String clientIP = hashMap.get("clientIP");
			deniedIPList.add(clientIP);
		}
	}

	public String getLocalIP() {
		InetAddress addr = null;
		String ipAddrStr = "";
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			return "";
		}
		byte[] ipAddr = addr.getAddress();
		for (int i = 0; i < ipAddr.length; i++) {
			if (i > 0) {
				ipAddrStr += ".";
			}
			ipAddrStr += ipAddr[i] & 0xFF;
		}
		return ipAddrStr;
	}
}
