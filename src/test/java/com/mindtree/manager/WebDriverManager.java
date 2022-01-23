package com.mindtree.manager;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ConfigReader;
import utility.Logs;

public class WebDriverManager {

	public  static WebDriver driver;
	public  Properties properties;
	ConfigReader configReader;
	Logs logUtil;
	Logger log;

	
	
	public WebDriverManager() {
		configReader = new ConfigReader();
		properties = configReader.getProperties();
		logUtil = new Logs();
	}

	
	//this method is created to call the browser and initializing the path of the driver
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", properties.getProperty("driverpath"));//sets the driver path which is present in properties file
		driver = new ChromeDriver();  ///creating chromeDriver class object
		log = logUtil.createLog("BaseClass.class");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  //creating the implicit wait 
		driver.manage().window().maximize();  // maximizing the window browser
		//if driver is not present then it prints a message
		if (driver == null) {
			log.fatal("Driver not found");
		}
		return driver;
	}

}
