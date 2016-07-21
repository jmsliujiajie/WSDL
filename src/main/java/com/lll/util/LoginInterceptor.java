package com.lll.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	/**
	 * This implementation always returns <code>true</code>.
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getRequestURL() + "--1111");
		System.out.println(request.getRequestURI() + "--2222");
		String a = request.getParameter("a1");
		System.out.println(a + "asasdadasdasdasda");

		return true;
	}

	/**
	 * This implementation is empty.
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
