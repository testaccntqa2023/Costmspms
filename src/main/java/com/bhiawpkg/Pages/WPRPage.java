package com.bhiawpkg.Pages;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.Framehelper;
import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.Uploadhelper;
import com.bhiawpkg.Config.Config;

public class WPRPage {
	WebDriver driver;
	Properties pr=new Properties();
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(WPRPage.class);
	@FindBy(xpath ="//*[contains(text(),'WPR')]")public WebElement WPRmenu;
	@FindBy(xpath ="//*[contains(text(),'Daily Work Progresses')]")public WebElement Dailywrkprogress;
	@FindBy(xpath ="//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[11]/ul[1]/li[1]/a[1]")public WebElement WPRPendingrequest1;
	@FindBy(xpath ="//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[12]/ul[1]/li[1]/a[1]/span[1]")public WebElement WPRPendingrequest;
	//@FindBy(xpath = "//li//a//span[@class='badge  notify-badge']")public WebElement WPRPendingrequest;
	@FindBy(xpath ="//*[contains(text(),'Daily Labour Report')]")public WebElement WPRDailylabourreport;
	@FindBy(xpath ="//*[contains(text(),'All Work Progress')]")public WebElement WPRAllworkprogress;
	@FindBy(xpath ="//*[contains(text(),'Reports')]")public WebElement WPRReports;
	@FindBy(xpath ="//*[@class='btn btn-primary btn-sm addworkprogressbtn']")public WebElement adddailywrkprogress;
	
	@FindBy(xpath ="//*[text()='All Work Progress']")public WebElement wprAllworkprogress;
	
	@FindBy(xpath ="//*[@id='shift_userid']")public WebElement shiftuser;
	//@FindBy(xpath ="//*[@id='DailyWorkProgress_project_id']")public WebElement seldwppjt;
	
	@FindBy(xpath ="//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/select[1]")public WebElement seldwppjt;
	
	@FindBy(xpath ="//*[@id='DailyWorkProgress_date']")public WebElement seldwppjtdate;
	@FindBy(xpath ="//*[@id='DailyWorkProgress_taskid']")public WebElement seldwptask;
	@FindBy(xpath ="//*[@id='zero']")public WebElement quantity;
	@FindBy(xpath ="//*[@id='DailyWorkProgress_work_type']")public WebElement seldwpworktype;
	@FindBy(xpath ="//*[@id='DailyWorkProgress_current_status']")public WebElement seldwpstatus;
	@FindBy(xpath ="//*[@id='DailyWorkProgress_description']")public WebElement dwpdescr;
	@FindBy(xpath ="//*[@id='image_wrap']")public WebElement dwpwprimg;
	@FindBy(xpath ="//*[@value='Submit']")public WebElement submit;
	@FindBy(xpath ="//*[@class='info']")public WebElement successmsgaddwpr1;
	@FindBy(xpath ="//*[@class='alert ']")public WebElement successmsgaddwpr;
	
//**************************************************WPR&Add Daily Work Progress*********************************************//		
//**************************************************WPR&Add Daily Labour Report*********************************************//		
	@FindBy(xpath ="//*[@id='DailyWork_project_id']")public WebElement seldlbrpjt;
	@FindBy(xpath ="//*[@id='DailyWork_date']")public WebElement seldlbrdate;
	@FindBy(xpath ="//*[@id='DailyWork_taskid']")public WebElement seldlbrtsk;
	@FindBy(xpath ="//*[@id='DailyWork_work_type']")public WebElement seldlbrwrktype;
	@FindBy(xpath ="//*[@id='DailyWork_skilled_workers']")public WebElement dlbrskwrks;
	@FindBy(xpath ="//*[@id='DailyWork_unskilled_workers']")public WebElement dlbrunskwrkr;
	@FindBy(xpath ="//*[@id='DailyWork_description']")public WebElement dlbrdesc;
	@FindBy(xpath ="//*[@value='Add']")public WebElement Addlbrbtn;
	@FindBy(xpath ="//*[@id='success-alert']")public WebElement successmsgaddlbr;
	//************************************************************************************************************************************************//		
	//**************************************************WPR&APPROVE*********************************************//	
	@FindBy(xpath ="//*[@class='panel-body']//div//textarea")public WebElement viewtextarea;
	@FindBy(xpath="//*[@class='boq_close']//a")public WebElement wprViewclose;
	@FindBy(xpath="//*[@name='DailyWorkProgress[project_id]']")public WebElement wprpendingprojtname;
	@FindBy(xpath="//*[@id='DailyWorkProgress_approve_reject_data']")public WebElement rejectreason;
	@FindBy(xpath="//*[@id='daily-work-progress-form']//input[@value='Reject']")public WebElement rejectbtn;
	@FindBy(xpath="//*[@id='cru-frame']")public WebElement  framewpr;
	@FindBy(xpath="//*[@class='info']")public WebElement successmsgrejection;
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//table//tbody//tr//td//span")public WebElement wprgrid;
	@FindBy(xpath="//*[@class='boq_details_sec panel panel-primary']")public WebElement viewpanel;
	@FindBy(xpath="//*[@class='boq_close']")public WebElement viewpanelclose;
	@FindBy(xpath="//*[@id='DailyWorkProgress_image_label_1']")public WebElement imglabel;
	
