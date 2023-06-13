package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;

public class MonthlyTaskPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(MonthlyTaskPage.class);
	public MonthlyTaskPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[@id='project_id']")public WebElement selpjtmnthlytsk;
	@FindBy(linkText ="Monthly Task")public WebElement mnthlytskmenu;
	@FindBy(xpath ="//input[@value='Go']")public WebElement Gobtn;
	@FindBy(xpath ="//a[text()='Add  Task']")public WebElement AddTaskbtn1;
	@FindBy(xpath ="//tbody//tr[2]/td[2]/div[2]/a[1]")public WebElement AddTaskbtn;
	
/*

	@FindBy(xpath ="")public WebElement
	@FindBy(xpath ="")public WebElement
	@FindBy(xpath ="")public WebElement
	@FindBy(xpath ="")public WebElement
	@FindBy(xpath ="")public WebElement
	@FindBy(xpath ="")public WebElement
	@FindBy(xpath ="")public WebElement
*/	
	
	public void clickmonthlytsk()
	{
		this.mnthlytskmenu.click();
	}
	public void selpjtmnthlytskmenu(String mnthlytsk)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(selpjtmnthlytsk, mnthlytsk);
	}
	public void clickGobtn()
	{
		this.Gobtn.click();
	}
	public void clickAddtaskbtn()
	{
		Actions act=new Actions(driver);
		act.moveToElement(this.AddTaskbtn);
		this.AddTaskbtn.click();
	}
	
}
