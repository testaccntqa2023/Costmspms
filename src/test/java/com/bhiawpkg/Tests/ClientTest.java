package com.bhiawpkg.Tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.ClientPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class ClientTest extends TestBase{
	private static final Logger logger=LoggerHelper.getLogger(ClientTest.class);
	LoginPage bhilogin;

	Config con;
	ClientPage clientpg;
	 @BeforeMethod
		public void Login() 
		{
			con=new Config(pr); 
			bhilogin=new LoginPage(driver);
		    bhilogin.Login(con.Getusername(),con.Getpassword());
		    logger.info("--------Login is doing------------");
		    bhilogin.Clickbox();
		    logger.info("==============login is sucessful=========================");
		}
  @Test(dataProvider = "clientdata")
  public void Clientcreation(String clientname,String clientnickname,String clipjttype, String clientdescr) throws InterruptedException {
	  
	   clientpg=new ClientPage(driver);
	  clientpg.clickclientmenu();
	  logger.info("--------user click client menu------------");
	  clientpg.clickaddclient();
	  logger.info("--------user click add client ------------");
	  clientpg.switchclientfr();
	  logger.info("--------user switch to client frame------------");
	  clientpg.typeclientname(clientname);
	  logger.info("--------user type click client name------------");
	 clientpg.typeclientnickname(clientnickname);
	 logger.info("--------user type client nick name-----------");
	  clientpg.clickclientstatus();
	  logger.info("--------user click client status------------");
	  clientpg.selProjecttype(clipjttype);
	  Thread.sleep(2000); 
	  logger.info("--------user select project type------------");
	  clientpg.typedescr(clientdescr);
	  logger.info("--------user type description------------");
	  clientpg.clickcretebutton();
	  Thread.sleep(2000); 
	  logger.info("--------user click create-----------");
	  clientpg.verifysuccessfull();
	  Thread.sleep(2000);
	 logger.info("--------client creation successfully!!-----------");
			
  }
  @DataProvider(name="clientdata")
  public String[][] Clientcreation() throws IOException, InvalidFormatException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "ClientCreation");
		  int colcnt=XLUTILS.getcellcount(path, "ClientCreation",1);
		  String [][]Clientdetails=new String[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  Clientdetails[i-1][j]=XLUTILS.getCellData(path, "ClientCreation", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Clientdetails;
  }
  @AfterMethod
  public void Logout()
  {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
  }
}
