package com.lll.userInfo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lll.axisWs.WsPubSecur;
import com.lll.userInfo.service.IUserPointsInfo;
import com.lll.util.JSONTool;

public class UserPointsInfo extends WsPubSecur{

	@Autowired
	private IUserPointsInfo pointsInfo;
	
	public String addPointInfo(String jsonStr){ 
		
		String jsonDec = decypt(jsonStr);
		Map<String, String> inMap = JSONTool.getMap_F_JsonStr(jsonDec);
		
		boolean flag = pointsInfo.addPointsInfo(inMap);
		
		String result = "";
		
		if(flag){
			result = "succes";
		}else{
			result = "false";
		}
		return encrypt(result);
	}
}