	//-----------------------------WPR AMS-photopunch out-------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//table//thead//tr//td//select[@id='DailyWorkProgress_project_id']")public WebElement selpjtpunchout;
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//table//tbody//tr")public WebElement wprrowno;
	@FindBy(xpath="//*[@class='alert']")public WebElement aftrapprove;
	@FindBy(xpath="//*[@class='boq_close']")public WebElement viewclosebtn;
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//table//thead//td[14]//select")public WebElement selapprstatus;//--column change
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//table//tbody//tr[1]//td[17]//a[@title='Recall']")public WebElement recall;
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//table//thead//tr//td//input[@name='DailyWorkProgress[date]']")public WebElement wprgrddate;
	//-----------------------------------Labourdetails-Edit--------------------------------
	@FindBy(xpath="//*[@id='daily-work-grid']//table//thead//tr//select[@id='DailyWork_project_id']")public WebElement selgrdlbrpjt;
	@FindBy(xpath="//*[@id='daily-work-grid']//table//tbody//tr//td[10]//a[@title='Edit']")public WebElement grdlbredit;
	@FindBy(xpath="//*[@id='daily-work-grid']//tbody//tr//td[3]")public WebElement grdlbrdate;
	@FindBy(xpath="//*[@value='Save']")public WebElement savebtn;
	
	//-------------------------------------For progress report----------------------------
	@FindBy(xpath="//*[@id='daily-work-progress-grid']//div[2]//table//thead//tr[2]//td[14]")public WebElement wprselapprovestatus;
	
