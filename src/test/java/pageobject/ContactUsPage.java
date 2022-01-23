package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.ContactUsPageUI;
import utility.Logs;

public class ContactUsPage {
	//This are global variables 
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	//this is constructor of ContactUs Page
	public ContactUsPage() {
		helper = new WebDriverHelper();//created object for WebDriverHelper Class to utilize the methods which are present in that
		loggerUtil = new Logs();//created object for Logs class to use the methods in that class
	}

	//This method clicks on ContactUs link
	public void ClickOnContactUs() {
		log = loggerUtil.createLog("ContactUsPage.java");//calling method from Logs class
		try {
			helper.actionClick(ContactUsPageUI.contactus);//clocks on the ContactUs link //calling actionClick() from WebDriverHelper class
			log.debug("Contact Us Clicked");//prints if contactUs is clicked
		} catch (WebDriverHelperException e) {
			log.debug("Cannot Click Conatct Us Clicked");// prints if ContactUs is not able to click
		}
	}

	
	//this method is used used to switch the windows
	public void Switchtab(int i) {
		try {
			helper.switchHandles(i);
			log.debug("Switched to new Tab");
		} catch (Exception e) {
			log.debug("Cannot Switched to new Tab");
		}
	}

	//This method is to validate the ExpectedContactNum is matching with the actual one
	public void Validate(String ExpectedContactNo) {
		try {
			String ActualContactNo = helper.getText(ContactUsPageUI.phoneno);//gets the texts from webPage //calling getText() from WebDriverHelper class
			if (ActualContactNo.contains(ExpectedContactNo)) {
				log.info("Contact No Validated : " + ActualContactNo);//prints if its matches with the expected one
			} else {
				log.info("Validation Failed");//prints if actual one is not matches with expected one
			}
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.info("Cannot Validate");
		}
	}
}
