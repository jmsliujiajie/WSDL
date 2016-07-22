package com.lll.userInfo.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserPointsInfoDao extends SqlSessionDaoSupport{

	public boolean addPointsInfo(Map<String, String> inMap){
		return this.getSqlSession().insert("UserPointsInfoMapper.insert", inMap) == 1 ? true : false;
	}
}
