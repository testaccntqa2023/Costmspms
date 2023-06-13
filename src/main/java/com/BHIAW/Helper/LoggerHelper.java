package com.BHIAW.Helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.bhiawpkg.Utility.ResorceHelper;

public class LoggerHelper {
	private static boolean root = false;
	public static Logger getLogger(Class class1){
		if (root) {
			return Logger.getLogger(class1);
		}
	//	String log4jLOcation = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.properties";
		PropertyConfigurator.configure(ResorceHelper.getResourcePath("\\Resources\\log4j.properties"));
		root = true;
		return Logger.getLogger(class1);
	}

}
