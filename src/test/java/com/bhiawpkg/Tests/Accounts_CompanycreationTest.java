package com.bhiawpkg.Tests;

import java.awt.Robot;
import org.testng.annotations.Test;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.CMSLogoutPage;
import com.bhiawpkg.Pages.CompanyPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.Masterpage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.TestBase.TestBase2;

public class Accounts_CompanycreationTest extends TestBase2{
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	private static Logger loger=LoggerHelper.getLogger(Accounts_CompanycreationTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.CMSLogin(con.Getusername(), con.Getpassword());
		 // bhilogin.clickloginbtn();
		  Thread.sleep(4000);
		  loger.info("--------Login is doing------------");
		  loger.info("==============login is sucessful=========================");
		  /*
		 boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				
				loger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		  */	
		}
	 @Test
	 public void CreateAccountsCompany() throws InterruptedException
	 {
		 con=new Config(pr);
		  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 loger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 loger.info("----------user click company-----------");
		 Thread.sleep(2000);
		 cmppge.clickaddcompany();
		 Thread.sleep(2000);
		 loger.info("----------user click add company-----------");
		 LocalDate Today_date=java.time.LocalDate.now();	
		 String companyname=con.GetCompanyname();
		// String companyname="CMScmp"+"_"+ Today_date;;
		// String companyname="Amster";
			//BHI Test Company
		// String companyname=cmppge.getlastcmpnyname();
		 cmppge.typecompanynme(companyname);
		 loger.info("----------user type company name-----------");
		 Thread.sleep(2000);
		 cmppge.typecmpnypincode(67+RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 loger.info("----------user type company pincode-----------");
		 cmppge.typecmpnyphone(98698+RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 loger.info("----------user type company phone number-----------");
		 JavascriptHelper js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 cmppge.typecmpnyemail("bhiinfotech"+RandomStringUtils.randomAlphabetic(2)+"@email.com");
		 Thread.sleep(2000);
		 loger.info("----------user type company company email-----------");
		 //cmppge.typecmpnyGSTno("BC"+RandomStringUtils.randomAlphabetic(3));
		 cmppge.typecmpnyGSTno("10AABCU9603R1Z2");
		 Thread.sleep(2000);
		 loger.info("----------user type company GST no-----------");
		 cmppge.typecmpnytolerance(RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 loger.info("----------user type company tolerance-----------");
		 cmppge.typesubcntrpaylmt(RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 loger.info("----------user type company subcntr payment limit-----------");
		 cmppge.clickcmpnypopermission();
		 loger.info("----------user click company PO permission-----------");
		 cmppge.clickcmpnyautopoderno();
		 loger.info("----------user click company auto Purchase order number-----------");
		 cmppge.typecmpnyexp();
		 Thread.sleep(2000);
		 String subcntremailnotuser=con.GetAssignedusername();
		 cmppge.clicksubcontremailnot1(subcntremailnotuser);
		 Thread.sleep(2000);
		 //clicksubcontremailnot(subcntremailnotuser);
		 
		loger.info("-----------click subcontractor email notification user----------------");
		// cmppge.clicksubcntremailnotification();
		// loger.info("----------user click subcntractor email notification-----------");
		//clickPOemailnot();
		cmppge.clickPOemailnot1(subcntremailnotuser);
		Thread.sleep(2000);
		 loger.info("----------user click PO email notification-----------");
		 cmppge.typedescription("company description");
		 Thread.sleep(2000);
		 loger.info("----------user type company description-----------");
		 cmppge.typecmpnyaddress("Orient Square, 2nd floor, Sahodaran Ayyappan Rd, Kadavanthra Junction, Kochi, Kerala 682020");
		 loger.info("----------user type company address-----------");
		// clickinvoiceemailnot();
		cmppge.clickinvoiceemailnot1(subcntremailnotuser);
		 Thread.sleep(2000);
		 loger.info("----------user click invoice email notification----------");
		 cmppge.clickcmpnycreatebtn();
		 loger.info("----------user click cmpny create button---------");
		 Thread.sleep(2000);
		 String Newcmpny=getcompanyname(companyname);
		 Thread.sleep(2000);
		 if(companyname.equals(Newcmpny))
		 {
			 loger.info("-----Company creation successfully done!!------------");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 loger.info("-----Company creation failed------------");
			 Assert.assertTrue(false,"--Something went wrong. Company creation failed!"); 
		 }
	 }
	
	 public String getcompanyname(String cmpname)
	 {
		 String cmpanyname=null;
		 
		 List<WebElement> cmpnynames=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 for(WebElement we:cmpnynames)
		 { 
			 cmpanyname=we.getText();			 
			 try {
			if(cmpname.equals(we.getText()))
			{
			 System.out.println(we.getText());
			//Assert.assertTrue(true);
			loger.info("------------company creation successfully!!!--------------------------");
			}}
			 catch(Exception ex)
			 {
				 Assert.assertTrue(false,"----------something went wrong, company cannot create-----------------------");
			 }
		 
		 }
		 return cmpanyname;
	 }
	 
	 public void cmsLogout() throws InterruptedException
	  {
		
		CMSLogoutPage logout=new CMSLogoutPage(driver);
		  logout.clickusericon();
		  logout.clickLogout();
		  Thread.sleep(2000);
		 	  }
}
