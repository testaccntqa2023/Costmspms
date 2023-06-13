package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.LoggerHelper;

public class UserPage {
	
	private  final Logger logger=LoggerHelper.getLogger(UserPage.class);
	Properties pr=new Properties();
	WebDriver driver;
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//li//a[text()='Users']")public WebElement usermenu;
	@FindBy(xpath="//*[@id='content']//div//a[text()='Add User']")public WebElement Adduser;
	@FindBy(id="cru-frame")public WebElement userframe;
	@FindBy(id="uniform-Users_type_0")public WebElement Internaluser;
	@FindBy(id="uniform-Users_type_1")public WebElement Externaluser;
	@FindBy(id="Users_first_name")public WebElement userfirstname;
	@FindBy(id="Users_last_name")public WebElement userlastname;
	@FindBy(id="Users_username")public WebElement username;
	@FindBy(id="Users_password")public WebElement userpassword;
	@FindBy(id="Users_email")public WebElement useremail;
	@FindBy(id="Users_designation")public WebElement userdesignation;
	@FindBy(id="Users_department_id")public WebElement userdept;
	@FindBy(id="Users_reporting_person")public WebElement userptperson;
	@FindBy(id="Users_accesscard_id")public WebElement useraccessid;
	@FindBy(id="Users_user_type")public WebElement userusertype;
	@FindBy(id="Users_employee_id")public WebElement userempid;
	@FindBy(id="Users_user_type")public WebElement userprofile;
	@FindBy(xpath="//div//input[@value='Create']")public WebElement usercreatebtn;
	@FindBy(xpath="//*[@id='users-grid']")public WebElement usergrid;
	@FindBy(xpath="//*[@id='Users_company']")public WebElement usercmpny;
	@FindBy(xpath="//*[@id='Users_contact_number']")public WebElement usercntno;
	@FindBy(xpath="//*[@id='users-grid']//table//tbody//tr[1]//td[2]")public WebElement internaluname;
	@FindBy(xpath="//*[@id='users-grid']//table//tbody//tr[1]//td[2]")public WebElement externaluname;
	
	@FindBy(xpath="/*[@id='users-grid']//table//tbody//tr//td//a[@title='Delete']")public WebElement deletegrdicon;
	@FindBy(xpath="//*[@id='users-grid']//table//thead//tr//td[2]//input[@id='Users_full_name']")public WebElement grduname;
	@FindBy(xpath="//*[@id='users-grid']//table//tbody//tr[1]//td[12]//a[@title='Edit']")public WebElement grdeditbtn;
	@FindBy(xpath="//*[@id='users-grid']//table//tbody//tr[1]//td[12]//a[@title='Delete']")public WebElement grddeletebtn;
	@FindBy(xpath="//*[@id='users-grid']//table//thead//tr//td[10]//select")public WebElement grdusertype;
	//*[@id='users-grid']//table//thead//tr//td[10]//select//option[@value='2']--External
	@FindBy(xpath="//div//input[@value='Save']")public WebElement usersavebtn;
	
	@FindBy(xpath="//*[@id='users-grid']//table//tbody//tr//td[2]//a")public WebElement delgrduname;
	
