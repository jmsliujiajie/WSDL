package com.lll.util;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


/** 
* @description 登录成功的业务方法
* 
*/
@Component
public class LoginLogHandler implements AuthenticationSuccessHandler {
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {}

}
