package com.lll.util;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainServlet extends HttpServlet {

	/** 
	* 
	*/
	private static final long serialVersionUID = 1L;
	protected final transient Log log = LogFactory.getLog(MainServlet.class);
	public MainServlet() {
		super();
	}

	public void init() throws ServletException {

	}

	public void destroy() {
		super.destroy();
	}
}
