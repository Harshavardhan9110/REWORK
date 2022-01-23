package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.LocalPageUI;
import utility.Logs;

public class LocalPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	//This is constructor of LocalPage class
	public LocalPage() {
		helper = new WebDriverHelper();//created object for WebDriverHelper Class to utilize the methods which are present in that
		loggerUtil = new Logs();//created object for Logs class to use the methods in that class
	}

	//This method clicks on local option
	public void ClickOnLocal() {
		log = loggerUtil.createLog("LocalPage.java");
		try {
			helper.actionClick(LocalPageUI.local);//clicks on the Local option //calling actionClick() from WebDriverHelper class
			log.debug("Clicked on Local under service section");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on Local under service section");
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

	//This selects the source input field and sends the data into that
	public void SelectSrc(String string) {
		try {
			helper.sendText(LocalPageUI.src,string );//sends sourceLocation into input field //calling sendText() from WebDriverHelper class
			helper.applicationWait(5000);
			helper.clickButton(LocalPageUI.srcclick);//clicks on the source after sending the location //calling clickButton() from webDriverhelper class
			log.debug(" location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill  location");
		}
	}

	//This method selects the Date from the page 
	public void SelectDate(String Month,String Date) {
		try {
			helper.actionClick(LocalPageUI.datepicker);//clicks on the datePicker //calling actionClick() from WebDriverHelper class
			helper.applicationWait(5000);
			helper.Datepicker(LocalPageUI.mon, Month,
					LocalPageUI.nxt,
					LocalPageUI.date, Date); //selects the desired date and month from thr page //calling Datepicker() method from WebDriverHelper class
			log.debug("Date  selected");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select Date ");
		}
	}

	//this method selects the desired time slot to travel
	public void SelectPickuptime(String string) {
		try {
			helper.selectByText(LocalPageUI.pickup, string);//selects the desired time //calling SelectByText() from WebDriverHeper class
			log.debug("Pickuptime  selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Pickuptime ");
		}
	}

	//this method clicks on the SearchCar button
	public void ClickOnSearchCar() {
		try {
			helper.actionClick(LocalPageUI.searchcar);//clicks onSearchCar //calling actionClic() from WebDriverHelper class
			log.debug("SearchCar Clicked");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Click SearchCar ");
		}
	}

	//This method selects the first car after clicking on Searchcar option
	public void SelectFirstCar() {
		try {
			helper.applicationWait(5000);
			helper.actionClick(LocalPageUI.firstcar);//selects the first Car 
			log.debug("First Car Selected in the result page");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Select Car ");
		}
	}

	//this method validate the ExpectedPprice is matching with the ActualPrice or not
	public void ValidateCarDetails(String ExpectedCarType) {
		try {
			helper.applicationWait(5000);
			String ActualCarType = helper.getText(LocalPageUI.type);//grabs the price from page
			if (ActualCarType.contains(ExpectedCarType)) {
				log.info("CarType Validated : " + ActualCarType);//prints if the ActuaPrice matches with the expected one

			} else {
				log.info("CarType Validation Failed : " + ActualCarType);//prints if the ActuaPrice not matches with the expected one

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate Car Details");
		}
	}
}
