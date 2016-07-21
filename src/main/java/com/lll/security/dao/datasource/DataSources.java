package com.lll.security.dao.datasource;

import org.apache.commons.dbcp.BasicDataSource;

import com.lll.util.DESPlus;

public class DataSources  extends BasicDataSource{
	
	/**
	 * 同时支持加密和非加密的数据库密码串，加密的密码串需要将加密串放到"ENC()"的括号中。
	 */
    public void setPassword(String password) {
    	DESPlus des = null;
		try {
			des = new DESPlus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String s = password;
    	super.setPassword(password);
    	if (password.indexOf("ENC(")==0){
    		s = s.substring(4, s.length()-1);
    		try {
				s = des.decrypt(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		this.password = s;
    	}
    } 

}