	public void clickusermenu()
	{
		this.usermenu.click();
		logger.info("------- menu clicked---------");
	}
	public void clickadduser()
	{
		this.Adduser.click();
		logger.info("------- Adduser clicked---------");
	}
	public void switchuserfr()
	{
		AlertHelper alertf=new AlertHelper(driver);
		alertf.switchtoframe(this.userframe);
		logger.info("--------------switch into a user frame---------------------");
	}
	public void chooseusertype()
	{
		this.Internaluser.click();
		logger.info("------- choose internal user-------");
	}
	public void Typefirstname(String Firstname)
	{
		this.userfirstname.sendKeys(Firstname);
		logger.info("--------Enter first name---------------------");
	}
	public void Typeuserlastname(String lastname)
	{
		this.userlastname.sendKeys(lastname);
		logger.info("--------Enter last name---------------------");
	}
	public void Typeusername(String username)
	{
		this.username.clear();
		this.username.sendKeys(username+RandomStringUtils.randomAlphabetic(4));
		logger.info("--------Enter user name---------------------");
	}
	public void Typeuserpassword(String userpwd)
	{
		this.userpassword.clear();
		this.userpassword.sendKeys(userpwd+RandomStringUtils.randomAlphanumeric(2));
		logger.info("--------Enter user password---------------------");
	}
	public void Typeuseremail(String useremail)
	{
		this.useremail.sendKeys(useremail+RandomStringUtils.randomAlphanumeric(3)+"@gmail.com");
		logger.info("--------Enter usere mail---------------------");
	}
	public void Typeuserdesg(String userdesg)
	{
		this.userdesignation.sendKeys(userdesg);
		logger.info("--------Enter user designation---------------------");
	}
	public void Typeuserempid(String useremp)
	{
		this.userempid.sendKeys(useremp+RandomStringUtils.randomNumeric(5));
		logger.info("--------Enter user employee id---------------------");
	}
	public void Typeuseracsid(String useracsid)
	{
		this.useraccessid.sendKeys(useracsid+RandomStringUtils.randomNumeric(4));
		logger.info("--------Enter user Access id---------------------");
	}
	public void seldept(String userdept)
	{
		DropdownHelper dpseldept=new DropdownHelper(driver);
		dpseldept.SelectUsingVisibleText(this.userdept, userdept);
		logger.info("---------select user department--------------");
	}
	public void selrptperson(String userrptperson)
	{
		DropdownHelper dpseldept=new DropdownHelper(driver);
		dpseldept.SelectUsingVisibleText(this.userptperson, userrptperson);
		logger.info("---------select user reporting person--------------");
	}
	public void seluserprofiletype(String userprotype)
	{
		DropdownHelper dpseldept=new DropdownHelper(driver);
		dpseldept.SelectUsingVisibleText(this.userprofile, userprotype);
		logger.info("---------select user profile type--------------");
	}
 public void clickCreatebtn()
 {
	 this.usercreatebtn.click();
	 logger.info("--------click create button--------------");
 }
 public void clicksavebtn()
 {
	 this.usersavebtn.click();
	 logger.info("--------click save button--------------");
 }
 public void verifysuccessfull()
 {
	 GenericHelper usercr=new GenericHelper();
	 usercr.isDisplayed(this.usergrid);
	 logger.info("--------chk user grid is loaded!!--------------"); 
	 
 }
 //--------------------------------------Edit----------------------------------------
 public void typegrduname(String grdunme)
 {
	 this.grduname.sendKeys(grdunme);
	 logger.info("-------------type the username in grid to edit--------------------------");
	 this.grduname.sendKeys(Keys.ENTER);
 }
 public void ClickEditgrdbtn()
 {
	 this.grdeditbtn.click();
	 logger.info("-----------click Edit button-------------------");
 }
 public void selusertype(String Typeuser)
 {
	 DropdownHelper dpselusertype=new DropdownHelper(driver);
	 dpselusertype.SelectUsingVisibleText(this.grdusertype, Typeuser);
	 logger.info("-----------select user type-------------------");
	 
 }
 public String getusertype()
 {
	 logger.info("-----------get user type-------------------");
	 //DropdownHelper dpselusertype=new DropdownHelper(driver);
	return this.grdusertype.getText();
	 
	 
 }
 public void Typeeditfirstname(String Firstname)
	{
	 this.userfirstname.clear();
		this.userfirstname.sendKeys(Firstname+"123");
		logger.info("--------Enter first name---------------------");
	}
 public boolean chktypeuser()
 {
	if( driver.findElement(By.xpath("//*[@class='radio']//span//input")).getAttribute("checked").contains("checked"))
	{
		 return true;
	}
	else
	{
		return false;
	}
 }
//--------------------------------------Edit- new ----------------------------------------
 public void typecmpny(String ucmpny)
 {
	 this.usercmpny.sendKeys(ucmpny);
	 logger.info("------------type company name---------------");
 }
 public void typecntctno(String conno)
 {
	 this.usercntno.sendKeys(conno);
	 logger.info("------------type user contact number---------------");
 }
 public void clearfn()
 {
	 this.userfirstname.clear();
	 this.userlastname.clear();
	 this.useremail.clear();
	 this.userdesignation.clear();
	 this.usercmpny.clear();
	 this.usercntno.clear();
	 this.userprofile.sendKeys("------Choose a role---------");
 }
 public void clearfn1()
 {
	 this.userfirstname.clear();
	 this.userlastname.clear();
	 this.useremail.clear();
	 this.userdesignation.clear();
	 this.userdept.sendKeys("-Choose a Department-");
	 this.userptperson.sendKeys("-----------");
	 this.userempid.clear();
	 this.useraccessid.clear();
	 this.userprofile.sendKeys("------Choose a role---------");
 }
 public void typeeditfrstnme(String frstname)
 {
	 this.userfirstname.clear();
	 this.userfirstname.sendKeys(frstname+RandomStringUtils.randomAlphanumeric(3));
	 logger.info("--------Enter first name---------------------");
 }
 public void typeeditemail(String email)
 {
	 this.useremail.clear();
	 this.useremail.sendKeys(email+RandomStringUtils.randomAlphanumeric(3)+"@gmail.com");
 }
 public void typeeditpunchacsid(String punchacsid)
 {
	 this.useraccessid.clear();
	 this.useraccessid.sendKeys(""+punchacsid+RandomStringUtils.randomNumeric(5));
 }

 public void Typeeditusername(String username)
	{
		this.username.clear();
		this.username.sendKeys(username+RandomStringUtils.randomAlphanumeric(3));
		logger.info("--------Enter user name---------------------");
	}
  public String Getintuname()
  {
	  logger.info("----------getting internal user name-------------");
	  return this.internaluname.getText();
  }
  public String Getextuname()
  {
	  logger.info("----------getting external user name-------------");
	  return this.externaluname.getText();
  }
  public void clickdelete()
  {
	  this.deletegrdicon.click();
	  logger.info("-----------Click Delete button-------------------");
  }
  public String Getdeluname()
  {
	  logger.info("-----------get user name to delete-------------------");
	  return this.delgrduname.getText();
  }
}
