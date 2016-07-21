package com.lll.security.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;


/** 
* @description MyInvocationSecurityMetadataSource
* @20130501
*/
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private static final Logger logger = Logger.getLogger(MyInvocationSecurityMetadataSource.class);  
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	
	public MyInvocationSecurityMetadataSource(DbSecurityInfo dbSecurityInfo) {
		resourceMap = dbSecurityInfo.loadResourceDefine();
	}


	// According to a URL, Find out permission configuration of this URL.
	public Collection<ConfigAttribute> getAttributes(Object object)	throws IllegalArgumentException {
		// guess object is a URL.
		String url = ((FilterInvocation) object).getRequestUrl();
		logger.debug("url 是：" + url);
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			logger.debug("resURL 是：" + resURL);
			if (urlMatcher.pathMatchesUrl(url, resURL)) {
				logger.debug("resURL 是：" + resURL);
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}


}