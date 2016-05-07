package com.lll.sysLogManage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;


public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String servHome;
	private static String logFileName;
	private static String dateFormat;
	
	public void init() {
		String prifix   = getServletContext().getRealPath("/");
		String file     = getInitParameter("log4j-init-file");
		if (file != null) {
			Properties prop = new Properties();

			try {
				prop.load(new FileInputStream(prifix + file));
				servHome    = System.getProperty("user.dir");
				logFileName = prop.getProperty("log4j.appender.File.File").replace("./logs/", "").trim();
				dateFormat  = prop.getProperty("log4j.appender.File.DatePattern").trim();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static String getServHome() {
		return servHome;
	}

	public static void setServHome(String servHome) {
		Log4jInit.servHome = servHome;
	}

	public static String getLogFileName() {
		return logFileName;
	}

	public static void setLogFileName(String logFileName) {
		Log4jInit.logFileName = logFileName;
	}

	public static String getDateFormat() {
		return dateFormat;
	}

	public static void setDateFormat(String dateFormat) {
		Log4jInit.dateFormat = dateFormat;
	}
 
}
