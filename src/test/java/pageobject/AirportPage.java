package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.AirportPageUI;
import utility.Logs;

public class AirportPage {
	//This are global variable to use over the program
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	//This AirportPage constructor 
	public AirportPage() {
		helper = new WebDriverHelper();//creating object of WebDriverHelper class to use the methods which are present in that 
		loggerUtil = new Logs();// creating object of  Logs class to utilize the functions in that class
	}

	
	//This method clicks on Airport option
	public void ClickOnAirport() {
		log = loggerUtil.createLog("AirportPage.java");//calling log function from 'Logs' class
		try {
			helper.actionClick(AirportPageUI.airport);//this method clicks on Airport  //i am calling actionClick() method from WebDriverhelper class
			log.debug("Clicked on Airport under service section");//prints a message if airport is cliked
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on Airport under service section");//prints a message if airport is not clicked
		}
	}

	//This method is used to switch the current window
	public void Switchtab(int i) {
		try {
			helper.switchHandles(i);//calling this method from WebDriverHelper class
			log.debug("Switched to new Tab");
		} catch (Exception e) {
			log.debug("Cannot Switched to new Tab");
		}
	}

	//This method selects the source input and sends the data
	public void SelectSrc(String source) {
		try {
			helper.sendText(AirportPageUI.src, source);//calling sendText()method from WebDriverHelper class to send the source data
			helper.applicationWait(5000);//this method is created in WebdriverHelper class. this method waits for 5 seconds
			helper.actionClick(AirportPageUI.srcclick);//this method clicks on the source input //actionClick() id created in WebdriverHelper class
			log.debug("Source location filled");// prints if text is sent
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Source location");//prints if unable to send text
		}
	}

	//This method selects the destination input and send the data 
	public void SelectDest(String Destination) {
		try {
			helper.sendText(AirportPageUI.dest, Destination);//this method sends the text //sendText()  method is calling from WebDriverHelper class
			helper.applicationWait(5000);//this method waits for 5 seconds
			helper.actionClick(AirportPageUI.destclick);//this method clicks on destination input after sendimg data // actionClick()  is created on WebDriverHelper class
			log.debug("Destination location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Destination location");
		}
	}

	//this method is used to select the trip type from dropdown
	public void SelectTripType() {
		try {
			helper.selectByIndex(AirportPageUI.trip, 2);//this method selects the value through index value //selectByIndex() is created in WebDriverHelper class
			log.debug("TripType  selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select TripType ");
		}
	}

	
	//This method is picks the date from webPage
	public void SelectDate(String Month,String Date) {
		try {
			helper.actionClick(AirportPageUI.datepicker);//clicks on the date //actionClick() is created in WebdriverHelper class
			helper.applicationWait(5000);
			helper.Datepicker(AirportPageUI.mon, Month,
					AirportPageUI.nxt,
					AirportPageUI.date, Date);//This method picks the date from webPage//Datepicker() is created in WebDriverHelper class
			log.debug("Date  selected");//prints if date is selects
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select Date ");// prints if date is not selected
		}
	}

	
	//This method select the pickUp time from WebPage
	public void SelectPickuptime(String time) {
		try {
			helper.selectByText(AirportPageUI.pickup,time );//selects the time using text //selectByText() is ceated in webDriverHelper class
			log.debug("Pickuptime  selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Pickuptime ");
		}
	}

	// this method clicks on SearchCar button
	public void ClickOnSearchCar() {
		try {
			helper.actionClick(AirportPageUI.searchcar);
			log.debug("SearchCar Clicked");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Click SearchCar ");
		}
	}

	
	//this method selects the first car from the page
	public void SelectFirstCar() {
		try {
			helper.applicationWait(5000);
			helper.actionClick(AirportPageUI.firstcar);
			log.debug("First Car Selected in the result page");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Select Car ");//prints if car is not selected
		}
	}

	
	// this method is used to validate the Expected price is matching the Actual price
	public void ValidateCarDetails(String Expectedprice) {
		try {
			helper.applicationWait(5000);
			String Actualprice = helper.getText(AirportPageUI.price);
			if (Actualprice.contains(Expectedprice)) {
				log.info("Price Validated : " + Actualprice);//prints if Actual price matches with the Expected price
			} else {
				log.info("Price Validation Failed : " + Actualprice);//prints if Actual price is not equal to Expected result
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate Car Details");
		}
	}
}
