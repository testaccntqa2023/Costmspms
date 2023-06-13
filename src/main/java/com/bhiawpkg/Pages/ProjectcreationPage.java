package com.bhiawpkg.Pages;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import org.apache.log4j.Logger;

public class ProjectcreationPage {
	 WebDriver driver;
		Properties pr=new Properties();
		JavascriptHelper js;
		Masterpage mstr;
		ProjectcreationPage pjtpge;
		private final Logger logger=LoggerHelper.getLogger(ProjectcreationPage.class);
		public ProjectcreationPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//li//a[text()='Projects']")public WebElement settingspjtpge;
		@FindBy(xpath="//*[text()='Add Project']")public WebElement Addpjtbtn;
		@FindBy(xpath="//*[@id='projects-form']//input[@id='Projects_name']")public WebElement projectname;
		@FindBy(xpath="//*[@id='projects-form']//select[@id='Projects_client_id']")public WebElement selclient;
		
		@FindBy(xpath="//*[@id='projects-form']//input[@id='Projects_start_date']")public WebElement pjtstrtdate;
		@FindBy(xpath="//*[@id='projects-form']//input[@id='Projects_completion_date']")public WebElement pjtenddate;
		@FindBy(xpath="//input[@id='Projects_project_category' and @value='104']")public WebElement pjtctgry;
		@FindBy(xpath="//*[@id='projects-form']//div//textarea[@id='Projects_description']")public WebElement pjtsitedescr;
		@FindBy(xpath="//*[@id='projects-form']//input[@id='Projects_site']")public WebElement pjtsitename;
		@FindBy(xpath="//*[@class='col-md-3 validating']//select[@id='Projects_project_status']")public WebElement Pjtstatus;
	    @FindBy(xpath="//div[6]//select[@id='Projects_project_status']")public WebElement selPjtstatus;
	    @FindBy(xpath="//div[6]//select[@id='Projects_project_type']")public WebElement selworkcntrtype;
	  
	    @FindBy(xpath="//*[@id='Projects_sqft']")public WebElement squarefeet;
	    @FindBy(xpath="//*[@id='Projects_sqft_rate']")public WebElement squarefeetrate;
	    @FindBy(xpath="//*[@id='Projects_project_quote']")public WebElement pjtquote;
	    @FindBy(xpath="//*[@id='Projects_profit_margin']")public WebElement profitmargin;
	    @FindBy(xpath="//*[@id='Projects_remarks']")public WebElement pjtrmks;
	    @FindBy(xpath="//*[@value='Create']")public WebElement createbtn;
	    @FindBy(xpath="//*[@value='Save']")public WebElement savebtn;
		public void clicksettingspjt()
		{
			this.settingspjtpge.click();
			logger.info("-----------click projects in settings ----------------------");
		}
		public void clickaddproject()
		{
			this.Addpjtbtn.click();
			logger.info("----------click add projects------------------------------");
		}
		public void typeprojectname(String pjtname)
		{
			this.projectname.sendKeys(pjtname);
		}
		public void selclient(String clientname)
		{
			DropdownHelper dpselclient=new DropdownHelper(driver);
			dpselclient.SelectUsingVisibleText(this.selclient, clientname);
			//dpselclient.SelectUsingVisibleText(this.selclient, clientname);
			logger.info("------------select client-------------------");
		}
		public void clickstartpjtdate()
		{
			this.pjtstrtdate.click();
		}
		public void clickendpjtdate()
		{
			this.pjtenddate.click();
		}
		public void typeprojectstrtdate()
		{
			LocalDate Today_date=java.time.LocalDate.now();
			String strtdate=Today_date.toString();
			JavascriptHelper jsdate=new JavascriptHelper(driver);
			jsdate.selectDateByJS(driver, this.pjtstrtdate, strtdate);
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("document.getElementsByClassName('form-control')[10].setAttribute('value',Today_date)", "");
			//this.pjtstrtdate.sendKeys(""+Today_date);
			//this.pjtstrtdate.sendKeys(Keys.ENTER);
			logger.info("------------type project start date----------------");
		}
		public void typeprojectenddate()
		{
			LocalDate Today_date=java.time.LocalDate.now();
			String enddate=Today_date.plusDays(33).toString();
			JavascriptHelper jsdate=new JavascriptHelper(driver);
			jsdate.selectDateByJS(driver, this.pjtenddate, enddate);
			logger.info("------------type project end date----------------");
		}
		public void clickpjtctgry()
		{
			this.pjtctgry.click();
			logger.info("-------click project category----------------------");
		}
		public void typepjtsitedescr(String pjtsitedescr)
		{
			this.pjtsitedescr.sendKeys(pjtsitedescr);
			
		}
		public void typepjtsitename(String pjtsitename)
		{
			this.pjtsitename.sendKeys(pjtsitename);
		}
		public void selpjtstatus(String status)
		{
			//this.Pjtstatus.click();
			DropdownHelper dpselpjtstatus=new DropdownHelper(driver);
			dpselpjtstatus.SelectUsingVisibleText(selPjtstatus, status);
			logger.info("-------select the project status---------------------");
		}
		public void selworkcntrtype(String workcntrtype)
		{
			//this.Pjtstatus.click();
			DropdownHelper dpselpjtstatus=new DropdownHelper(driver);
			dpselpjtstatus.SelectUsingVisibleText(selworkcntrtype, workcntrtype);
			logger.info("-------select the work contract type---------------------");
		}
		
