package com.bhiawpkg.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;

public class MyTaskPage {
	WebDriver driver;
	private static final Logger logger=LoggerHelper.getLogger(MyTaskPage.class);
	
	public  MyTaskPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "My Tasks")public WebElement mytaskmenu;
	@FindBy(xpath="//li[6]//ul//li//a[text()='My Tasks']")public WebElement mytaskoption;
	@FindBy(how = How.ID , using = "Tasks_project_id")public WebElement selpjtmytsk;
	@FindBy(how = How.ID , using = "Tasks_assigned_to")public WebElement selassgndmytsk;
	@FindBy(how = How.ID , using = "Tasks_coordinator")public WebElement seltskcoordinmytsk;
	@FindBy(id="Tasks_milestone_id")public WebElement selmilestonemytsk;
	@FindBy(xpath="//*[@value='Search']")public WebElement searchbtn;
	@FindBy(xpath="//*[@id='tasks-grid']//table//tbody//tr")public WebElement mytskgrdrowno;
	@FindBy(id="uniform-list_change")public WebElement completedtskchkbx;
	@FindBy(xpath="//*[@id='tasks-grid']//div[2]//table//tbody//tr[1]//td[11][text()='Completed']")public WebElement cmpltedstatus;
	@FindBy(xpath="//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[7]/ul[1]/li[1]/a[1]")public WebElement mytskoption;

	//10-01-2023
	//*****************************Material Request***************************************
	@FindBy(linkText ="MR")public WebElement materialrequestmenu;
	@FindBy(xpath ="//*[@name='MaterialRequisition[requisition_project_id]']")public WebElement seltblpjt;
	@FindBy(xpath="//table//tbody//tr//td[6]//a[@title='Approve']")public WebElement approvetblbtn;
	
	//-----------------------28-03-2023
	@FindBy(xpath="//thead/tr[2]/td[12]/select[1]")public WebElement mytasktype;
	@FindBy(xpath="//table//tbody/tr[1]/td[15]/a[1]")public WebElement mytskviewicon;
	@FindBy(xpath ="//*[@id='shift_userid']")public WebElement shiftuser;
	@FindBy(xpath ="//a[text()='Add Daily Work Progress']")public WebElement Adddailywprbtn;
	@FindBy(xpath="//a[text()='Add Time']")public WebElement AddTimebtn;
	//-----------------------18-04-2023
	@FindBy(xpath="//thead/tr[2]/td[11]/select[1]")public WebElement mytaskstatus;
	//@FindBy(xpath="//thead/tr[2]/td[12]/select[1]")public WebElement mytasktype;
	/*
		@FindBy(xpath="//thead/tr[2]/td[12]/select[1]")public WebElement;
		@FindBy(xpath="")public WebElement;
		@FindBy(xpath="")public WebElement;
		@FindBy(xpath="")public WebElement;
		*/
	
	
	public void clickmytskmenu()
	{
		this.mytaskmenu.click();
		logger.info("-------------click my task menu---------------------");
	}
	public void clickmytaskoption()
	{
		this.mytskoption.click();
	}
	public void clickmytskoption()
	{
		this.mytaskoption.click();
		logger.info("-------------click my task option---------------------");
	}
	public void seltasktype(String tasktype)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.mytasktype, tasktype);
	}
	public void seltaskstatus(String taskstatus)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.mytaskstatus, taskstatus);
	}
	public void selmytskpjt(String selmytskpjt)
	{
		DropdownHelper dpselmytskpjt=new DropdownHelper(driver);
		dpselmytskpjt.SelectUsingVisibleText(this.selpjtmytsk, selmytskpjt);
		logger.info("-----------selct project-------------");
		
	}
	public void selasignedtsk(String selassgndto)
	{
		DropdownHelper dpselasgnd=new DropdownHelper(driver);
		dpselasgnd.SelectUsingVisibleText(this.selassgndmytsk, selassgndto);
		logger.info("----------select assigned users-----------------------");
	}
	public void selcordinatortsk(String selcoordintr)
	{
		DropdownHelper dpselcoordintr=new DropdownHelper(driver);
		dpselcoordintr.SelectUsingVisibleText(this.seltskcoordinmytsk, selcoordintr);
		logger.info("----------select cordinator-----------------------");
	}
	public void selmilestonetsk()
	{
		DropdownHelper dpselmilestone=new DropdownHelper(driver);
		//dpselmilestone.SelectUsingVisibleText(this.selmilestonemytsk, selmilestone);
		logger.info("----------select milestone-----------------------");
		dpselmilestone.SelectUsingIndex(this.selmilestonemytsk, 1);
	}
	public void clicksearchbtn()
	{
		this.searchbtn.click();
		logger.info("------------- click search button------------------------");
	}
	public int Getmytskgrdrowno()
	{
		int rowno=driver.findElements(By.xpath("//*[@id='tasks-grid']//table//tbody//tr")).size();
		logger.info("------------- get row number-----------------------");
		return rowno;
		
	}
	public void clickcompletdchkbx()
	{
		this.completedtskchkbx.click();
		logger.info("----------click completed check box-----------------------");
	}
	
	public String Getgrdstatustxt()
	{
		 logger.info("----------get status ----------------------");
		return	this.cmpltedstatus.getText();
		
	}
	//10-01-2023
	//*****************************Material Request***************************************
	
	@FindBy(xpath="//li//a[text()='MR']")public WebElement MaterialRequestlink;
	public void clickmaterialreqlink()
	{
		this.MaterialRequestlink.click();
		logger.info("----------click material request link----------");
	}
	
	
	public void clickmaterialrequest()
	{
		this.materialrequestmenu.click();
	}
	public void selpjtfrmtable(String pjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.seltblpjt, pjtname);
		logger.info("------select project--------");
	}
	public void clickapprovebtn()
	{
		this.approvetblbtn.click();
		logger.info("-----click approve button-----------");
	}
	
	public void clickmytaskview()
	{
		this.mytskviewicon.click();
	}
	public void shiftuser(String user)
	{
		DropdownHelper dpshiftuser=new DropdownHelper(driver);
		dpshiftuser.SelectUsingVisibleText(shiftuser, user);
		logger.info("--------------------shift user--------------");
	
	}
	public void clickAdddailywprbutton()
	{
		this.Adddailywprbtn.click();
	}
	
	public void clickAddTimebtn()
	{
		this.AddTimebtn.click();
	}
	public void Getexpiredtask() throws InterruptedException, ParseException
	{
		Date chkDate;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy");
		//JavascriptHelper js= new JavascriptHelper(driver);
		//js.scrollDownByPixel();
		List<WebElement>lstmytsk=driver.findElements(By.xpath("//table//tbody/tr"));
		for(int i=1;i<=lstmytsk.size();i++)
		{
			String taskenddate=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[10]")).getText();
			
			String expiredtask=taskenddate;
			  SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yy");
			  Date d1 = sdformat.parse(expiredtask);
			  System.out.println("expiredtask "+d1);
			  
			  Date today3=new Date();
			  System.out.println("Today date is "+today3);
			  
			  if (today3.compareTo(d1)<0)
			  
			      System.out.println("Today Date is Lesser than my Date");
						  
			  else if (today3.compareTo(d1)>0)
			      System.out.println("Today Date is Greater than my date"); 
			  	String Tasktype=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[12]")).getText();
			  	Thread.sleep(2000);
			String Taskpercentage=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[6]")).getText();
			Thread.sleep(2000);
			if(!(Taskpercentage.equals("100%"))&&(Tasktype.equals("External")))
			{
				driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[15]/a[1]")).click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	public void clickexpiredmytaskview() throws InterruptedException
	{
		List<WebElement>lstmytsk=driver.findElements(By.xpath("//table//tbody/tr"));
		for(int i=1;i<=lstmytsk.size();i++)
		{
			String Tasktype=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[12]")).getText();
			String Taskpercentage=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[6]")).getText();
			if(Taskpercentage.equals("0%"))
			{
				driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[15]/a[1]")).click();
				Thread.sleep(2000);
				break;
			}
			else
			{
			String [] Taskpercentagevalue=Taskpercentage.toString().split("[.]");
			String Taskpercentagevalue1=Taskpercentagevalue[0].toString();
			int Taskpercentage1=Integer.parseInt(Taskpercentagevalue1);
			System.out.println("TAsk percentage is "+Taskpercentage1);
			if(Taskpercentage1<100)
			{
				if(Tasktype.equals("External"))
				{
					driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[15]/a[1]")).click();
					Thread.sleep(2000);
					break;
				}
			}
			
		}}
	}
	
	
	public void clickexpiredinternalmytaskview() throws InterruptedException
	{
		List<WebElement>lstmytsk=driver.findElements(By.xpath("//table//tbody/tr"));
		for(int i=1;i<=lstmytsk.size();i++)
		{
			String Tasktype=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[12]")).getText();
			String Taskpercentage=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[6]")).getText();
			if(Taskpercentage.equals("0%"))
			{
				driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[15]/a[1]")).click();
				Thread.sleep(2000);
				break;
			}
			else
			{
			String [] Taskpercentagevalue=Taskpercentage.toString().split("[.]");
			String Taskpercentagevalue1=Taskpercentagevalue[0].toString();
			int Taskpercentage1=Integer.parseInt(Taskpercentagevalue1);
			System.out.println("TAsk percentage is "+Taskpercentage1);
			if(Taskpercentage1<100)
			{
				if(Tasktype.equals("Internal"))
				{
					driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[15]/a[1]")).click();
					Thread.sleep(2000);
					break;
				}
			}
		}
			
		}
	}
	
	
	
	
	
	
	
	
}
