package com.lll.util;

/**
 * 初始化加载属性表信息的监听器
 */


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class InitSetupListener implements ServletContextListener {
	private Logger logger = LoggerFactory.getLogger(InitSetupListener.class);

	public static String rootPath;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
				
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		rootPath = arg0.getServletContext().getRealPath("/");
       logger.debug(rootPath);
		
	}
	
}
