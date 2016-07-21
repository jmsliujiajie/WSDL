package com.lll.security.dao.datasource;



import com.lll.util.CustomizedPropertyPlaceholderConfigurer;

public class DataSourceSwitch {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal();

	public static void setDataSourceType(String dataSourceType){   
        contextHolder.set(dataSourceType);   
    }  
	
	public static String getDataSourceType() {
		return (String) contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}

	public static void initDataSourse(String code) {
		String host = (String) CustomizedPropertyPlaceholderConfigurer
				.getContextProperty(code);
		try {
			clearDataSourceType();
			setDataSourceType(host);
			System.out
					.println("-----------------------转换数据源成功---------------------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("-----------------------转换数据源失败---------------------");
		}
	}

}