	//-----------For expired External Task
	@FindBy(xpath="//*[@id='DailyWorkProgress_qty']")public WebElement wprquantity;
	@FindBy(xpath="//*[@id='files']")public WebElement wprimguploadbtn;
	
	
	public WPRPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickWPRMenu()
	{
		this.WPRmenu.click();
		logger.info("----WPR menu is clicked------");
	}
	public void clickDailyworkprogress()
	{
		this.Dailywrkprogress.click();
		logger.info("-------Daily work progress is clicked------------------");
	}
	public void clickadddailyworkprgs()
	{
		this.adddailywrkprogress.click();
		logger.info("-------click daily work progress-----------------");
	}
	public void selectdwppjt(String dwpproject)
	{
		DropdownHelper dpseldwp=new DropdownHelper(driver);
		dpseldwp.SelectUsingVisibleText(this.seldwppjt, dwpproject);
		logger.info("---------select the project-----------------");
	}
	public void clickdate()
	{
		this.seldwppjtdate.click();
		logger.info("----------click the date-------------------");
	}
	public void selectdate(String exday,String exmonth,String exYear) throws ParseException
	{
		Dateselectionhelper seldate=new Dateselectionhelper(driver);
		seldate.selectDatewpr(exday, exmonth, exYear);
		//seldate.selectDate(exday, exmonth, exYear);
		
		logger.info("-----------------select the date------------------------------");
	}
	public void selwprdate()
	{
		this.seldwppjtdate.clear();
		LocalDate Today_date=java.time.LocalDate.now();
		  this.seldwppjtdate.sendKeys(""+Today_date);
		this.seldwppjtdate.sendKeys(Keys.ENTER);
		logger.info("-----------------select the date------------------------------");
		//this.seldwppjtdate.sendKeys(Keys.ENTER);
	}
	public void seltask(String dwptask)
	{
		DropdownHelper dpseldwptsk=new DropdownHelper(driver);
		//dpseldwptsk.SelectUsingVisibleValue(seldwptask, dwptask);
		dpseldwptsk.SelectUsingVisibleText(this.seldwptask, dwptask);
		logger.info("------------select task---------------------");
	}
	public void seltask1()
	{
		DropdownHelper dpseldwptsk=new DropdownHelper(driver);
		//dpseldwptsk.SelectUsingVisibleValue(seldwptask, dwptask);
		dpseldwptsk.SelectUsingIndex(this.seldwptask, 1);
		logger.info("------------select task---------------------");
	}
	public void typequantity(String dwpquantity)
	{
		
		this.quantity.sendKeys(dwpquantity);
		logger.info("------------type quantity------------------");
	}
	public void seledwpworktype(String worktype)
	{
		DropdownHelper dpselworktype=new DropdownHelper(driver);
		dpselworktype.SelectUsingVisibleText(seldwpworktype, worktype);
		logger.info("----------select the work type------------------");
	}
	public void seledwpworktype1()
	{
		DropdownHelper dpselworktype=new DropdownHelper(driver);
		dpselworktype.SelectUsingIndex(seldwpworktype, 1);
		logger.info("----------select the work type------------------");
	}
	public void seldwpstatus(String status)
	{
		DropdownHelper dpselstatus=new DropdownHelper(driver);
		dpselstatus.SelectUsingVisibleText(seldwpstatus, status);
		logger.info("--------------------select status--------------");
	}
	public void typedescription(String descr)
	{
		this.dwpdescr.sendKeys(descr);
		logger.info("-----------Type description--------------");
	}
	public void clickwprimgbtn()
	{
		this.dwpwprimg.click();
		logger.info("-----------click wpr image uploD BUTTON--------------");
	}
	public void callupload(String scrfilepath) throws IOException
	{
			Uploadhelper upload=new Uploadhelper(driver);
			upload.Filetobeload(scrfilepath);
		
	}
	public void shiftuser(String user)
	{
		DropdownHelper dpshiftuser=new DropdownHelper(driver);
		dpshiftuser.SelectUsingVisibleText(shiftuser, user);
		logger.info("--------------------shift user--------------");
	
	}
	public void clicksubmit() throws InterruptedException
	{ 
		WebElement elem=this.submit;
		try
		{
		this.submit.click();
		logger.info("----------click submit----------------");
		}
		catch(Exception ex)
		{
			js=new JavascriptHelper(driver);
			js.scrollUpByPixel();
			Thread.sleep(2000);
			js.scrollToElemet(submit);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();",elem);
			Thread.sleep(2000);
			//this.submit.click();
		}
	}
	public boolean verifysuccessfull()
	{
		logger.info("----------------verify work progress is added--------------------");
		return driver.getPageSource().contains("Successfully");
		//return new GenericHelper().isDisplayed(this.successmsgaddwpr); 
		//return driver.getPageSource().contains("Data saved!");
	}
//**************************************************WPR&Add Daily Labour Report*********************************************//
	
