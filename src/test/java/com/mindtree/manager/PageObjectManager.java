package com.mindtree.manager;

import pageobject.Homepage;
import pageobject.AboutUsPage;
import pageobject.AirportPage;
import pageobject.ContactUsPage;
import pageobject.CorporateCarRentalPage;
import pageobject.LocalPage;
import pageobject.OneWayPage;
import pageobject.OutstationPage;


public class PageObjectManager extends WebDriverManager{
	private Homepage Homepage;
	private AboutUsPage AboutUsPage;
	private AirportPage AirportPage;
	private ContactUsPage ContactUsPage;
	private CorporateCarRentalPage CorporateCarRentalPage;
	private LocalPage LocalPage;
	private OneWayPage OneWayPage;
	private OutstationPage OutstationPage;

	
	
	//this method is used  to create homepage object  if homepage object is not created
	public Homepage getHomePage() {
		return(Homepage==null) ? Homepage = new Homepage():Homepage;
	}
	
	//this method is used  to create AboutUsPage object  if AboutUsPage object is not created
	public AboutUsPage getAboutUsPage() {
		return(AboutUsPage==null) ? AboutUsPage = new AboutUsPage():AboutUsPage;
	}
	
	//this method is used  to create Airportpage object  if Airportpage object is not created
	public AirportPage getAirportPage() {
		return(AirportPage==null) ? AirportPage = new AirportPage():AirportPage;
	}
	
	//this method is used  to create Contact object  if Contact object is not created
	public ContactUsPage getContactUsPage() {
		return(ContactUsPage==null) ? ContactUsPage = new ContactUsPage():ContactUsPage;
	}
	
	//this method is used  to create CorporateCarRentalpage object  if CorporatecarRentalPage object is not created
	public CorporateCarRentalPage getCorporateCarRentalPage() {
		return(CorporateCarRentalPage==null) ? CorporateCarRentalPage = new CorporateCarRentalPage():CorporateCarRentalPage;
	}
	
	//this method is used  to create LocalPAge object  if LocalPage object is not created
	public LocalPage getLocalPage() {
		return(LocalPage==null) ? LocalPage = new LocalPage():LocalPage;
	}
	
	//this method is used  to create OneWaypage object  if OneWayPage object is not created
	public OneWayPage getOneWayPage() {
		return(OneWayPage==null) ? OneWayPage = new OneWayPage():OneWayPage;
	}
	
	//this method is used  to create OutStationPage object  if OutStationPage object is not created
	public OutstationPage getOutstationPage() {
		return(OutstationPage==null) ? OutstationPage = new OutstationPage():OutstationPage;
	}
}
