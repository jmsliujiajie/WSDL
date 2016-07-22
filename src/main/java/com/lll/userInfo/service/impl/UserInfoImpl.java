package com.lll.userInfo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lll.userInfo.dao.UserInfoDao;
import com.lll.userInfo.service.IUserInfo;
@Service
public class UserInfoImpl implements IUserInfo {
	@Autowired
	private UserInfoDao userInfoDao;
	@Override
	public boolean addUserInfo(Map<String, Object> inMap) {
		return userInfoDao.addUserInfo(inMap);
	}
	@Override
	public Map<String, Object> queryUserInfo(Map<String, Object> inMap) {
		return userInfoDao.queryUserInfo(inMap);
	}

}