	public void clickdailylabourreport()
	{
	
	logger.info("--------click add daily labour report-----------");
	this.WPRDailylabourreport.click();
	}
	public void sellbrpjt(String lbrpjt)
	{
	DropdownHelper dpsellbrpjt=new DropdownHelper(driver);
	dpsellbrpjt.SelectUsingVisibleText(seldlbrpjt, lbrpjt);
	logger.info("-----------------select project---------------------");
	}
	public void clicklbrdate()
	{
		this.seldlbrdate.click();
		logger.info("--------click the date---------------");
	}
	public void selelbrdate(String lbrdate)
	{
		this.seldlbrdate.clear();
		this.seldlbrdate.sendKeys(lbrdate);
		logger.info("-----------------enter labour date---------------------");
		this.seldlbrdate.sendKeys(Keys.ENTER);
	}
	public void sellbrdate(String lbrExDay,String lbrExMonth,String lbrExYear)
	{
		Dateselectionhelper dpsellbrdate=new Dateselectionhelper(driver);
		dpsellbrdate.selectDate(lbrExDay, lbrExMonth, lbrExYear);
		logger.info("---------------select the date---------------------");
	}
	public void sellbrtask(String lbrtsk)
	{
		DropdownHelper dpseldlbr=new DropdownHelper(driver);
		dpseldlbr.SelectUsingVisibleText(seldlbrtsk, lbrtsk);  
		logger.info("----------selecting the task---------------");
	}
	public void sellbrtask1()
	{
		DropdownHelper dpseldlbr=new DropdownHelper(driver);
		dpseldlbr.SelectUsingIndex(seldlbrtsk, 2);  
		logger.info("----------selecting the task---------------");
	}
	public void sellbrwrktype(String lbrwrktype)
	{
		DropdownHelper dpsellbrwrktype=new DropdownHelper(driver);
		dpsellbrwrktype.SelectUsingVisibleText(seldlbrwrktype, lbrwrktype);
		logger.info("--------------selecting the work type------------------");
	}
	public void sellbrwrktype1()
	{
		DropdownHelper dpsellbrwrktype=new DropdownHelper(driver);
		dpsellbrwrktype.SelectUsingIndex(seldlbrwrktype, 1);
		logger.info("--------------selecting the work type------------------");
	}
	public void typeskilledworkers(String skilledwrkr)
	{
		this.dlbrskwrks.sendKeys(skilledwrkr);
		logger.info("type the skilled workers");
	}
	
	public void typeunskilledworkers(String unskilledwrkr)
	{
		this.dlbrunskwrkr.sendKeys(unskilledwrkr);
		logger.info("type the unskilled workers");
	}
	public void typelbrdescription(String lbrdescr)
	{
		this.dlbrdesc.sendKeys(lbrdescr);
		logger.info("type the labor description");
	}
	
	public void clickAddlbr()
	{
		this.Addlbrbtn.click();
		logger.info("----------click add -------------------");
	}
	public boolean verifysuccessfulllbr()
	{
		logger.info("----------------verify work progress is added--------------------");
		logger.info("-------------labour detailes added--------------------");
		boolean lbrstatus=driver.getPageSource().contains("Successfully");
		return lbrstatus;
		//return new GenericHelper().isDisplayed(this.successmsgaddlbr);
		
	}
	public void typeimglabel(String imglbl)
	{
		this.imglabel.sendKeys(imglbl);
		logger.info("--------type image  label-------------");
	}
//**************************************************WPR& Pending Requests*********************************************//
		
