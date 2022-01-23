package pageobject;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.HomepageUI;
import utility.Logs;

public class Homepage {
	//This are global variables 
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	//This is HomePage constructor
	public Homepage() {
		helper = new WebDriverHelper();//created object for WebDriverHelper Class to utilize the methods which are present in that
		loggerUtil = new Logs();//created object for Logs class to use the methods in that class
	}

	//This method is created to validate the Title
	public void ValidateTitle(String string) {
		log = loggerUtil.createLog("Homepage.java");//calling createlog() from Logs class
		String ActualTitle = helper.getTitle();//grabs the Actual Title from the page 
		String ExpectedTitle = string;
		Assert.assertEquals(ExpectedTitle, ActualTitle);//it passes if the actual Title is matches with the expected Title
		log.debug("Homepage Title Validated");
	}

	//This method is used to Register the page
	public void SignUp(String string, String string2, String string3, String string4, String string5) {
		try {
			helper.clickButton(HomepageUI.signin);//clicks on the signin button //calling clickButton() from webDriverhelper class
			helper.clickButton(HomepageUI.register);//clicks on the register button //calling clickButton() from webDriverhelper class

			helper.sendText(HomepageUI.username, string);//sends UserName into input field //calling sendText() from WebDriverHelper class
			helper.sendText(HomepageUI.phone, string2);//sends PhoneNum into input field //calling sendText() from WebDriverHelper class
			helper.sendText(HomepageUI.email, string3);//sends Email into input field //calling sendText() from WebDriverHelper class
			helper.sendText(HomepageUI.pass, string4);//sends Password into input field //calling sendText() from WebDriverHelper class
			helper.sendText(HomepageUI.repass, string5);//sends ReEnterPassword into input field //calling sendText() from WebDriverHelper class
			helper.clickButton(HomepageUI.submit);//clicks on the submit button //calling clickButton() from webDriverhelper class
			log.info("User Succesfully Registered");//prints if registration is Successful
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.info("Failed to SignUp");
		}
	}

	//This method is created to validate the functionality of login page
	public void Login(String string, String string2) {
		try {
			helper.clickButton(HomepageUI.signin);//clicks on the SignIn button //calling clickButton() from webDriverhelper class

			helper.sendText(HomepageUI.email, string);//sends Email into input field //calling sendText() from WebDriverHelper class
			helper.sendText(HomepageUI.pass, string2);//sends Password into input field //calling sendText() from WebDriverHelper class

			helper.clickButton(HomepageUI.submit);//clicks on the Submit button //calling clickButton() from webDriverhelper class
			log.info("User Succesfully Loggged in");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.info("User Failed to Loggged in");
		}
	}
}
