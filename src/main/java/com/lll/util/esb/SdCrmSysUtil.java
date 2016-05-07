/**
 * 系统中的应用类，将常用功能提出来，增加复用程度
 * 
 * 2013年6月14日9:43:40
 */


package com.lll.util.esb;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


public class SdCrmSysUtil {
	

	/**
	 * 数组转置二维数组 transArrays 入参： inParamArray 需要转置的二维数组
	 * 
	 * 出参 : outParamArray 转置后的二维数组
	 */
	public String[][] transArrays(String[][] inParamArray ) {

		/***** 构造结果新二维数组用于存放转置结果 *******/
		/**
		 * 定义结果数组变量，注意 一定要先开辟一个内存， 否则只是地址传递，也就是说两个数组名实际上指向的是同一块内存
		 */
		// 而构造二维数组可以为维度来进行，不一定是一个矩阵，即每一行的长度不一定相同

		int maxLengt = 0; // 取最长的length
		for(int i = 0; i < inParamArray.length; i++ ) {
			if(maxLengt < inParamArray[i].length) {
				maxLengt = inParamArray[i].length;
			}
		}

		String outParamArray[][] = new String[maxLengt][];// 先实现第一维
		for(int i = 0; i < outParamArray.length; i++ ) { // 再实现第二维
			outParamArray[i] = new String[inParamArray.length];
		}
		/******* 进行元素倒置 ******/
		for(int i = 0; i < inParamArray.length; i++ ) {
			for(int j = 0; j < maxLengt; j++ ) {
				if(inParamArray[i].length <= j) {// 短的元素补空字符串
					outParamArray[j][i] = "";
				}else {
					// System.out.println(outParamArray.length+" i="+i+"  j="+j+"    "+inParamArray[i][j]);
					outParamArray[j][i] = inParamArray[i][j];
				}
			}
		}
		return outParamArray;
	}


	public static String retArrStr(String wStr, int i, int j ) {
		return "retArr[" + i + "][" + j + "]='" + wStr + "'; ";
	}

	public static String retArrStr(String wStr, int i ) {
		return "retArr[" + i + "]='" + wStr + "'; ";
	}

	/**
	 * 比较2个日期相差的时间
	 * 
	 * @param comaddr
	 * @param date
	 * @param i
	 *            1=秒 2=分 3=时 4=天 5=周 6=月 7=年
	 * @return
	 * @throws ParseException
	 */
	public static String compDate(Date date2, Date date1, int i ) {
		if(date2 == null || date1 == null) {
			return "error";
		}
		float b = 0;
		long tempv = date2.getTime() - date1.getTime();
		if(i == 1) {// 比较天
			b = (tempv / 1000 );
		}else if(i == 2) {
			b = (tempv / (1000 * 60 ) );
		}else if(i == 3) {
			b = (tempv / (1000 * 60 * 60 ) );
		}else if(i == 4) {
			b = (tempv / (1000 * 60 * 60 * 24 ) );
			if(b == 0)
				b = b + 1;
		}else if(i == 5) {
			b = (tempv / (1000 * 60 * 60 * 24 * 7 ) );
		}else if(i == 6) {
			b = (tempv / (1000 * 60 * 60 * 24 * 30 ) );
		}else if(i == 7) {
			b = (tempv / (1000 * 60 * 60 * 24 * 365 ) );
		}
		return new DecimalFormat("##0" ).format(b );
	}

	/**
	 * 返回两个日期相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static long getDistDates(Date startDate, Date endDate ) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate );
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate );
		long timeend = calendar.getTimeInMillis();
		totalDate = Math.abs((timeend - timestart ) ) / (1000 * 60 * 60 * 24 );
		return totalDate;
	}

	/***
	 * 取得随机字符串包括大小写字母和数字的组合
	 * @param length 随机串的长度
	 * @return 随机取得的字符串
	 */
	public static String genRundomKey(int length ) {
		char[] strArr = new char[length];
		int i = 0;
		while(i < length) {
			int f = (int) (Math.random() * 3 );
			if(f == 0){
				strArr[i] = (char) ('A' + Math.random() * 26 );
			}else if(f == 1){
				strArr[i] = (char) ('a' + Math.random() * 26 );
			}else{
				strArr[i] = (char) ('0' + Math.random() * 10 );
			}
			i++;
		}
		String retRundomStr = new String(strArr );
		return retRundomStr;
	}
	public static void main(String[] args ) {

		//取得随机数，作为密钥
//		for(int i = 0; i < 15; i++ ) {
//			System.out.println(genRundomKey(8));
//		}
		
		
		
		// 测试转置二维数组，每行的长度可能不一样
		//String testArr[][] = new String [][]{};
		String testArr[][] = { {"1  ", "2  " }, {"11 ", "22 ", "33 " },{"111", "222", "333" }, {"444", "555", "666" } };
		for(int i = 0; i < testArr.length; i++ ) {
			for(int j = 0; j < testArr[i].length; j++ ) {
				System.out.print(" " + testArr[i][j] );
			}
			System.out.println();
		}
		System.out.println("---转置后-----------" );
		String aa[][] = new SdCrmSysUtil().transArrays(testArr );
		for(int i = 0; i < aa.length; i++ ) {
			for(int j = 0; j < aa[i].length; j++ ) {
				System.out.print(" " + aa[i][j] );
			}
			System.out.println();
		}
		
	}
}