	public void clickWPRpendinrequest()
	{
		//WebElement elem=this.WPRPendingrequest;
		//js=new JavascriptHelper(driver);
		//js.executeScript("arguments[0].click();",elem);
		//driver.findElement(By.xpath("//a[contains(text(),'Pending Requests')]//parent::li[@class='active']")).click();
		this.WPRPendingrequest.click();
		logger.info("--------click pending request-----------");
	}
	public void selectpendpjt(String pendpjt)
	{
		DropdownHelper dpselpendpjt=new DropdownHelper(driver);
		dpselpendpjt.SelectUsingVisibleText(wprpendingprojtname, pendpjt);
		logger.info("Pending project selected");
	}
	public void typetextarea(String viewreason)
	{
		this.viewtextarea.sendKeys(viewreason);
		logger.info("-------------Enter description--------------------------------");
	}
	public void clickcloseviewwpr()
	{
		this.wprViewclose.click();
		logger.info("------------closed view -----------------");
	}
	public void typerejectreason(String rejectreason)
	{
		Framehelper switchfr=new Framehelper(driver);
		switchfr.switchtoframe(this.framewpr);
		this.rejectreason.sendKeys(rejectreason);
		logger.info("---------------- enter rejection reason---------------------");
	}
	public void clickrejectbtn()
	{
		this.rejectbtn.click();
		logger.info("----------------click reject btn-----------------");
	}
	public boolean verifyRejection()
	{
		logger.info("----------------VAlidation process.....-----------------");
		return new GenericHelper().isDisplayed(this.successmsgrejection);
	}
	public String Getwprgridtext()
	{
		logger.info("----------------Getting grid text-----------------");
		return this.wprgrid.getText();
		
	}
	public boolean getdataelem()
	{
		return this.wprgrid.isDisplayed();
	}
	public boolean getviewpanel()
	{
		logger.info("----------------view panel is displayed-----------------");
		return new GenericHelper().isDisplayed(this.viewpanel);
	}
	public void closeviewpanel()
	{
		this.viewpanel.click();
		logger.info("----------------close view panel-----------------");
	}
	public WebElement Getelmview()
	{
		logger.info("---------------- return close btn in view panel-----------------");
		return this.viewclosebtn;
	}
	//**************************************************punchout************************************************
	public void selpjtpunchout(String pjtpunchout)
	{
		DropdownHelper dpselpnchout=new DropdownHelper(driver);
		dpselpnchout.SelectUsingVisibleText(this.selpjtpunchout, pjtpunchout);
		logger.info("----------------project selected for punch out-----------------");
	}
	public int getwprrowno()
	{
		int gridrowno=driver.findElements(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr")).size();
		 return gridrowno;
	}
	public WebElement getaftrappr()
	{
		return this.aftrapprove;
	}
//------------------------------------------------recall-----------------------------------------------------------
	public void selapprovestatus(String apprstatus)
	{
		DropdownHelper dpselapprstatus=new DropdownHelper(driver);
		dpselapprstatus.SelectUsingVisibleText(this.selapprstatus, apprstatus);
		logger.info("----------selecting the rejected status----------------------");
	}
	public WebElement getrecalelm()
	{
		logger.info("----------getting the recall slement----------------------");
		return this.recall;
	}
	public void getgriddate()
	{
		LocalDate Today_date=java.time.LocalDate.now();
		  this.wprgrddate.sendKeys(""+Today_date);
		
	}
	public void clickallworkprogress()
	{
		this.wprAllworkprogress.click();
		logger.info("---------click all work progress-------------------");
	}
	public void sellbrgrdpjt(String lbrgrdprjt)
	{
		DropdownHelper dpsellbrgrdpjt=new DropdownHelper(driver);
		dpsellbrgrdpjt.SelectUsingVisibleText(this.selgrdlbrpjt, lbrgrdprjt);
		logger.info("--------------------select labour project from grid--------------------------------");
	}
	public void clickEditbtn()
	{
		this.grdlbredit.click();
		logger.info("-----------click Edit button------------------------");
	}
	public String getgrdlbrdate()
	{
		logger.info("------------get grid date---------------------------");
		return this.grdlbrdate.getText();
		
	}
	public void clearfield()
	{
		//this.seldlbrpjt.clear();
		this.seldlbrdate.clear();
		this.sellbrtask("-Choose a Task-");
		//this.seldlbrtsk.sendKeys("-Choose a Task-");
		this.sellbrwrktype("-Choose a Work Type-");
		
		this.dlbrskwrks.clear();
		this.dlbrunskwrkr.clear();
		this.dlbrdesc.clear();
	}
	public void typeeditdate(String lbreditdate)
	{
		this.seldlbrdate.sendKeys(lbreditdate);
		logger.info("---------Date entered to edit-------------------");
	}
	public void clicksavebtn()
	{
		this.savebtn.click();
		logger.info("------click save button--------------");
	}
	public void seleditlbrtask()
	{
		DropdownHelper dpseldlbr=new DropdownHelper(driver);
		dpseldlbr.SelectUsingIndex(seldlbrtsk, 2);
		//dpseldlbr.SelectUsingVisibleText(seldlbrtsk, lbrtsk);  
		logger.info("----------selecting the task---------------");
	}
	public boolean verifyeditsuccessful()
	{
	boolean editlbr= driver.getPageSource().contains("Successfully");
	return editlbr;
	}
	//-----------------------------------For progress report wpr approve status---------------------
	public void selwprapprovestatus_pgsrpt(String apprstatus)
	{
		DropdownHelper dpselapprstatus=new DropdownHelper(driver);
		dpselapprstatus.SelectUsingVisibleText(this.selapprstatus, apprstatus);
		logger.info("----------selecting the status not approved---------------");
	}
	//*****************************Item consumption WPR entry*******************************************************
	@FindBy(css="#consumed_item_id")public WebElement itemconsumptionitem;
	
	public void selItemconsumption()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(itemconsumptionitem, 1);
	}
	//************************Itemconsumption**************************
	@FindBy(xpath ="//*[@id='consumed_item_id'")public WebElement seitmconsum;
	@FindBy(xpath ="//*[@id='consumed_item_rate']")public WebElement seitmconsumrate;
	@FindBy(xpath ="//*[@id='DailyWorkProgress_consumed_item_count']")public WebElement itmconsumedcnt;  
	 @FindBy(xpath ="//*[@id='consumed_item_rate']//option")public WebElement  selratteitmconsu;
	 @FindBy(xpath ="//*[@id='DailyWorkProgress_consumed_item_count']")public WebElement noofitm ;
	 @FindBy(xpath ="//*[@id='add_new']")public WebElement itmconsumdaddnewbtn;
	 
