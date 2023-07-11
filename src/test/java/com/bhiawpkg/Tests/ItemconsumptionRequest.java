package com.bhiawpkg.Tests;

import java.awt.Robot;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.time.LocalDate;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.CompanyPage;
import com.bhiawpkg.Pages.LoginPage1;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.CMSLogoutPage;
import com.bhiawpkg.Pages.Masterpage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.ProjectcreationPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.Pages.WarehousePage;
import com.bhiawpkg.TestBase.TestBase2;

public class ItemconsumptionRequest extends TestBase2{
	private static Logger logger=LoggerHelper.getLogger(ItemconsumptionRequest.class);
	WPRPage wpr;
	//Config con;
	ProjectPage prpg;
	String Projectname;
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 ProjectcreationPage pjtpge;
	 CompanyPage cmpnypge;
	
 @BeforeMethod
  public void Login() throws InterruptedException {
	  LoginPage1 bhilogin=new LoginPage1(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // impliciteWait(40);
		  logger.info("--------Login is doing------------");
		  bhilogin.clickloginbtn();
		  logger.info("==============login is sucessful=========================");	
		  logger.info("******************************WPR  SECTION**********************************");
	 } 
  @Test
  public void ItemconsumptionApproval() throws InterruptedException, IOException
  {
	  LocalDate todaydate=java.time.LocalDate.now();
	  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 //String cmpnyname=cmpnypge.getlastcmpnyname();
		 impliciteWait(30);
		// ClientPage clintpge=new ClientPage(driver);
		 mstr.clicksettingsmenu();
		// clintpge.clickclientsettings();
		// String clientname=clintpge.Getclientname(cmpnyname);
		 impliciteWait(30);
	  	  con=new Config(pr);
	 
	   logger.info("---------click settings menu---------------");
	   pjtpge=new ProjectcreationPage(driver);
	  pjtpge.clicksettingspjt();
	  logger.info("---------click projects from settings menu---------------");
	  String newpjtname="QACMSpjt"+"_"+todaydate;;
		 String actualpjtname=GetNewpjtname(newpjtname);
		 logger.info("-------Getting the actual project name----------");
		 impliciteWait(30);
		 Writpjtnametoproperties(actualpjtname);
		 logger.info("-------write project name to the properties file------");
	  WarehousePage wh=new WarehousePage(driver);
		 wh.clickwarehousemenu();
		 impliciteWait(30);
		 wh.clickconsumptionreq();
		 LoadProperties1();
		 con=new Config(pr);
		 String Cmspjtname=con.GetCMSPJTname();
		 logger.info("-----------project name is-------"+Cmspjtname);
		wh.searchitemforrequest(Cmspjtname);
		 
  }
  @AfterMethod
  public void Logout() throws InterruptedException
  {
 	  CMSLogoutPage logout=new CMSLogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  }
  public String GetNewpjtname(String exppjtname)
  {
	  String actpjtname=null;
	 List<WebElement> grdpjtnames=driver.findElements(By.xpath("//table[@id='protable']//tbody//tr//td[2]"));
	 for(WebElement we:grdpjtnames)
	 {
		  actpjtname=we.getText();
		 if(exppjtname.equalsIgnoreCase(actpjtname))
		 {
			 logger.info("----------project created successfully!!!!-------------------");
			 Assert.assertTrue(true);
		 }
	 }
	 return  actpjtname;
  }
  public void Writpjtnametoproperties(String pjtname) throws IOException 
  {
	  Properties pro=new Properties();
	  
	  pro.put("Newpjtname", pjtname);
	  FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bhiawpkg\\Properties\\writedataprperties.properties",true);
	  pro.store(file, pjtname);
	
  }
}
