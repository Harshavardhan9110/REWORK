package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import WebElements.OneWayPageUI;
import utility.Logs;

public class OneWayPage {
	//this are global variables
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	//This is the constructor of OneWayPage
	public OneWayPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	//This method clicks the OneWay option
	public void ClickOnOneWay() {
		log = loggerUtil.createLog("OneWayPage.java");
		try {
			helper.actionClick(OneWayPageUI.oneway);//clicked on OneWay option //calling actionClick() from WebDriverHelper class
			log.debug("Clicked on OneWayPage under service section");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on OneWayPage under service section");
		}
	}

	//this method is used to switch the window
	public void Switchtab(int i) {
		try {
			helper.switchHandles(i);
			log.debug("Switched to new Tab");
		} catch (Exception e) {
			log.debug("Cannot Switched to new Tab");
		}
	}

	//This method selects the Agra from Dropdown
	public void SelectAgra() {
		try {
			helper.applicationWait(5000);
			helper.clickButton(OneWayPageUI.agra);//clicks on Agra
			log.debug("Dropdown clicked");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot click Dropdown");
		}
	}

	//This method selects the shikohabad after clicking on Agra
	public void SelectPlace() {
		try {
			helper.actionClick(OneWayPageUI.place);//selects the Shikohabad 
			log.debug("Agra to Shikohabad one-way-cabs selected");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select");
		}
	}

	//this method validates the expected title is equals to actual title
	public void ValidatePage(String ExpectedTitle) {
		try {
			helper.applicationWait(5000);
			String ActualTitle = helper.getTitle();//grabs the Title from the page
			if (ActualTitle.contains(ExpectedTitle)) {
				log.info("Title Validated : " + ActualTitle);//prints only if ActualTitle is equals to ExpextedTitle
			} else {
				log.info("Title Validated Failed : " + ActualTitle);//prints only if ActualTitle is not equals to ExpextedTitle
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate");
		}
	}
}
