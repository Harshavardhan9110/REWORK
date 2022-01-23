package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.CorporateCarRentalPageUI;
import utility.Logs;

public class CorporateCarRentalPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

//constructor of CorporateCarRentalPage
	public CorporateCarRentalPage() {
		helper = new WebDriverHelper();//created object for WebDriverHelper Class to utilize the methods which are present in that
		loggerUtil = new Logs();//created object for Logs class to use the methods in that class
	}

	//This method Clicks on the CorporateCarRental link
	public void ClickOnCorporateCarRental() {
		log = loggerUtil.createLog("CorporateCarRental.java");
		try {
			helper.actionClick(CorporateCarRentalPageUI.corporate);//clicks on the  CorporateCarRental link
			log.debug("Clicked on CorporateCarRental under service section");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on CorporateCarRental under service section");
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

	//This method is used to send the text to Name input field
	public void EnterName(String name) {
		try {
			helper.sendText(CorporateCarRentalPageUI.name, name);//sends the data into the input fiel
			log.debug("Name Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Enter Name");
		}
	}

	
	//This method is used to send the caompanyName into input field
	public void EnterCompany(String company) {
		try {
			helper.sendText(CorporateCarRentalPageUI.company, company);//sends the company Name into the input field
			log.debug("Company name Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Company name");
		}
	}

	//This method is used to send the email details into the input Filed
	public void EnterEmail(String email) {
		try {
			helper.sendText(CorporateCarRentalPageUI.email, email);//sends an email address to the input field
			log.debug("Email  Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Email");
		}
	}

	//This method is used to send the phoneNum into input field
	public void EnterPhoneNo(String Phone) {
		try {
			helper.sendText(CorporateCarRentalPageUI.phoneno, Phone);//sends the phoneNum to input field
			log.debug("Phone no Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Phone no");
		}
	}

	//This method is used to select the required business value
	public void SelectRentalReq(String req) {
		try {
			helper.selectByValue(CorporateCarRentalPageUI.req,req);//selects the desired value from the dropdown
			log.debug("Rental Requirment Selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Rental Requirment ");
		}
	}

	//This method used to click on submit button
	public void ClickSubmit() {
		try {
			helper.actionClick(CorporateCarRentalPageUI.submit);//clicks on the submit button
			log.debug("Submit button Clicked");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click Submit button ");
		}
	}

	//this method id used to validate the Actual msg is matching with the Expected one
	public void ValidateMSG() {
		try {
			helper.applicationWait(5000);
			log.info(helper.getText(CorporateCarRentalPageUI.msg));//grabs the message from the page
			log.debug("MSG validated");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot validate MSG");
		}
	}
}
