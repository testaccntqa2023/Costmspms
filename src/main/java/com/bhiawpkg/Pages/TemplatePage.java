package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.Today;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;

public class TemplatePage {
	WebDriver driver;
	JavascriptHelper js;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(TemplatePage.class);
	public TemplatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
	@FindBy(xpath = "//li//a[text()='Settings']") public WebElement settingsmenu;
	@FindBy(xpath = "//a[text()='Template']") public WebElement template;
	@FindBy(xpath = "//a[text()='New Template']") public WebElement newtemplatebtn;
	@FindBy(xpath = "//*[@id='Template_template_name']") public WebElement newtemplatename;
	@FindBy(xpath = "//*[@id='Template_item_name']") public WebElement tmpitemname;
	@FindBy(xpath = "//*[@id='template_purchase_item']") public WebElement tmppuritems;
	@FindBy(xpath = "//*[@id='Template_reference_column0']") public WebElement tmprefcolumn;
	@FindBy(xpath = "//*[@id='add_new']") public WebElement addtmprow;
	@FindBy(xpath = "//*[@id='save_btn']") public WebElement createbtn;
	/*
	
	
	@FindBy(xpath = "") public WebElement
	@FindBy(xpath = "") public WebElement
	@FindBy(xpath = "") public WebElement
	@FindBy(xpath = "") public WebElement
	@FindBy(xpath = "") public WebElement
	@FindBy(xpath = "") public WebElement
	*/
	public void clicksettingsmenu()
	{
		this.settingsmenu.click();
	}
	public void clickTemplate()
	{
		this.template.click();
	}
	public void clicknewtemplate()
	{
		this.newtemplatebtn.click();
	}
	public void typetemplatename()
	{
		this.newtemplatename.sendKeys("TMP"+RandomStringUtils.randomNumeric(3));
	}
	public void typetmpitemname()
	{
		this.tmpitemname.sendKeys("Item"+RandomStringUtils.randomNumeric(2));
	}
	public void typetmprefcolumn()
	{
	this.tmprefcolumn.sendKeys(""+RandomStringUtils.randomAlphabetic(1));	
	}
	public void selectpuritems()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.tmppuritems, 1);
	}
	public void clickcreatebtn()
	{
		
		this.createbtn.click();
	}
	public String Getlatesttemplatename() throws InterruptedException
	{
		Boolean status=true;
		js=new JavascriptHelper(driver);
		String templatename=null;
		clicksettingsmenu();
		Thread.sleep(2000);
		clickTemplate();
		
		
		Thread.sleep(2000);
		while(status==true)
		{
			WebElement nxtelem=driver.findElement(By.xpath("//a[text()='Next ']"));
			js.scrollDownByPixel();
		if(nxtelem.isDisplayed())
		{
			//nxtelem.click();
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", nxtelem);
			Thread.sleep(2000);
			
		}
		else
		{
			status=false;
		}
		}
		int rawcnt=driver.findElements(By.xpath("//table//tbody//tr")).size();
		templatename=driver.findElement(By.xpath("//table//tbody//tr["+rawcnt+"]//td[2]")).getText();
		return templatename;
	}
	public void clickaddtmprow()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", this.addtmprow);
		
	}
	public void addtemplateitems() throws InterruptedException
	{
		JavascriptHelper js=new JavascriptHelper(driver);
		for(int i=1;i<=2;i++)
		{
		clickaddtmprow();
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]"
				+ "/div[1]/div[1]/div[2]/div[2]/div["+i+"]/div[1]/input[1]")).sendKeys("steel"+RandomStringUtils.randomAlphabetic(1));
		driver.findElement(By.xpath("//input[@id='Template_reference_column"+i+"']")).sendKeys("A"+RandomStringUtils.randomNumeric(1));
		
		WebElement elem= driver.findElement(By.xpath("//*[@id='template_purchase_item_"+i+"']"));
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(elem, (i+1));
		//selectpuritems();
		}
		
		Thread.sleep(2000);
		 
		js.scrollDownByPixel();
	}
}
