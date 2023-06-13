package com.bhiawpkg.Pages;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;


public class AllWorkProgressfilterPage {
	WebDriver driver;
	private static final Logger logger=LoggerHelper.getLogger(AllWorkProgressfilterPage.class);
	
	public  AllWorkProgressfilterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="project_id")public WebElement selwrkprgpjt;
	@FindBy(id="taskid")public WebElement selwrkprgtask;
	@FindBy(id="DailyWorkProgress_created_by")public WebElement seluser;
	@FindBy(xpath="//*[@class='grid-view']//table//tbody//tr[1]//td[3]")public WebElement gettskname;
	@FindBy(xpath="//*[@class='grid-view']//table//tbody//tr[1]//td[7]")public WebElement getusername;
	@FindBy(xpath="//*[@class='grid-view']//table//tbody//tr[1]//td[6]")public WebElement getgrddate;
	@FindBy(xpath="//*[@value='Go']")public WebElement gobtn;
	@FindBy(xpath="//*[@value='Clear']")public WebElement clearbtn;
	
	@FindBy(id="DailyWorkProgress_fromdate")public WebElement fromdate;
	@FindBy(id="DailyWorkProgress_todate")public WebElement todate;
	
	@FindBy(xpath="//*[@class='items']//span")public WebElement getgrdtxt;
	public void selwrkprgpjt(String pjtname)
	{
		DropdownHelper dpselpjt=new DropdownHelper(driver);
		dpselpjt.SelectUsingVisibleText(this.selwrkprgpjt, pjtname);
		logger.info("----------------select pjt----------------------");
	}
	public String Getpjtname()
	{
		logger.info("----------------get the pjt name----------------------");
		return this.selwrkprgpjt.getText();
	}
	
	public void seltask() throws InterruptedException
	{
		//String taskname=this.gettskname.getText();
		Select s1=new Select(selwrkprgtask);
		List<WebElement>tasklst= s1.getOptions();
		for(WebElement we:tasklst)
		{
			String tsktxt=we.getText();
			if(tsktxt.contains("SUB"))
			{
			DropdownHelper dpseltsk=new DropdownHelper(driver);
			dpseltsk.SelectUsingVisibleText(this.selwrkprgtask, tsktxt);
			Thread.sleep(2000);
			break;
			}
		}
		//DropdownHelper dpseltsk=new DropdownHelper(driver);
		//dpseltsk.SelectUsingIndex(selwrkprgtask, 2);
		//dpseltsk.SelectUsingVisibleText(this.selwrkprgtask, taskname);
		logger.info("----------------select task ----------------------");
	}
	public String Getuser()
	{
		return this.getusername.getText();
	}
	public void selwprprguser(String usernme)
	{
		//String User= this.getusername.getText();
		
		DropdownHelper dpseluser=new DropdownHelper(driver);
		dpseluser.SelectUsingVisibleText(this.seluser, usernme);
		logger.info("----------------select user ----------------------");
	}
	public LocalDate Getdate()
	{
		//return this.getgrddate.getText();
		LocalDate todaydate=LocalDate.now();
		return todaydate;
	}
	public String getgrdtext()
	{
		try {
		String grdtxt=this.getgrdtxt.getText();
		logger.info("----------------get grid text ----------------------");
		return grdtxt;}
		finally {
			logger.info("------------data exist----------------------");
		}
	}
	public void Typefromdate()
	{
		LocalDate todaydate=LocalDate.now();
		this.fromdate.sendKeys(""+todaydate.minusDays(7));
		logger.info("------------enter from date---------------------");
	}
	public void Typetodate()
	{
		LocalDate todaydate=LocalDate.now();
		this.todate.sendKeys(""+todaydate);
		logger.info("------------enter to date---------------------");
	}
	public void clickgobtn()
	{
		this.gobtn.click();
		logger.info("------------click go button--------------------");
	}
	public void Clearwrkpgrssearchfilter()
	{
			
		this.fromdate.clear();
		logger.info("------------from date is cleared--------------------");
		this.todate.clear();
		logger.info("------------to date is cleared--------------------");
	}
	public void delectdropdown(WebElement elem)
	{
		Select DropDown = new Select(elem);

		DropDown.deselectByVisibleText(getgrdtext());
	}
	public void clickclearbutton()
	{
		this.clearbtn.click();
		logger.info("------------all fields are cleared-------------------");
		
	}
}
