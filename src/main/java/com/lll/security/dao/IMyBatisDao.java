package com.lll.security.dao;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lll.util.orm.MyBatisPage;

public interface IMyBatisDao {
	public boolean saveAndReturnFlag(String key,Object object);
	public boolean deleteByIdAndReturnFlag(String key,Serializable id);
	public boolean deleteByOjbAndReturnFlag(String key,Object object);
	public boolean updateByObjAndReturnFlag(String key,Object object);
	public <T> T get(String key,Object params);
	public <T> List<T> getList(String key);
	public <T> List<T> getList(String key,Object params);
	public int getCount(String key,Map<String, Object> conditions);
	public void initPage(String key,MyBatisPage page,Map<String, Object> conditions);
	public <T> List<T> getPageList(String key,MyBatisPage page,Map<String, Object> conditions);

}
