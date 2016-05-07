package com.lll.axisWs;

import net.sf.json.JSONObject;

public class WsMessage {
	public static final String RET_CODE = "retCode";
	public static final String RET_MSG = "retMsg";
	public static final String RET_DATA = "retData";
	
	
	private String retCode;
	private String retMsg;
	private String retData;
	private JSONObject retJsonObj;
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public String getRetData() {
		return retData;
	}
	public void setRetData(String retData) {
		this.retData = retData;
	}
	public JSONObject getRetJsonObj() {
		return retJsonObj;
	}
	public void setRetJsonObj(JSONObject retJsonObj) {
		this.retJsonObj = retJsonObj;
	}
	
	
}
