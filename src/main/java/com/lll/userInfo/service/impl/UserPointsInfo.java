package com.lll.userInfo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lll.userInfo.dao.UserPointsInfoDao;
import com.lll.userInfo.service.IUserPointsInfo;

@Service
public class UserPointsInfo implements IUserPointsInfo {
	
	@Autowired
	private UserPointsInfoDao dao;
	
	@Override
	public boolean addPointsInfo(Map<String, String> inMap) {
		return dao.addPointsInfo(inMap);
	}

}
