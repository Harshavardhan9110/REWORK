package com.mindtree.reusable;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.mindtree.manager.WebDriverManager;

import utility.Logs;

public class BaseTest extends WebDriverManager {
	//initializing global variables which are used in this class frequently
	 WebDriverManager driverManager;
	WebDriverHelper Helper;
	static Logs loggerUtil;
	static Logger log;
	public static ExtentTest test;

	
	//this method is used  call the browser
	public void startUp() {
		loggerUtil = new Logs();  //creating log object to call the methods which are present in 'Logs' class 
		log = loggerUtil.createLog("Hooks.class");//calling method which i created in the Logs class
		log.debug("Opening driver");  
		driverManager = new WebDriverManager();  //creating object of WebDriverManager to call the browser
		driver= driverManager.getDriver(); //calling method to initialize the browser
		log.info("Driver opened");
		driver.get(properties.getProperty("url"));  // calling url from the properties file 
		log.debug("Opening URL");
	}

	
	//this method close the browser
	public  void tearDown() {
		log.info("Driver closed");
		driver.quit();
	}
	
	
	//this method is created to capture the screenshot
	public static String getscreenshotpath(String TestCaseName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String target = (System.getProperty("user.dir") + "/Screenshot/" + TestCaseName+System.currentTimeMillis() + ".png");
		File file=new File(target);
		FileUtils.copyFile(source, file);
		return target;
	}

}
