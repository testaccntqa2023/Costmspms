package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.UserPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class UserEditDelete extends TestBase{
	private static final Logger logger=LoggerHelper.getLogger(UserEditDelete.class);
	LoginPage bhilogin;
	Config con;
	
	UserPage userpg;
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
  @DataProvider(name="UsereditInternaltoexternal")
  public String[][] EdituserInternaltoExternal() throws InvalidFormatException, IOException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "EditUser");
		  int colcnt=XLUTILS.getcellcount(path, "EditUser",1);
		  String [][]Edituserdetails=new String[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  Edituserdetails[i-1][j]=XLUTILS.getCellData(path, "EditUser", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Edituserdetails;
  }
 // /*------------------------------------------------------------------------------
  @Test(dataProvider="UsereditInternaltoexternal")//---INTERNAL TO EXTERNAL
  public void EditInternalToExternal(String frstnme,String lstnme, String uname,String passwod,String Email,String desgn,String dept,
		  String rptperson,String profiletype,String empid,String punchacsid,String company,String Contactno) throws InterruptedException
  {
	  userpg=new UserPage(driver);
	  userpg.clickusermenu();
	  logger.info("--------user click usermenu------------");
	  Thread.sleep(2000);
	 // userpg.typegrduname(con.Geteditusernameexttoint());
	 
	  
	  userpg.selusertype("Internal");
	  Thread.sleep(2000);
	  //String internaluname1=userpg.Getintuname();
	  String internaluname1=con.Geteditusernameexttoint();
	  Thread.sleep(2000);
	  try {
		 // String internaluname=userpg.Getintuname();
		  String internaluname=con.Geteditusernameexttoint();
		  Thread.sleep(2000);
		  userpg.typegrduname(internaluname);
		  logger.info("--------user type username in grid for edit----------");
	  userpg.ClickEditgrdbtn();
	  Thread.sleep(2000);
	  logger.info("--------user click  grid edit button----------");
	  driver.findElement(By.xpath("//*[@class='radio']//input[@id='Users_type_1']")).click();
	  Thread.sleep(2000);
	  try {
		  if(driver.findElement(By.xpath("//*[@id='uniform-Users_type_1']//span")).getAttribute("class").contains("checked"))
		  	{ 
			  String expextuser=internaluname;
			  Thread.sleep(2000);
			  AssignedtaskPage asstsk=new AssignedtaskPage(driver);
			  asstsk.clickAssignedTaskMenu();
			  Thread.sleep(2000);
			  asstsk.seleassigneduser(internaluname);
			  Thread.sleep(2000);
			  String Actuname=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[4]")).getText();
			  if(expextuser.equals(Actuname))
			  {	  
				  captureScreen(driver, "Assigned user_cannot edit");
			  
				  Thread.sleep(3000);
				  logger.info("**********Cannot edit user type internal to external, bcoz task is assigned to this user ******************");
				  Assert.assertTrue(true, "-----Cannot edit user type internal to external, bcoz task is assigned to this user ---------------");
				 
			  }
			  else
			  {
				  logger.info("**********no task assigned to specified user*************");
				  Assert.assertTrue(true, "-----no task assigned to specified user---------------");
			  }
		  	
		  	}
		  }
	  catch(Exception ex)
	  {
		  userpg=new UserPage(driver);
		  userpg.clickusermenu();
		  logger.info("--------user click usermenu------------");
		  Thread.sleep(2000);
		  userpg.typegrduname(internaluname1);
		  logger.info("--------user type username in grid for edit----------");
		  Thread.sleep(2000);
		  userpg.selusertype("Internal"); 
		 // userpg.selusertype("External");
		  userpg.ClickEditgrdbtn();
		  Thread.sleep(2000);
		  logger.info("--------user click  grid edit button----------");
		  driver.findElement(By.xpath("//*[@class='radio']//input[@id='Users_type_1']")).click();
		  logger.info("--------user changed the progile type internal to external----------");
		  userpg.clearfn();
		  Thread.sleep(1000);
		  userpg.Typefirstname(uname);
		  logger.info("--------user entering new username---------");
		  userpg.typeeditemail(Email);
		  logger.info("--------user entering new email---------");
		  userpg.Typeuserdesg(desgn);
		  logger.info("--------user entering new designation---------");
		  userpg.typecntctno(Contactno);
		  logger.info("--------user entering new contact number---------");
		  userpg.typecmpny(company);
		  logger.info("--------user entering company name---------");
		  userpg.seluserprofiletype(profiletype);
		  Thread.sleep(2000);
		  logger.info("--------user entering new profile type---------");
		  userpg.clicksavebtn();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  logger.info("--------user click save button--------");
		  logger.info("--------user details edited successfully--------");
		  Assert.assertTrue(true);
	  }
	  }catch(Exception e)
	  {
		  logger.info("-------Does not Exist Internal users---------");
		  Assert.assertTrue(true, "-----------------Does not Exist Internal users-------------------");
	  }
  }
  //------------------------------------------------------------------------------*/
  @Test(dataProvider="UsereditInternaltoexternal")//--- EXTERNAL TO INTERNAL
  public void EditExternalToInternal(String frstnme,String lstnme, String uname,String passwod,String Email,String desgn,String dept,
		  String rptperson,String profiletype,String empid,String punchacsid,String company,String Contactno) throws InterruptedException
  {
	  userpg=new UserPage(driver);
	  userpg.clickusermenu();
	  logger.info("--------user click usermenu------------");
	  Thread.sleep(2000);
	 // userpg.typegrduname(con.Geteditusernameexttoint());
	 
	  logger.info("--------user type username in grid for edit----------");
	  
	  userpg.selusertype("External");
	  Thread.sleep(2000);
	  //String externaluname1=userpg.Getextuname();
	  String externaluname1=con.Geteditusernameexttoint();
	  Thread.sleep(2000);
	  try {
		  //String externaluname=userpg.Getextuname();
		  String externaluname=con.Geteditusernameexttoint();
		  Thread.sleep(2000);
		  userpg.typegrduname(externaluname);
	  userpg.ClickEditgrdbtn();
	  Thread.sleep(2000);
	  logger.info("--------user click  grid edit button----------");
	  driver.findElement(By.xpath("//*[@class='radio']//input[@id='Users_type_0']")).click();
	  Thread.sleep(2000);
	  try {
		  if(driver.findElement(By.xpath("//*[@id='uniform-Users_type_0']//span")).getAttribute("class").contains("checked"))
		  	{ 
			  String expextuser=externaluname;
			  Thread.sleep(2000);
			  AssignedtaskPage asstsk=new AssignedtaskPage(driver);
			  asstsk.clickAssignedTaskMenu();
			  Thread.sleep(2000);
			  asstsk.seleassigneduser(externaluname);
			  Thread.sleep(2000);
			  String Actuname=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[4]")).getText();
			  if(expextuser.equals(Actuname))
			  {	  
				  captureScreen(driver, "Assigned user_not edit");
			  
				  Thread.sleep(3000);
				  logger.info("-----Cannot edit user type external to internal, bcoz task is assigned to this user ---------------");
				  Assert.assertTrue(true, "-----Cannot edit user type external to internal, bcoz task is assigned to this user ---------------");
				 
			  }
			  else
			  {
				  logger.info("----no task assigned to specified user-----------");
				  Assert.assertTrue(true, "-----no task assigned to specified user---------------");
			  }
		  	
		  	}
		  }
	  catch(Exception ex)
	  {
		  userpg=new UserPage(driver);
		  userpg.clickusermenu();
		  logger.info("--------user click usermenu------------");
		  Thread.sleep(2000);
		  userpg.typegrduname(externaluname1);
		  logger.info("--------user type username in grid for edit----------");
		  Thread.sleep(2000);
		  userpg.selusertype("External"); 
		 // userpg.selusertype("External");
		  userpg.ClickEditgrdbtn();
		  Thread.sleep(2000);
		  logger.info("--------user click  grid edit button----------");
		  driver.findElement(By.xpath("//*[@class='radio']//input[@id='Users_type_0']")).click();
		  logger.info("--------user changed the progile type  external to internal ---------");
		  userpg.clearfn1();
		  Thread.sleep(1000);
		  userpg.typeeditfrstnme(frstnme);
		  logger.info("--------user entering new firstusername---------");
		  userpg.Typeeditusername(uname);
		  logger.info("--------user entering new username---------");
		  userpg.Typeuserpassword(passwod);
		  logger.info("--------user entering new password---------");
		  userpg.typeeditemail(Email);
		  logger.info("--------user entering new email---------");
		  userpg.Typeuserdesg(desgn);
		  logger.info("--------user entering new designation---------");
		  userpg.seldept(dept);
		  logger.info("--------user selecting the department---------");
		  Thread.sleep(2000);
		  userpg.selrptperson(rptperson);
		  logger.info("--------user selecting reporting person---------");
		  userpg.seluserprofiletype(profiletype);
		  Thread.sleep(2000);
		  logger.info("--------user entering new profile type---------");
		  userpg.Typeuserempid(empid);
		  logger.info("--------user entering new empid---------");
		  Thread.sleep(2000);
		  userpg.typeeditpunchacsid(punchacsid);
		  Thread.sleep(2000);
		  logger.info("--------user entering new punchacsid---------");
		  JavascriptHelper jsuseredit=new JavascriptHelper(driver);
		  jsuseredit.scrollDownByPixel();
		  userpg.clicksavebtn();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  logger.info("--------user click save button--------");
		  logger.info("--------user details edited successfully--------");
		  Assert.assertTrue(true,"=======================");
	  }
	  }
	  catch(Exception e)
	  {
		  logger.info("-----------------------Does not exist external user------------------------");
		  Assert.assertTrue(true, "-----------------------Does not exist external user------------------------------------");
	  }
  }
  @Test
  public void UserInternalorExternalDelete() throws InterruptedException
  {
	  UserPage userpg;
	  
	 
		  userpg=new UserPage(driver);
		  userpg.clickusermenu();
		  logger.info("------------user click user menu----------------------");
		  userpg.typegrduname(con.Geteditusernameexttoint());
		  driver.navigate().refresh();
		  try {
		  String deluname=userpg.Getdeluname();
		  String userfullname=con.Geteditusernameexttoint();
		  AssignedtaskPage asstsk=new AssignedtaskPage(driver);
		  asstsk.clickAssignedTaskMenu();
		  Thread.sleep(2000);
		  asstsk.seleassigneduser(con.Geteditusernameexttoint());
		  Thread.sleep(2000);
		  try {
		  String Actuname=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[4]")).getText();
		  Thread.sleep(2000);
		  if(userfullname.equals(Actuname))
		  {	  
			  captureScreen(driver, "Assigned Tasks to this user_ cannot delete");
		  
			  Thread.sleep(2000);
			  Assert.assertTrue(true, "-----Cannot Delete user details, bcoz task is assigned to this user ---------------");
			 
		  }
		  }
		  catch(Exception e)
		  {
			  Thread.sleep(2000); 
			  userpg=new UserPage(driver);
			   userpg.clickusermenu();
			   Thread.sleep(2000);
			   userpg.typegrduname(con.Geteditusernameexttoint());
			   Thread.sleep(2000);
			   driver.navigate().refresh();
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//*[@id='users-grid']//table//tbody//tr//td[12]//a[@title='Delete']")).click();
			   AlertHelper alert=new AlertHelper(driver);
			   alert.AcceptAlert();
			   boolean status=driver.getPageSource().contains("Successfully deleted.");
			   if(status==true)
			   {
				   logger.info("--------Delete Successfully!!!!-------------------");
			   Thread.sleep(2000);
			   Assert.assertTrue(true);
			   }
			   else 
			   {
				   Assert.assertTrue(false, "----------Cannot delete, something went wrong...-------------------");
			   }
		  }
		  }
	  catch(Exception e)
	  {
		  logger.info("-----user does not exist----------");
		  Assert.assertTrue(true, "----------Users does not Exist...-------------------");
	  }
  }
  @AfterMethod
  public void Logout()
  {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
  }
}
