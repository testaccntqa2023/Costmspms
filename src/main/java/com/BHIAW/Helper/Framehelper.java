package com.BHIAW.Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Framehelper {
	private WebDriver driver;
	private Logger oLog = Logger.getLogger(Framehelper.class);
	
	public Framehelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("Framehelper : " + this.driver.hashCode());
	}
	
	
	public void switchtoframe(WebElement frame)
	{
		this.driver.switchTo().frame(frame);
	}

}
