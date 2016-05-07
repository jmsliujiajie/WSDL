package com.lll.test;

import com.lll.axisWs.WsPubSecur;

public class TestWS extends WsPubSecur{

	public String test(String inStr){
		String a = encrypt("hello");
		System.out.println(a);
		return a;
	}
}
