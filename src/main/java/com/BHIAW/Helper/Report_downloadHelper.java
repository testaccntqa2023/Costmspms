package com.BHIAW.Helper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class Report_downloadHelper {
	private static Logger log=LoggerHelper.getLogger(Report_downloadHelper.class);
	File folder;
	/*public void GetAllGridvalues()
	{
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		ChromeOptions options=new ChromeOptions();
		Map<String, Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
	}*/


}
