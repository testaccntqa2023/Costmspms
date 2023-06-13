package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.relevantcodes.extentreports.model.ExceptionInfo;

public class UsercreationTest extends TestBase{
	private static final Logger logger=LoggerHelper.getLogger(UsercreationTest.class);
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
	
  @Test(dataProvider ="userdata")
  public void UserCreation(String firstname,String lastname,String username,String password,String useremail,
		  String userdesg,String userdept,String rptperson,String profiletype,String userempid,String useracsid) 
				  throws InterruptedException {
	  userpg=new UserPage(driver);
	  userpg.clickusermenu();
	  logger.info("--------user click usermenu------------");
	  userpg.clickadduser();
	  logger.info("--------user click add user button------------");
	  userpg.switchuserfr();
	  Thread.sleep(2000);
	  logger.info("--------user switched to user frame------------");
	  userpg.Typefirstname(firstname);
	  logger.info("--------user edit first name------------");
	  userpg.Typeuserlastname(lastname);
	  logger.info("--------user edit last name------------");
	  userpg.Typeusername(username);
	  logger.info("--------user edit user name------------");
	  userpg.Typeuserpassword(password);
	  logger.info("--------user edit password------------");
	  //userpg.Typeuseremail(useremail);
	  userpg.typeeditemail(useremail);
	  logger.info("--------user edit email id-----------");
	  userpg.Typeuserdesg(userdesg);
	  logger.info("--------user edit designation------------");
	  userpg.seldept(userdept);
	  logger.info("--------user select admin department------------");
	  userpg.selrptperson(rptperson);
	  logger.info("--------user select reporting person------------");
	  userpg.seluserprofiletype(profiletype);
	  logger.info("--------user select user profile type------------");
	  userpg.Typeuserempid(userempid);
	  logger.info("--------user edit user emp id------------");
	  userpg.Typeuseracsid(useracsid);
	  logger.info("--------user edit user access id------------");
	  userpg.clickCreatebtn();
	  logger.info("--------user click create button------------");
	  Thread.sleep(2000);
	  userpg.verifysuccessfull();
	  logger.info("--------user created successfully------------");
	  Thread.sleep(2000);
  }
   //----------------------------------------------
  @DataProvider(name="userdata")
  public String[][] Usercreation() throws IOException, InvalidFormatException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "UserCreation");
		  int colcnt=XLUTILS.getcellcount(path, "UserCreation",1);
		  String [][]Adduserdetails=new String[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  Adduserdetails[i-1][j]=XLUTILS.getCellData(path, "UserCreation", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Adduserdetails;
  }
  ////////////////////////////////////
  /*========================================================================================= 
  @Test(dataProvider = "UserEdit")
  public void UserEditWithouttypeofuser(String editfirstname,String editlastname,String editusername,String editpassword,
		  String edituseremail, String edituserdesg,String edituserdept,String editrptperson,String editprofiletype,
		  String edituserempid,String edituseracsid,String editcompany,String editContactno) throws InterruptedException, IOException
  {
	   userpg=new UserPage(driver);
	  userpg.clickusermenu();
	  logger.info("--------user click usermenu------------");
	  Thread.sleep(2000);
	  logger.info("--------user edit username in grid for edit----------");
	  Thread.sleep(2000);
	  try {		
		  String usertype=driver.findElement(By.xpath("//*[@id='users-grid']//table//tbody//tr[12]//td[10]")).getText();//this is internal or external
		  userpg.selusertype(usertype);
		  Thread.sleep(2000);
		  userpg.ClickEditgrdbtn();
		  Thread.sleep(2000);
		  logger.info("--------user click  grid edit button----------");
		  switch (usertype) {
		case "External":
			System.out.println("User type is external");
			userpg.clearfn();
			 userpg.Typefirstname(editfirstname);
			  logger.info("--------user edit first name------------");
			  userpg.Typeuserlastname(editlastname);
			  logger.info("--------user edit last name------------");
			  userpg.typeeditemail(edituseremail);
			  logger.info("--------user edit email id-----------");
			  userpg.Typeuserdesg(edituserdesg);
			  logger.info("--------user edit designation------------");
			  userpg.typecmpny(editcompany);
			  logger.info("--------user edit the company------------");
			  userpg.typecntctno(editContactno);
			  logger.info("--------user edit the contact number------------");
			  userpg.seluserprofiletype(editprofiletype);
			  logger.info("--------user select user profile type------------");	
			  userpg.clicksavebtn();
			  logger.info("--------user click save button------------");
			  Thread.sleep(2000);
			  userpg.verifysuccessfull();
			  logger.info("--------"+usertype + "user Edited successfully------------");
			  Thread.sleep(3000);
			  Assert.assertTrue(true, "-------edited successfully-------------");
			break;
		case "Internal":
			  System.out.println("User type is internal");
			  userpg.clearfn1();
			  userpg.Typefirstname(editfirstname);
			  logger.info("--------user edit first name------------");
			  userpg.Typeuserlastname(editlastname);
			  logger.info("--------user edit last name------------");
			  userpg.Typeusername(editusername);
			  logger.info("--------user edit user name------------");
			  userpg.Typeuserpassword(editpassword);
			  logger.info("--------user edit password------------");
			  //userpg.Typeuseremail(useremail);
			  userpg.typeeditemail(edituseremail);
			  logger.info("--------user edit email id-----------");
			  userpg.Typeuserdesg(edituserdesg);
			  logger.info("--------user edit designation------------");
			  userpg.seldept(edituserdept);
			  logger.info("--------user select admin department------------");
			  userpg.selrptperson(editrptperson);
			  logger.info("--------user select reporting person------------");
			  userpg.seluserprofiletype(editprofiletype);
			  logger.info("--------user select user profile type------------");
			  userpg.Typeuserempid(edituserempid);
			  logger.info("--------user edit user emp id------------");
			  userpg.Typeuseracsid(edituseracsid);
			  logger.info("--------user edit user access id------------");
			  JavascriptHelper js=new JavascriptHelper(driver);
			  js.scrollDownByPixel();
			  userpg.clicksavebtn();
			  logger.info("--------user click save button------------");
			  Thread.sleep(2000);
			  userpg.verifysuccessfull();
			  logger.info("--------"+usertype  + " user Edited successfully------------");
			  Thread.sleep(3000);
			  Assert.assertTrue(true, "-------edited successfully-------------");
			break;
		default:
			logger.info("-----------cannot get user type--------------------");
			break;
		}
		 
		  	
   }    
    catch(Exception noassignedtaskuser)
			{
			 
			  Assert.assertTrue(false,"----------------No User Exist to edit----------------------------------");
			  
			}
 }   
  @DataProvider(name="UserEdit")
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
 =========================================================================================  */
  
   @AfterMethod
  public void Logout()
  {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
  }

}
