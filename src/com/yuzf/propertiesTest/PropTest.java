package com.yuzf.propertiesTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String resource = "yuzf.properties";
		
		Properties properties = new Properties();
		
		//根据classloader 获取当前properties文件相对项目路径
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		InputStream inputStream = null;
		
		inputStream = classLoader.getResourceAsStream("yuzf.properties");
		
		properties.load(inputStream);
		
//		properties.load(new FileInputStream("G:\\workspase\\eclipse-workspace\\LeetCode\\src\\yuzf.properties"));
		
		System.out.println(properties.getProperty("yuzf"));
		
		
		
		
	}
	
	
	
}
