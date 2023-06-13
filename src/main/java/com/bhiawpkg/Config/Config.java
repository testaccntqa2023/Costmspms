package com.bhiawpkg.Config;

import java.util.Properties;


public class Config {
	Properties pr=new Properties();
	public Config(Properties pr)
	{
		this.pr=pr;
	}
	public String Getbrowser()
	{
		return pr.getProperty("browser");
	}
	public String Geturl()
	{
		
		return pr.getProperty("URL");
	}
	public String Geturl1()
	{
		
		return pr.getProperty("URL1");
	}
	public String GetCMSPJTname()
	{
		
		return pr.getProperty("Newpjtname");
	}
	public String Getusername()
	{
		return pr.getProperty("username");
	}
	public String Getpassword()
	{
		return pr.getProperty("password");
	}
	public String Getactionproject()
	{
		return pr.getProperty("ActionProjectName");
	}
	public String Getexpiredproject()
	{
		return pr.getProperty("ExpiredProjectName");
	}
	public String Getsiteusername()
	{
		return pr.getProperty("Siteusername");
	}
	public String Geteditusernameexttoint()
	{
		return pr.getProperty("editusernameext");
	}
	public String Getpunchusername()
	{
		return pr.getProperty("punchuser");
	}
	public String Getadminusername()
	{
		return pr.getProperty("Adminuser");
	}
	public String Getphotopunchpath()
	{
		return pr.getProperty("photopunchpath");
	}
	public int getImplicitWait() {
		return Integer.parseInt(pr.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(pr.getProperty("Explicitwait"));
	}
	public int getPageLoadTimeOut() {
		return Integer.parseInt(pr.getProperty("PageLoadTimeOut"));
	}
	public String getpjtfrmexmonth()
	{
		return pr.getProperty("pjtrptfromexpmonth");
	}
	public String getpjtrptfrmexyear()
	{
		return pr.getProperty("pjtrptfromexpyear");
	}
	public String getpjtrptfrmexday()
	{
		return pr.getProperty("pjtrptfromexpDay");
	}
	public String getpjttoexmonth()
	{
		return pr.getProperty("pjtrpttoexpmonth");
	}
	public String getpjtrpttoexyear()
	{
		return pr.getProperty("pjtrpttoexpyear");
	}
	public String getpjtrpttoexday()
	{
		return pr.getProperty("pjtrpttoexpDay");
	}
	
	public String getpunchrptstartdate()
	{
		return pr.getProperty("punchingreptstartdate");
	}
	public String getpunchrptenddate()
	{
		return pr.getProperty("punchingreptenddate");
	}
	public String getempdepartment()
	{
		return pr.getProperty("Empmnthrptdepartment");
	}
	public String Getclonepjt()
	{
		return pr.getProperty("Cloneproject");
	}
}