		public void typepjtsquarefeet(String pjtsquarefeet)
		{
			this.squarefeet.sendKeys(pjtsquarefeet);
			logger.info("-------type project squarefeet---------------------");
		}
		public void typepjtsqrefeetrate(String pjtsquarefeetrate)
		{
			this.squarefeetrate.sendKeys(pjtsquarefeetrate);
			logger.info("-------type project squarefeet rate---------------------");
		}
		public void typepjtquote(String pjtquote)
		{
			this.pjtquote.sendKeys(pjtquote);
			logger.info("-------type project quote---------------------");
		}
		public void typepjtprofitmargin(String pjtprofitmrgn)
		{
			this.profitmargin.sendKeys(pjtprofitmrgn);
			logger.info("-------type project profit margin---------------------");
		}
		public void typepjtremarks(String pjtrmks)
		{
			this.pjtrmks.sendKeys(pjtrmks);
			logger.info("-------type project remarks---------------------");
		}
		public void clickcreatebtn()
		{
			WebElement elem=this.createbtn;
			JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", elem);
		}
		public String getlastprojectname() throws InterruptedException
		 {
			 List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
			int cmpcnt=elem.size();
			 Thread.sleep(2000);
			 String projectname=driver.findElement(By.xpath("//table//tbody//tr["+cmpcnt+"]//td[2]")).getText();
			 Thread.sleep(2000);
			 return projectname;
			
		 }
		public String getlastprojectname1(String cmpname) throws InterruptedException
		 {
			 List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[3]"));
			int cmpcnt=elem.size();
			 Thread.sleep(2000);
			 String projectname=null;
			 for(int i=1;i<=cmpcnt;i++)
			 {
				 String cmptxt=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]")).getText();
				 if(cmptxt.equals(cmpname))
				 {
					  projectname=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText();
					 Thread.sleep(2000);
				 }
			 }
			return projectname;
			
		 }
		public void clickeditpjtname() throws InterruptedException
		{
			List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
			int cmpcnt=elem.size();
			Thread.sleep(2000);
			WebElement editelm=driver.findElement(By.xpath("//table//tbody//tr["+cmpcnt+"]//td[20]//a[1]"));
			Thread.sleep(2000);
			JavascriptHelper jm=new JavascriptHelper(driver);
			jm.scrollIntoView(editelm);
			editelm.click();
			//JavascriptExecutor js=(JavascriptExecutor)driver;
		
			// js.executeScript("arguments[0].click();", editelm);
			Thread.sleep(2000);
		}
		public void clickcompany(String expcompanyname)//choosecompany
		{
			List<WebElement>companylist=driver.findElements(By.xpath("//*[@id='Projects_company_id']//li//label"));
			for(int i=1;i<=companylist.size();i++)
			{
				String cmpname=driver.findElement(By.xpath("//*[@id='Projects_company_id']//li["+i+"]//label")).getText();
				if(expcompanyname.equals(cmpname))
				{
					WebElement elem=driver.findElement(By.xpath("//*[@id='Projects_company_id']//li["+i+"]//input"));
					if(!elem.isSelected())
					{
						elem.click();
					//driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//input")).click();
					}
				}
			}
		}
		public void selexphead()
		{
			driver.findElement(By.xpath("//*[@id='select_alltype']")).click();
		}
		public void clicksavepjtbtn() throws InterruptedException
		{
			JavascriptHelper js;
			// js=new JavascriptHelper(driver);
			// js.scrollDownByPixel();
			// Thread.sleep(2000);
			WebElement elem=this.savebtn;
			try {
			 js=new JavascriptHelper(driver);
			js.executeScript("arguments[0].click();", elem);
			//elem.click();
			}
			catch(Exception ex)
			{
				js=new JavascriptHelper(driver);
				js.scrollUpByPixel();
				elem.click();
			}
		}
		
		
		public void Clickassigntouser(String uname) throws InterruptedException
		{
			List<WebElement>users=driver.findElements(By.xpath("//*[@id='projects-form']/div[1]/div[5]/div[1]/ul/li//input"));
			for(int i=1;i<=users.size();i++)
			{
				String username=driver.findElement(By.xpath("//*[@id='projects-form']//div[1]//div[5]//div[1]//ul//li["+i+"]")).getText();
				Thread.sleep(2000);
				if(username.contains(uname))
				{
					WebElement elem=driver.findElement(By.xpath("//*[@id='projects-form']//div[1]//div[5]//div[1]//ul//li["+i+"]//input"));
					Thread.sleep(2000);
					if(!elem.isSelected())
					{
					JavascriptExecutor e =(JavascriptExecutor)driver;
			        e.executeScript("arguments[0].click();", elem);
					}
				}
			}
			
		}
		public void selectcompany(String cmpname)
		 {

			 //String expcompanyname=con.Getcompanyname();
			 String expcompanyname=cmpname;
			 int compnycnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Projects_company_id']//li")).size();
			 
			 for(int i=1;i<=compnycnt;i++)
			 {
			 String actcmpnyuname=driver.findElement(By.xpath("//*[@id='Projects_company_id']//li["+i+"]//label")).getText();
			 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
			if(actcmpnyuname.contains(expcompanyname))
			{
				WebElement chkbox=driver.findElement(By.xpath("//*[@id='Projects_company_id']//li["+i+"]//input"));
				if(!chkbox.isSelected())
				{
				JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		      	}
			}
			 }
		 }
		public String Getprojectname() throws InterruptedException
		{
			 // pjtpge=new ProjectcreationPage(driver);
			 mstr=new Masterpage(driver);
			 mstr.clicksettingsmenu();
			 Thread.sleep(2000);
			 clicksettingspjt();
			 Thread.sleep(2000);
			 String pjtnme=getlastprojectname();
			 Thread.sleep(2000);
			 return pjtnme;
		}
		public String Getlastprojectname(String cmpname) throws InterruptedException
		{
			 // pjtpge=new ProjectcreationPage(driver);
			 mstr=new Masterpage(driver);
			 mstr.clicksettingsmenu();
			 Thread.sleep(2000);
			 clicksettingspjt();
			 Thread.sleep(2000);
			 String pjtnme=getlastprojectname1(cmpname);
			 Thread.sleep(2000);
			 return pjtnme;
		}

}
