package com.lll.userInfo.service;

import java.util.Map;
public interface IUserInfo {

	public boolean addUserInfo(Map<String, Object> inMap);
	
	public Map<String, Object> queryUserInfo(Map<String, Object> inMap);
}
