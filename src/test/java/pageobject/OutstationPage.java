package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.OutstationPageUI;
import utility.Logs;

public class OutstationPage {
	//this are global variables
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	//This is the constructor of OutstationPage
	public OutstationPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	//this method is used to send the desired Source location into the input Field
	public void SelectSrc(String string) {
		try {
			log = loggerUtil.createLog("OutstationPage.java");
			helper.sendText(OutstationPageUI.src,string );//sends the desired location into the input
			helper.applicationWait(5000);
			helper.actionClick(OutstationPageUI.srcclick);//clicks after sending the text
			log.debug("Source location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Source location");
		}
	}

	//this method is used to send the desired destination location into the input Field
	public void SelectDest(String string) {
		try {
			helper.sendText(OutstationPageUI.dest,string);//sends the desired location into the input
			helper.applicationWait(5000);
			helper.actionClick(OutstationPageUI.destclick);//clicks after sending the text
			log.debug("Destination location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Destination location");
		}
	}
	
//This method selects the date from webPage
	public void SelectDate(String Month,String Date) {
		try {
			helper.actionClick(OutstationPageUI.datepicker);//clicks on date option
			helper.applicationWait(5000);
			helper.Datepicker(OutstationPageUI.mon, Month,
					OutstationPageUI.nxt,
					OutstationPageUI.date, Date);//selects date and month from datePicker //calling Datepicker() from WebDriverHelper class
			log.debug("Date  selected");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select Date ");
		}
	}
	
//this method selects the desired Time slot
	public void SelectPickuptime(String string) {
		try {
			helper.selectByText(OutstationPageUI.pickup,string );//selects the time 
			log.debug("Pickuptime  selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Pickuptime ");
		}
	}
	
//This method clicks on SearchCar button
	public void ClickOnSearchCar() {
		try {
			helper.actionClick(OutstationPageUI.searchcar);//clicks on searchCar button
			log.debug("SearchCar Clicked");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Click SearchCar ");
		}
	}

	//this method selects the firstCar after clicking on SearchCar button
	public void SelectFirstCar() {
		try {
			helper.applicationWait(5000);
			helper.actionClick(OutstationPageUI.firstcar);//selects firstCar
			log.debug("First Car Selected in the result page");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Select Car ");
		}
	}

	//this method validates the ExpextedPrice matches with the ActualPrice
	public void ValidateCarDetails(String Expectedprice) {
		try {
			helper.applicationWait(5000);
			String Actualprice = helper.getText(OutstationPageUI.price);//grabs the actual price from page
			if (Actualprice.contains(Expectedprice)) {
				log.info("Price Validated : " + Actualprice);//prints if matches
			} else {
				log.info("Price Validation Failed : " + Actualprice);// prints if not matches
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate Car Details");
		}
	}
}
