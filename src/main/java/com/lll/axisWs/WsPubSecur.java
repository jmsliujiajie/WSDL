package com.lll.axisWs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;

import com.lll.util.Constants;

/**
 * webservice 公用处理类，包括参数加、解密，接入ip限制等
 */

public class WsPubSecur {
	public static String OK = "OK";
	public static String FAIL = "FAIL";
	public static String MSG_FAIL_PARAM = "服务端解析参数错误";
	
	public static String PAGO_DATA = "PAGO_DATA";//分页使用的key
	public static String LIST_DATA = "LIST_DATA";//普通列表
	

	/**
	 * 获取客户端IP地址
	 * @return
	 */
	public String getRemoteIp() {
		MessageContext messageContext = MessageContext.getCurrentContext();
		HttpServletRequest request = (HttpServletRequest) messageContext.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
		String remoteIp = request.getRemoteAddr();
		return remoteIp;
	}

	
	/**
	 * 为ESB等平台留的接口，不加密，返回明文
	 * 参数加密
	 */

	public String encrypt(String jsonStr,String ESBFlag) {
		if(Constants.ESB.equals(ESBFlag)){ 
			return ThreeDesSecret.encrypt(jsonStr);
		}else{
			return null;
		}
	}

	/**
	 * 为ESB等平台留的接口，不加密，返回明文
	 * 参数解密
	 */
	public String decypt(String jsonStr,String ESBFlag) {
		if(Constants.ESB.equals(ESBFlag)){ 
			return ThreeDesSecret.decypt(jsonStr);
		}else{
			return null;
		}
	}
	
	
	/**
	 * 参数加密
	 */

	public String encrypt(String jsonStr) {
		return ThreeDesSecret.encrypt(jsonStr);
	}

	/**
	 * 参数解密
	 */
	public String decypt(String jsonStr) {
		return ThreeDesSecret.decypt(jsonStr);
	}

	/***
	 * 设置分页数据
	 * @param actPago
	 * @return
	 */
	public Map<String, Object> getPagoJson(Pago<HashMap<String ,String >> actPago) {

		Map<String, Object> pagoJson = new HashMap<String, Object>();// 设置分页数据
		pagoJson.put("pageNo", actPago.getPageNo()); // 第[ ]页
		pagoJson.put("totalPages", actPago.getTotalPages());// 共[ ]页
		pagoJson.put("pageSize", actPago.getPageSize()); // 每页[ ]条
		pagoJson.put("totalCount", actPago.getTotalCount());// 共[ ]条
		pagoJson.put("nextPage", actPago.getNextPage()); // 下一页
		pagoJson.put("prePage", actPago.getPrePage()); // 上一页
		pagoJson.put("totalPages", actPago.getTotalPages());// 尾 页
		pagoJson.put("hasNext", actPago.isHasNext());
		pagoJson.put("hasPre", actPago.isHasPre());
		return pagoJson;
	}

}
