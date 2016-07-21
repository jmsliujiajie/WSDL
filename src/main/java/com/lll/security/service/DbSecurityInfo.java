package com.lll.security.service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Component;

import com.lll.security.dao.MyBatisDao;

/** 
* @description 加载security时，将资源的path加载进去
* @20130501
*/
@Component
public class DbSecurityInfo {
	
	@Autowired
	private MyBatisDao dao;
	
	public Map<String, Collection<ConfigAttribute>> loadResourceDefine(){
		Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		
		return resourceMap;
	}


}
