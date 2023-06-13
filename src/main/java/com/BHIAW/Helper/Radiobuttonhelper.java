package com.BHIAW.Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Radiobuttonhelper {
	private WebDriver driver;
	private Logger Log = LoggerHelper.getLogger(Radiobuttonhelper.class);

	public Radiobuttonhelper(WebDriver driver) {
		this.driver = driver;
		Log.debug("Radiobuttonhelper : " + this.driver.hashCode());
	}

	public void clickradiobutton(WebElement element)
	{
		element.click();
		Log.info("Locator : " + element );
	}
	public void SelectUsingVisibleValue(WebElement element,String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		Log.info("Locator : " + element + " Value : " + visibleValue);
	}

}
