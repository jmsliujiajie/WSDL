package com.lll.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 */
public class ValidateUtil {

	// 移动手机号
	private static Pattern phoneNoPattern = Pattern.compile("^0{0,1}(13[4-9]|15[7-9]|15[0-2]|18[7-8]|147|18[2-3])[0-9]{8}$");
	// 单纯数字
	private static Pattern numPattern = Pattern.compile("^\\d*$");
	// 6位数字
	private static Pattern sixNumPattern = Pattern.compile("^\\d{6}$");
	// 不能有 反斜线 \ 双引号" 22% and符& 斜线/ 尖括号 < > 空格 换行 回车 与其他一些url非法转码
	private static Pattern generStrPattern = Pattern.compile("\"|<|>|\\|&|%20|%22|%27|%3C|%3E|%0D%0A|%5C|%2D");
	// 只包含大小写英文、数字、下划线的字符串，多数用于校验工号等数据
	private static Pattern e_G_StrPattern = Pattern.compile("^[a-zA-Z0-9_]+$");
	// 钱数的正则 ，如 25.00 34
	private static Pattern moneyPattern = Pattern.compile("^[0-9]+\\.?[0-9]{0,2}$");
	// IP 地址校验 验证0.0.0.0 到 255.255.255.255
	private static Pattern ipAddrPattern = Pattern
			.compile("(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])");
	// 校验mac 地址
	private static Pattern macAddrPattern = Pattern.compile("^[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}$");
 

	/***
	 * 功能：校验是否为移动手机号
	 * hejwa
	 * 2014年3月27日13:38:40
	 * 用法：
	 * if(checkedPhoneNo("13904512009")){
	 * System.out.print("号码格式正确");
	 * }else{
	 * System.out.print("手机号码格式有误");
	 * }
	 */
	public static boolean checkedPhoneNo(String phoneNo) {
		Matcher m = phoneNoPattern.matcher(phoneNo);
		return m.matches();
	}

	/***
	 * 功能：校验是否为6位的数字，多数用作密码校验
	 * hejwa
	 * 2014年3月27日13:43:24
	 * 用法：
	 * if(checkedPhoneNo("111111")){
	 * System.out.print("数字格式正确");
	 * }else{
	 * System.out.print("请输入6位数字");
	 * }
	 */
	public static boolean checkedSixNum(String sNum) {
		Matcher m = sixNumPattern.matcher(sNum);
		return m.matches();// 包含返回true
	}

	/**
	 * 功能：校验输入字符串是否有非法字符
	 * hejwa
	 * 2014年3月27日14:12:33
	 * 用法
	 * if(checkedGenerStr("aaaaaaaa")){
	 * System.out.print("输入的字符正常");
	 * }else{
	 * System.out.print("不能输入特殊字符：\" & / | < > 回车等");
	 * }
	 */
	public static boolean checkedGenerStr(String gStr) {
		Matcher m = generStrPattern.matcher(gStr);
		return !m.matches(); // 不包含特殊字符返回true
	}

	/**
	 * 功能：校验输入字符串为普通的大小写字母 数字 下划线的组合
	 * hejwa
	 * 2014年3月27日15:04:59
	 * 用法
	 * if(checkedEGStr("aaaaaaaa")){
	 * System.out.print("输入的字符正常");
	 * }else{
	 * System.out.print("不符合输入格式");
	 * }
	 */
	public static boolean checkedEGStr(String gStr) {
		Matcher m = e_G_StrPattern.matcher(gStr);
		return m.matches();
	}

	/**
	 * 功能：校验输入字符串为钱的格式 11、 11.1、11.12都符合格式 而11.121不符合，小数点可以不输入，输入后面最多只能有2位数字
	 * hejwa
	 * 2014年3月27日15:04:59
	 * 用法
	 * if(checkedMonyStr("11.11")){
	 * System.out.print("输入的字符正常");
	 * }else{
	 * System.out.print("不符合输入格式");
	 * }
	 */
	public static boolean checkedMonyStr(String moneyStr) {
		Matcher m = moneyPattern.matcher(moneyStr);
		return m.matches();
	}

	/**
	 * 功能： 校验ip地址的格式
	 * hejwa
	 * 2014年4月23日15:26:16
	 * 用法：
	 * 
	 * if(checkedIpAddr("192.168.1.1")){
	 * System.out.print("输入的字符正常");
	 * }else{
	 * System.out.print("不符合输入格式");
	 * }
	 * 
	 * @param ipAddr
	 *            ip地址
	 * 
	 * @return
	 */
	public static boolean checkedIpAddr(String ipAddr) {
		Matcher m = ipAddrPattern.matcher(ipAddr);
		return m.matches();
	}

	/**
	 * 功能： 校验mac地址的格式
	 * hejwa
	 * 2014年4月23日15:26:16
	 * 用法：
	 * 
	 * if(checkedMacAddr("h3:ae:ee:33:11:ff")){
	 * System.out.print("输入的字符正常");
	 * }else{
	 * System.out.print("不符合输入格式");
	 * }
	 * 
	 * @param ipAddr
	 *            ip地址
	 * 
	 * @return
	 */
	public static boolean checkedMacAddr(String macAddr) {
		Matcher m = macAddrPattern.matcher(macAddr);
		return m.matches();
	}

	/**
	 * 功能： 校验纯数字的字符串
	 * hejwa
	 * 2014年5月13日15:53:59
	 * 用法：
	 * 
	 * if(checkedMacAddr("123")){
	 * System.out.print("输入的字符正常");
	 * }else{
	 * System.out.print("不符合输入格式");
	 * }
	 * 
	 * @param numStr
	 *            numStr
	 * 
	 * @return
	 */
	public static boolean checkedNumber(String numStr) {
		Matcher m = numPattern.matcher(numStr);
		return m.matches();
	}

}
