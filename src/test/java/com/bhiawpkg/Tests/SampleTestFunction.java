package com.bhiawpkg.Tests;

import java.time.Month;

public class SampleTestFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//=null;
		String value1="7.69";
		String [] reqworkrs= value1.toString().split("[.]");
		String reqwrkrs=reqworkrs[0].toString();
		System.out.println("req workers "+reqwrkrs);
		int reqwrkrs1=Integer.parseInt(reqwrkrs);
		//int required_quantity=quantity/30;
		//System.out.println("The required quantity is: "+required_quantity);
		int maxworkers=reqwrkrs1+2;
		System.out.println("Maximum workers "+maxworkers);

	}
	//String 	reqworkrs= reqwrkrs.replaceAll("[^0-9.-]", "");
	 // int i=(int)Double.parseDouble(reqworkrs.toString());

}
