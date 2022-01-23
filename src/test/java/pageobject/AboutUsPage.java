package pageobject;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.BaseTest;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.AboutUsPageUI;
import utility.Logs;

public class AboutUsPage extends BaseTest {
	//this are the global variables to utilize in the program
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	
	//this is a AboutUsPage constructor
	public AboutUsPage() {
		helper = new WebDriverHelper();//here WebDriverHelper object is created to utilize the methods which i created in WebDriverhelper class
		loggerUtil = new Logs();   //creating Logs object to use log functionalities  
	}

	
	//This method is created to click on the AboutUs link
	public void ClickOnAbout() {
		log = loggerUtil.createLog("AboutUsPage.java"); //calling log method which i created in 'Logs' class to use log functionalities
		try {
			helper.clickButton(AboutUsPageUI.aboutus); //This method is used clicking on 'AboutUs' link   //here i am calling clickButton method which oi created in WebDriverHelper class
			log.debug("About Us Clicked");//This message prints when aboutus page is clicked
			test.log(Status.PASS, "About Us Clicked");
		} catch (WebDriverHelperException e) {
			log.debug("Cannot Click About Us");  //This message will prints if AboutUs is not clicked
			test.log(Status.FAIL, "Cannot Click About Us ");
		}
	}

	//This method is used to switch from one window to another
	public void Switchtab(int i) {
		try {
			helper.switchHandles(i);//calling this method from WebDriverhelper class
			log.debug("Switched to new Tab");
		} catch (Exception e) {
			log.debug("Cannot Switched to new Tab");
		}
	}

	
	//This method is used to validate weather the Actual CEO name is matching with the Expected CEO name
	public void Validate(String ExpectedCeoName) {
		try {
			String ActualCeoName = helper.getText(AboutUsPageUI.ceo);//This method gets the actual text present in the webPage // i am calling getText()method from WebDriverHelper class
			if (ActualCeoName.contains(ExpectedCeoName)) {
				log.debug("CeoName  Validated : " + ActualCeoName);//if actual name matches with the expected one then it prints this message
			}
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
		}
	}
}
