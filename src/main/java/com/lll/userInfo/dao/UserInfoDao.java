package com.lll.userInfo.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserInfoDao extends SqlSessionDaoSupport{

	public boolean addUserInfo(Map<String, Object> inMap){
		return this.getSqlSession().insert("UserInfoMapper.insert", inMap) == 1 ? true : false;
	}
	
	public Map<String, Object> queryUserInfo(Map<String, Object> inMap){
		return this.getSqlSession().selectOne("UserInfoMapper.query", inMap);
	}
}
