package com.bhiawpkg.Tests;

import java.awt.Robot;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.CompanyPage;
import com.bhiawpkg.Pages.LoginPage1;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.CMSLogoutPage;
import com.bhiawpkg.Pages.Masterpage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.ProjectcreationPage;
import com.bhiawpkg.Pages.PurchasePage;
import com.bhiawpkg.Pages.VendorPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase2;

public class MaterialRequisitionTest extends TestBase2{
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
	 PurchasePage puchpge;
 @BeforeMethod
  public void Login() throws InterruptedException {
	  LoginPage1 bhilogin=new LoginPage1(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  bhilogin.clickloginbtn();
		  logger.info("==============login is sucessful=========================");	
		  logger.info("******************************WPR  SECTION**********************************");
	 } 
  @Test
  public void MaterialRequisition() throws InterruptedException {
	  LocalDate todaydate=java.time.LocalDate.now();
	  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmpnypge.getlastcmpnyname();
		 Thread.sleep(2000);
		// ClientPage clintpge=new ClientPage(driver);
		 mstr.clicksettingsmenu();
		// clintpge.clickclientsettings();
		// String clientname=clintpge.Getclientname(cmpnyname);
		 Thread.sleep(2000);
	  JavascriptHelper js=new JavascriptHelper(driver);
	  con=new Config(pr);
	 
	   logger.info("---------click settings menu---------------");
	   ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 Thread.sleep(2000);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 pjtpge.clickeditpjtname();
		 Thread.sleep(2000);
		 //js.scrollDownByPixel();
		 Thread.sleep(2000);
		 pjtpge.clickcompany(cmpnyname);
		 Thread.sleep(2000);
		// js=new JavascriptHelper(driver);
		// js.scrollDownByPixel();
		 Thread.sleep(2000);
		 pjtpge.clicksavepjtbtn();
		 Thread.sleep(2000);
		 Thread.sleep(2000);
		 VendorPage vendpge=new VendorPage(driver);
			vendpge.clickvendorsmenu();
			vendpge.clickvendorslist();
			Thread.sleep(2000);
			 String vendorname=Getlastvendorname();
			 Thread.sleep(2000);
			 puchpge=new PurchasePage(driver);
			 puchpge.clickpurchasemenu();
			 Thread.sleep(2000);
			 logger.info("------click purchase Menu-----------");
			 puchpge.clickpurchaseorders();
			 Thread.sleep(2000);
			 logger.info("------click purchase Orders--------------------------");
			String editpno=Getlastcreatedpuno();
			Thread.sleep(2000);
			 puchpge=new PurchasePage(driver);
			 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
			 logger.info("------click purchase Menu-----------");
			puchpge.clickmaterialrequisition();
			 logger.info("------click Material requisition Menu-----------");
			puchpge.selpjtformaterialreq(pjtnme);
			 logger.info("------select project -----------");
			puchpge.clickaddPObtn();
			Thread.sleep(2000);
			 logger.info("-----click ADDPO btn to add Material requisition -----------");
			 puchpge.selpurchaseno(editpno);
			 Thread.sleep(2000);
			 logger.info("--select the purchase number----");
			 puchpge.clicksavebutton();
			 Thread.sleep(2000);
			 logger.info("----click save button---------");
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
		 int j;
		  actpjtname=we.getText();
		 if(exppjtname.equalsIgnoreCase(actpjtname))
		 {
			 logger.info("----------project created successfully!!!!-------------------");
			 Assert.assertTrue(true);
		 }
	 }
	 return  actpjtname;
  }
  public String Getlastvendorname() throws InterruptedException
	{
		List<WebElement>vndrlst=driver.findElements(By.xpath("//table[@id='vendortable']//tbody//tr//td[2]"));
		
		Thread.sleep(2000);
		int vndrlstcnt=vndrlst.size();
		WebElement elem=driver.findElement(By.xpath("//table[@id='vendortable']/tbody//tr["+vndrlstcnt+"]//td[2]"));
		String vendorname=elem.getText();
		return vendorname;
	}
  public String Getlastcreatedpuno()
  {
  	return driver.findElement(By.xpath("//*[@id='fixtable']/tbody[1]/tr/td[2]/div")).getText();
  }
  
}