	public void selitmconsumption()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(seitmconsum, 1);
	}
	public void selitmconsumptionrate()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(seitmconsum, 1);
	}
	public void typeitmconsumedcnt()
	{
		this.itmconsumedcnt.sendKeys(""+1);
	}
	public void typeitmconsumed()
	
	{
		this.noofitm.sendKeys(""+1);
	}
	public void clickAddnewitmconsbtn() throws InterruptedException
	{
		WebElement elem=this.itmconsumdaddnewbtn;
		try {
		this.itmconsumdaddnewbtn.click();
		Thread.sleep(2000);
		logger.info("-------click Add new button-----");
		}
		catch(Exception ex)
		{
		
			js=new JavascriptHelper(driver);
			js.scrollUpByPixel();
			js.scrollToElemet(elem);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();",elem);
			Thread.sleep(2000);
			//elem.click();
			
			logger.info("-------click Add new button-----");
		}
	}
	public void selconsumeditems() throws InterruptedException
	{
		//js=new JavascriptHelper(driver);
		//js.scrollDownByPixel();
		List< WebElement>listitms=driver.findElements(By.xpath("//*[@id='consumed_item_id']//option"));
		int cntitmcon=listitms.size();
		logger.info("---Total items for consumption----"+cntitmcon);
		List< WebElement>listitmrates=driver.findElements(By.xpath("//*[@id='consumed_item_rate']//option"));
		int ratecnt=listitmrates.size();
		logger.info("---Total items for consumption----"+cntitmcon);
		/*DropdownHelper dpsel=new DropdownHelper(driver);
		WebElement elem=driver.findElement(By.xpath("//*[@id='consumed_item_id']"));
		dpsel.SelectUsingIndex(elem, 1);*/
		for(int i=1;i<=3;i++)
		{
			//for(int j=1;j<=ratecnt;j++)
			//{
			WebElement elem,elem1,itmcns;
			if(i==1)
			{
			 elem=driver.findElement(By.xpath("//*[@id='consumed_item_id']"));
			 elem1=driver.findElement(By.xpath("//*[@id='consumed_item_rate']"));
			 itmcns=driver.findElement(By.xpath ("//*[@id='DailyWorkProgress_consumed_item_count']"));
			 js=new JavascriptHelper(driver);
				js.scrollToElemet(elem);
				DropdownHelper dpsel=new DropdownHelper(driver);
				dpsel.SelectUsingIndex(elem, i);
				Thread.sleep(2000);
				logger.info("--------Item selected-----");
				js=new JavascriptHelper(driver);
				js.scrollToElemet(elem1);
				Thread.sleep(2000);
				DropdownHelper dpsel1=new DropdownHelper(driver);
				dpsel.SelectUsingIndex(elem1, 1);
				Thread.sleep(2000);
				logger.info("------Select rate----------");
			}
			else 
			{
				int c;
				int	j;
				j=i-1;
				
					if(i==2)
					{
						c=i-1;
						elem=driver.findElement(By.xpath("//*[@id='consumed_item_id_"+c+"']"));
						Thread.sleep(2000);
					}
					else {
							c=j;
							elem=driver.findElement(By.xpath("//*[@id='consumed_item_id_"+c+"']"));
							Thread.sleep(2000);
						}
			
				 elem1=driver.findElement(By.xpath("//*[@id='consumed_item_rate_"+j+"']"));
				 itmcns=driver.findElement(By.xpath ("//*[@id='DailyWorkProgress_consumed_item_count_"+j+"']"));
				 js=new JavascriptHelper(driver);
					js.scrollToElemet(elem);
					DropdownHelper dpsel=new DropdownHelper(driver);
					dpsel.SelectUsingIndex(elem, i);
					Thread.sleep(2000);
					logger.info("--------Item selected-----");
					js=new JavascriptHelper(driver);
					js.scrollToElemet(elem1);
					Thread.sleep(2000);
					DropdownHelper dpsel1=new DropdownHelper(driver);
					dpsel.SelectUsingIndex(elem1, 1);
					Thread.sleep(2000);
					logger.info("------Select rate----------");
			}
			js.scrollToElemet(itmcns);
			Thread.sleep(2000);
			itmcns.sendKeys(""+1);
			logger.info("---------Enter number of Item  consumed-------------");
			clickAddnewitmconsbtn();
			Thread.sleep(2000);
		
		}
		
	}
	/*

	
	 ;
	
	
@FindBy(xpath ="")public WebElement  ;

@FindBy(xpath ="")public WebElement  ;
@FindBy(xpath ="")public WebElement  ;
@FindBy(xpath ="")public WebElement  ;
@FindBy(xpath ="")public WebElement  ;
*/
	@FindBy(xpath ="//*[@id='labour_type']")public WebElement labrtype ;
	@FindBy(xpath ="//*[@id='labour_type_1']")public WebElement labrtype1 ;
	@FindBy(xpath ="//*[@id='labour_count']")public WebElement lbrcnt  ;
	@FindBy(xpath ="//*[@id='labour_wage']")public WebElement lbrwage ;
	@FindBy(xpath ="//*[@id='add_new']")public WebElement Addnewlbr ;
	public void sellbrtype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(labrtype, 1);
		logger.info("-------select labour type--------");
	}
	public void sellbrtype1()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(labrtype1, 2);
		logger.info("-------select nextlabour type--------");
	}
	public void typelbrcnt()
	{
		this.lbrcnt.sendKeys(""+2);
		logger.info("-------enter labour count--------");
	}
	public void typelbrwage()
	{
		this.lbrwage.sendKeys(""+100);
		logger.info("-------enter labour wage--------");
	}
	public void clickAddnew()
	{
		this.Addnewlbr.click();
		logger.info("---------click Add new labour-----------");
	}
	public void typewprquantity()
	{
		this.wprquantity.sendKeys(""+2);
	}
	public void clickwprimagebtn()
	{
		this.wprimguploadbtn.click();
	}
}
