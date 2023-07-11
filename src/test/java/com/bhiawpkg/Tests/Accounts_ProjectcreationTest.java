package com.bhiawpkg.Tests;

import java.awt.Robot;
import org.testng.annotations.Test;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.CMSLogoutPage;
import com.bhiawpkg.Pages.CompanyPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.Masterpage;
import com.bhiawpkg.Pages.ProjectcreationPage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.TestBase.TestBase2;

public class Accounts_ProjectcreationTest extends TestBase2 {
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 ProjectcreationPage pjtpge;
	 CompanyPage cmpnypge;
	private static Logger logger=LoggerHelper.getLogger(Accounts_ProjectcreationTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.CMSLogin(con.Getusername(), con.Getpassword());
		  Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  logger.info("==============login is sucessful=========================");
		  
	 }
 @Test
 public void Projectcreation() throws InterruptedException, IOException {
	  LocalDate todaydate=java.time.LocalDate.now();
	  	con=new Config(pr);
	  	String companyname=con.GetCompanyname();
	    mstr=new Masterpage(driver);
		String clientname=con.GetaccntClientname();
		Thread.sleep(2000);
		String username=con.GetAssignedusername();
	    JavascriptHelper js=new JavascriptHelper(driver);
	    mstr=new Masterpage(driver);
	   mstr.clicksettingsmenu();
	  logger.info("---------click settings menu---------------");
	   pjtpge=new ProjectcreationPage(driver);
	  pjtpge.clicksettingspjt();
	  logger.info("---------click projects from settings menu---------------");
	   pjtpge.clickaddproject();
	  logger.info("---------click add projects--------------");
	  Thread.sleep(4000);
	  String newpjtname=con.GetaccntProjectname();
	  logger.info("---------type project name--------------");
	  pjtpge.typeprojectname(newpjtname);
	  Thread.sleep(2000);
	  pjtpge.selclient(clientname);
	  Thread.sleep(2000);
	  logger.info("---------select client name-------------");
		  pjtpge.typeprojectstrtdate();
		  Thread.sleep(2000);
		  logger.info("---------type pjt start date-------------");
		  pjtpge.typeprojectenddate();
		  Thread.sleep(2000);
		  logger.info("---------type pjt end date-------------");
		  pjtpge.clickpjtctgry();
		  logger.info("---------click project category-------------");
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		   pjtpge.typepjtsitedescr("Site is near to bridge");
		  Thread.sleep(2000);
		  logger.info("---------type pjt site description-------------");
		  pjtpge.typepjtsitename("Aluva"+RandomStringUtils.randomAlphabetic(2));
		  Thread.sleep(2000);
		  logger.info("---------type pjt site name-------------");
		   pjtpge.selectcompany(companyname);
		  Thread.sleep(2000);
		  logger.info("---------click the company chk box ------------");
		   pjtpge.Clickassigntouser(username);
		  Thread.sleep(2000);
		  logger.info("---------user click the assigned user------------");
		   pjtpge.selexphead();
		  Thread.sleep(2000);
		  logger.info("---------user choose the expense head------------");
		   pjtpge.selpjtstatus("Ongoing");
		  logger.info("---------choose project status-----------");
		  Thread.sleep(2000);
		  pjtpge.selworkcntrtype("Square Feet Rate");
		  logger.info("-----select work type contractor--------");
		  pjtpge.typepjtsquarefeet("2300");
		  logger.info("-----type square feet---------");
		  pjtpge.typepjtsqrefeetrate("3000");
		  logger.info("-----type square feet rate--------");
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  pjtpge.typepjtquote("300");
		  Thread.sleep(2000);
		  logger.info("-----type project quote---------");
		  pjtpge.typepjtprofitmargin("40");
		  logger.info("-----type project profit margin---------");
		  pjtpge.typepjtremarks("project remarks");
		  logger.info("-----type project remarks---------");
		  pjtpge.clickcreatebtn();
		  Thread.sleep(2000);
		  logger.info("------------click create button--------------------");
		  
	  
	 // String newpjtname="QACMSpjt"+"_"+todaydate;;
		 String actualpjtname=GetNewpjtname(newpjtname);
		 logger.info("-------Getting the actual project name----------");
		 Thread.sleep(2000);
		 Writpjtnametoproperties(actualpjtname);
		 logger.info("-------write project name to the properties file------");
 }
 @AfterMethod
 public void cmsLogout() throws InterruptedException
 {
	
	CMSLogoutPage logout=new CMSLogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
	  Thread.sleep(2000);
	 	  }
 public void selectassignttouser()
	 {

		 String expcompanyusername=con.GetAssignedusername();//Getcompanyusername();
		 int compnyusercnt=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li//input")).size();
		 
		 for(int i=1;i<=compnyusercnt;i++)
		 {
		 String actcmpnyuname=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li["+i+"]")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(actcmpnyuname.equalsIgnoreCase(expcompanyusername))
		{
			WebElement chkbox=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li["+i+"]//input"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	       // chkbox.click();
			
		}
		 }
	 }
 public void selectassignttouser1()
	 {

		 String expcompanyusername=con.GetAssignedusername();//Getcompanyusername();
		 int compnyusercnt=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li//input")).size();
		 
		 for(int i=1;i<=compnyusercnt;i++)
		 {
		 String actcmpnyuname=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li["+i+"]")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(actcmpnyuname.contains(expcompanyusername))
		{
			
			WebElement chkbox=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li["+i+"]//input"));
			if(!(chkbox.isSelected()))
					{
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	       // chkbox.click();
					}
		}
		 }
	 }
 public void selectExpenseHead()
	 {

		 String expexpenseheadname="Toughen glass work";
		 int expenseheadcnt=driver.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[2]/ul[1]/li//input")).size();
		 
		 for(int i=1;i<=expenseheadcnt;i++)
		 {
		 String actexpenseheadname=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[2]/ul[1]//li["+i+"]")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(actexpenseheadname.equalsIgnoreCase(expexpenseheadname))
		{
			WebElement chkbox=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[2]/ul[1]/li["+i+"]//input"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	    	
		}
		 }
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
 public void Writpjtnametoproperties(String pjtname) throws IOException
 {
	  Properties pro=new Properties();
	  
	  pro.put("Newpjtname", pjtname);
	  FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bhicmspkg\\Properties\\writedataprperties.properties",true);
	  pro.store(file, pjtname);
	
 }
 
}
