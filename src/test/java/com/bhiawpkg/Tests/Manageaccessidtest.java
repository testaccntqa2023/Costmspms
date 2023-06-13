package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ManageAccessID;
import com.bhiawpkg.Pages.UserPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class Manageaccessidtest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(Manageaccessidtest.class);
	UserPage usrpg;
	Config con;
	ManageAccessID mngacsid;
 @BeforeMethod
  public void WPR() {
	  LoginPage bhilogin=new LoginPage(driver);
	  
		 con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");	
		  logger.info("******************************AcessID  SECTION**********************************");
	 } 
 
  @Test
  public void AddNewAccessId() throws InterruptedException, IOException {
	
	  Getaccessidsection();
	  Thread.sleep(3000);
	  boolean status=mngacsid.VerifysuccessfullAdd();
	  if(status==true)
	  {
		  logger.info("-----------Access id created successfully!!-------------------");
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  captureScreen(driver, "Create Access id--");
		  logger.info("-----------Access id created failed!!-------------------");
		  Assert.assertTrue(false,"-----------Access id created failed!!-----------------");
	  }
  }
  
  @Test
  public void EditAccessId() throws InterruptedException, IOException 
  {
	  Getaccessidsection();
	  Thread.sleep(4000);
	  mngacsid.Clickacsidedit();
	  Thread.sleep(2000);
	  logger.info("------user click edit button in accessid grid --------");
	  mngacsid.edittypeacsid();
	  Thread.sleep(2000);
	  logger.info("------user enter new  accessid --------");
	  mngacsid.clickupdatebtn();
	  Thread.sleep(2000);
	  logger.info("-------user click  update buttton---------------");
	  boolean status=mngacsid.VerifysuccessfullEdit();
	  Thread.sleep(2000);
	  if(status==true)
	  {
		  logger.info("-----------Access id updated successfully!!-------------------");
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  captureScreen(driver, "Update Access id--");
		  logger.info("-----------Access id updated FAILED!!-------------------");
		  Assert.assertTrue(false,"------------Edit access id updation failed!!-----------------");
	  }
  }
  
  public void Getaccessidsection() throws InterruptedException
  {
	  usrpg=new UserPage(driver);
	  usrpg.clickusermenu();
	  usrpg.selusertype("Internal");
	  Thread.sleep(2000);
	  String internaluname1=con.Getsiteusername();
	  Thread.sleep(2000);
	  usrpg.typegrduname(internaluname1);
	  logger.info("--------user type username in grid for edit----------");
	  usrpg.ClickEditgrdbtn();
	  Thread.sleep(2000);
	  logger.info("--------user click  grid edit button----------");
	  mngacsid=new ManageAccessID(driver);
	  mngacsid.clickmanageacsid();
	  logger.info("---------user click manage access id-----------------");
	  mngacsid.selectdeviceacsid("test");
	  mngacsid.typeacsid(RandomStringUtils.randomNumeric(6));
	  Thread.sleep(2000);
	  mngacsid.clickAcsaddbtn();
	  logger.info("-------------user click add button--------------------------");
	 
  }
  
  @AfterMethod
  public void Logout()
  {
 	  LogoutPage logout=new LogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  }

}
