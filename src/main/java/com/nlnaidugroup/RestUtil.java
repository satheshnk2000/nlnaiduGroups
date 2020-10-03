package com.nlnaidugroup;

public class RestUtil {

	public static void main(String[] args) {
		new RestUtil().printSystPathe();
	}
	public void printSystPathe()
	{
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
}
