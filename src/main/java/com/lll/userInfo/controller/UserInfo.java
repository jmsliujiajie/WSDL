package com.lll.userInfo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lll.axisWs.WsPubSecur;
import com.lll.userInfo.service.IUserInfo;
import com.lll.util.JSONTool;

public class UserInfo extends WsPubSecur {

	@Autowired
	private IUserInfo userInfo;

	public String addUserInfo(String jsonStr) {

		String jsonDec = decypt(jsonStr);
		Map<String, Object> inParam = JSONTool.getMap_F_JsonStr_Object(jsonDec);
		
		try {
			byte[] buffer = String.valueOf(inParam.get("IMAGE")).getBytes("ISO-8859-1");
			inParam.put("IMAGE", buffer);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		Boolean flag = userInfo.addUserInfo(inParam);
		
		String result = "";
		
		if (flag) {
			result = "success";
		} else {
			result = "false";
		}
		return encrypt(result);
	}
	
	public String doLogin(String jsonStr){
		
		String jsonDec = decypt(jsonStr);
		
		Map<String, Object> inParam = JSONTool.getMap_F_JsonStr_Object(jsonDec);
		
		Map<String, Object> userInfoMap = userInfo.queryUserInfo(inParam);
		
		String result = "";
		
		if(userInfoMap != null){
			result = "success";
		}else{
			result = "false";
		}
		
		return encrypt(result);
	}

	public IUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(IUserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
