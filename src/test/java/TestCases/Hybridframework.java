package TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.reusable.BaseTest;

import pageobject.AboutUsPage;
import pageobject.AirportPage;
import pageobject.ContactUsPage;
import pageobject.CorporateCarRentalPage;
import pageobject.Homepage;
import pageobject.LocalPage;
import pageobject.OneWayPage;
import pageobject.OutstationPage;
import utility.ExcelSheetRead;
import utility.ExtentReporterNG;
import utility.Logs;


public class Hybridframework extends BaseTest {
	//creating global variables to use over the program
	static PageObjectManager pageManager;
	static Homepage homepage;
	static ContactUsPage contactpage;
	static AboutUsPage aboutpage;
	static CorporateCarRentalPage corporatepage;
	static OneWayPage onewaypage;
	static AirportPage airportpage;
	static OutstationPage outstationpage;
	static LocalPage localpage;
	static Logs loggerUtil;
	static Logger log;
	static ExcelSheetRead ex;
	static ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	static String screenshotPath = null;

	//This annotation executes before every method
	@BeforeMethod
	public void Before() throws IOException {
		startUp();//initializing the browsers where startUp() is invoking from 'BaseTest' class
		ex = new ExcelSheetRead(); //creating object for ExcelSheetRead class
	}

	
	//This  TestCase Validates the WebPage Title
	@Test(priority = 1)
	public static void TestCase1() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase1");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase1 Execution Started");
		
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test1") ;//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			homepage = pageManager.getHomePage();//getHomePage() method is called from PageObjectManager class
			String ExpectedTitle = ex.read("HomepageTitle");// reads the ExpectedTitle from ExcelSheet 
			homepage.ValidateTitle(ExpectedTitle);//validates the Titles // ValidateTitle() method called from 'HomePage' Class
			test.log(Status.PASS, "TestCase1 Successful");
			screenshotPath = getscreenshotpath("test1");//captures the screenshot // calling getscreenshotpath() from BaseTest class
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test1");//captures if the TestCase fails
			test.fail("test1 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase2 UnSuccessful");
		}
	}

	
	//This TestCase is created to Test the functionality of the Registration
	@Test(priority = 2)
	public static void TestCase2() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase2");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test 2");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			String Name = ex.read("Name");//Reading Name from the ExcelSheet
			String Phone = ex.read("Phone");//Reading PhoneNum from the ExcelSheet
			String Email = ex.read("Email");//Reading Email from the ExcelSheet
			String Password = ex.read("Password");//Reading Password from the ExcelSheet
			String RePassword = ex.read("RePassword");//Reading RePassword from the ExcelSheet
			homepage.SignUp(Name, Phone, Email, Password, RePassword);//Registering the site //SignUp() is called from 'HomePage' class
			test.log(Status.PASS, "TestCase2 Successful");
		
			screenshotPath = getscreenshotpath("test2");//captures the screenshot // calling getscreenshotpath() from BaseTest class
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test2");//captures the screenshot when estcase fails
			test.fail("test2 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase2 UnSuccessful");
		}
	}

//This TestCase to validate the functionality of login 
	@Test(priority = 3)
	public static void TestCase3() throws IOException, InterruptedException {
		try {
			
			test = extent.createTest("testCase3");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test3");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			String Email = ex.read("Email");//Reading Email from the ExcelSheet
			String Password = ex.read("Password");//Reading Password from the ExcelSheet
			homepage.Login(Email, Password); //Logging into  the site //Login() is called from 'HomePage' class
			test.log(Status.PASS, "TestCase3 Successful");
		
			screenshotPath = getscreenshotpath("test3");//captures the screenshot // calling getscreenshotpath() from BaseTest class

			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test3");//captures the screenshot when test fails
			test.fail("test3 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase3 UnSuccessful");
		}
	}

	//This TestCase is used to click on AboutUs link and validate the CEO name
  @Test(priority = 4)
	public static void TestCase4() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testcase4");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
		
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test4");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			aboutpage = pageManager.getAboutUsPage();//getAboutUsPage() method is called from PageObjectManager class
			aboutpage.ClickOnAbout();//clicks on AboutUs link //clickeOnAbout() method is called from 'AboutUsPage'page
			aboutpage.Switchtab(1);//switch to another window  //Switchtab() method is called from 'AboutUsPage'page
			String Expected = ex.read("CEO");//reads Expected data from ExcelSheet
			aboutpage.Validate(Expected);//validates the Expected CeoName with Actual CeoName //Validate() method is called from 'AboutUsPage'page
			test.log(Status.PASS, "TestCase4 Successful");
			extent.flush();
			screenshotPath = getscreenshotpath("test4");//captures the screenshot
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test4");
			test.fail("test4 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase4 UnSuccessful");
		}
	}

  //This TestCase is used to click on ContactUs link and validate Expected Contact is matching with Actual Contact
		@Test(priority = 5)
	public static void TestCase5() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase5");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test5");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			contactpage = pageManager.getContactUsPage();//getContactUsPage() method is called from PageObjectManager class
			contactpage.ClickOnContactUs();//clicks on ContactUs link //ClickOnContactUs() method is called from 'ContactUsPage' class
			contactpage.Switchtab(1);//switch to another window  //Switchtab() method is called from 'ContactUsPage' class
			String Contact = ex.read("Contact");//reads contact from ExcelSheet 
			contactpage.Validate(Contact);//validates the Expected contact with Actual contact //Validate() method is called from 'ContactUsPage' class
			test.log(Status.PASS, "TestCase5 Successful");
			
			screenshotPath = getscreenshotpath("test5");//captures the screenshot
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test5");
			test.fail("test6 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase5 UnSuccessful");
		}

	}
		
//This TestCase is used to click on OneWay Link and select Agra from DropDown and select src & dest and validates the title		

			@Test(priority = 6)
	public static void Testcase6() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase6");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test6");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			onewaypage = pageManager.getOneWayPage();//getOneWayPage() method is called from PageObjectManager class
			onewaypage.ClickOnOneWay();//clicks on OneWay link//ClickOnOneWay() method is called from 'OneWayPage' class
			onewaypage.Switchtab(1);//switch to another window  //Switchtab() method is called from 'OneWayPage' class
			onewaypage.SelectAgra();//selects Agra grom dropdown after clicking on OneWay link //SelectAgra() method is called from 'OneWayPage' class
			onewaypage.SelectPlace();//selects the Shikohabad location from dropdown //selectPlace() method is called from 'OneWayPage' class
			onewaypage.Switchtab(2);//switch to another window  //Switchtab() method is called from 'OneWayPage' class
			String Expected = ex.read("OneWay");// reads Expected Title from ExcelSheet
			onewaypage.ValidatePage(Expected);//validates the Expected Title is matching with the Actual Title //ValidatePage() method called from  'OneWayPage' class
			test.log(Status.PASS, "TestCase6 Successful");
			
			screenshotPath = getscreenshotpath("test6");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test6");
			test.fail("test6 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase6 UnSuccessful");
		}
	}
			
//This TestCase validates the functionality of Local cab booking
			 	@Test(priority = 7)
	public static void test7() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase7");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test7");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			localpage = pageManager.getLocalPage();//getLocalPage() method is called from PageObjectManager class

			localpage.ClickOnLocal();//clicks on OneWay link//ClickOnLocal() method is called from 'LocalPage' class
			localpage.Switchtab(1);//switch to another window  //Switchtab() method is called from 'LocalPage' class

			String Source = ex.read("Source");//reads source location from ExcelSheet
			String Month = ex.read("Month");//reads Month from ExcelSheet
			String Date = ex.read("Date").replace(".0", "");//selects date from excelSheet
			String Time = ex.read("Time");//reads Time from excelSheet
			String CarType = ex.read("CarType");//reads CarType from ExcelSheet

			localpage.SelectSrc(Source);//sends data to source //SelectSrc() method is called from 'LocalPage' class
			localpage.SelectDate(Month, Date);//selects date from Webpage //SelectDate() method is called from 'LocalPage' class
			localpage.SelectPickuptime(Time);//selects Time from Webpage //SelectPickuptime() method is called from 'LocalPage' class
			localpage.ClickOnSearchCar();//clicks on SearchCar Button//ClickOnSearchCar() method is called from 'LocalPage' class
			localpage.SelectFirstCar();//select firstCar from Webpage //SelectFirstCar() method is called from 'LocalPage' class
			localpage.ValidateCarDetails(CarType);//validates the Expected CarType is matching with the Actual CarType //ValidatePage() method called from  'LocalPage' class
			test.log(Status.PASS, "TestCase7 Successful");
		
			screenshotPath = getscreenshotpath("test7");//captures screenshot
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test7");
			test.fail("test7 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase7 UnSuccessful");	
		}
	}

		//TestCase to validate the functionality of outstation and selecting car	 	
  @Test(priority = 8)
	public static void test8() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase8");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test8");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class
			String Source = ex.read("Source");//reads source location from ExcelSheet
			String Destination = ex.read("Destination");//reads destination location from ExcelSheet
			String Month = ex.read("Month");//reads month from ExcelSheet
			String Date = ex.read("Date").replace(".0", "");//reads Date  from ExcelSheet
			String Time = ex.read("Time");//reads Time  from ExcelSheet
			String Outprice = ex.read("Outprice");//reads  Outprice from ExcelSheet

			outstationpage = pageManager.getOutstationPage();//getOutstationPage() method is called from PageObjectManager class
			outstationpage.SelectSrc(Source);//sends data to source //SelectSrc() method is called from 'outstationpage' class
			outstationpage.SelectDest(Destination);//sends data to Destination //SelectDest() method is called from 'outstationpage' class
			outstationpage.SelectDate(Month, Date);//selects date and month from WebPage//SelectDate() method is called from 'outstationpage' class
			outstationpage.SelectPickuptime(Time);//selects Time slot from WebPage//SelectPickuptime() method is called from 'outstationpage' class
			outstationpage.ClickOnSearchCar();//clicks on SearchCar Button//ClickOnSearchCar() method is called from 'outstationpage' class
			outstationpage.SelectFirstCar();//select firstCar from Webpage //SelectFirstCar() method is called from 'outstationpage' class
			outstationpage.ValidateCarDetails(Outprice);//validates the Expected Price is matching with the Actual Price //ValidatePage() method called from  'outstationpage' class
			
			test.log(Status.PASS, "TestCase8 Successful");
			
			screenshotPath = getscreenshotpath("test8");//captures screenshots
			
			} catch (Exception e) {
				screenshotPath = getscreenshotpath("test8");
				test.fail("test8 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				test.log(Status.FAIL, "TestCase8 UnSuccessful");	
		}

	}

   //TestCase to validate the functionality of Airport car booking
	@Test(priority = 9)
	public static void test9() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase9");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test9");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class

			String Source = ex.read("Source");//reads source location from ExcelSheet
			String AirportDest = ex.read("AirportDest");//reads destination location from ExcelSheet
			String Month = ex.read("Month");//reads month  from ExcelSheet
			String Date = ex.read("Date").replace(".0", "");//reads date from ExcelSheet
			String Time = ex.read("Time");//reads Time from ExcelSheet
			String Outprice = ex.read("Outprice");//reads price from ExcelSheet

			airportpage = pageManager.getAirportPage();//getAirportPage() method is called from PageObjectManager class
			airportpage.ClickOnAirport();//Clicking on Airport //ClickOnAirport() is called from 'AirportPage' class
			airportpage.Switchtab(1);//switching to another window //Switchtab()  is called from 'AirportPage' class
			airportpage.SelectSrc(Source);//sends data to source //SelectSrc() method is called from 'AirportPage' class
			airportpage.SelectTripType();//selects tripType from dropdown//SelectTripType() method is called from 'AirportPage' class
			airportpage.SelectDest(AirportDest);//sends data to destination //SelectSrc() method is called from 'AirportPage' class
			airportpage.SelectDate(Month, Date);//selects date from webPage //SelectDate()  method is called from 'AirportPage' class
			airportpage.SelectPickuptime(Time);//selects Time slot from WebPage//SelectPickuptime() method is called from 'AirportPage' class
			airportpage.ClickOnSearchCar();//clicks on SearchCar Button//ClickOnSearchCar() method is called from 'AirportPage' class
			airportpage.SelectFirstCar();//select firstCar from Webpage //SelectFirstCar() method is called from 'AirportPage' class
			airportpage.ValidateCarDetails(Outprice);//validates the Expected Price is matching with the Actual Price //ValidatePage() method called from  'AirportPage' class
			test.log(Status.PASS, "TestCase9 Successful");
		
			screenshotPath = getscreenshotpath("test9");//captures screenshot
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test9");
			test.fail("test9 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase9 UnSuccessful");
		}

	}

	//This TestCase validates the functionality of CorporateCarRental 
	@Test(priority = 10)
	public static void test10() throws IOException, InterruptedException {
		try {
			test = extent.createTest("testCase10");//calling createTest() method from ExtentReporterNG class
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();//creates an object for 'Logs' class
			log = loggerUtil.createLog("Test10");//generates log message //createLog() is called from 'Logs' class
			pageManager = new PageObjectManager();//creating object for PageObjectManager class

			String Name = ex.read("Name");//reads Name from ExcelSheet
			String Phone = ex.read("Phone");//reads PhoneNum from ExcelSheet
			String Email = ex.read("Email");//reads Email from ExcelSheet
			String Company = ex.read("Company");//reads Company from ExcelSheet
			String Req = ex.read("Req");//reads Required Businesss value from ExcelSheet

			corporatepage = pageManager.getCorporateCarRentalPage();//getCorporateCarRentalPage() method is called from PageObjectManager class
			corporatepage.ClickOnCorporateCarRental();//clicks on CorporateCarRental link //ClickOnCorporateCarRental() method is called from 'CorporateCarRentalPage' class
			corporatepage.Switchtab(1);//switching to another window //Switchtab()  is called from 'ClickOnCorporateCarRentalPage' class
			corporatepage.EnterName(Name);// sends Name to the input field //EnterName() method is called from 'CorporateCarRentalPage' class
			corporatepage.EnterCompany(Company);// sends CompanyName to the input field //EnterCompany() method is called from 'CorporateCarRentalPage' class
			corporatepage.EnterEmail(Email);;// sends Email to the input field //EnterEmail() method is called from 'CorporateCarRentalPage' class
			corporatepage.EnterPhoneNo(Phone);;// sends PhonneNum to the input field //EnterPhoneNo() method is called from 'CorporateCarRentalPage' class
			corporatepage.SelectRentalReq(Req);;// selects required business value from dropdown//SelectRentalReq() method is called from 'CorporateCarRentalPage' class
			corporatepage.ClickSubmit();//clicks on submit button //ClickSubmit() method is called from 'CorporateCarRentalPage' class
			corporatepage.ValidateMSG();//validates the Expected Msg is matching with the Actual Msg //ValidatePage() method called from  'CorporateCarRentalPage' class
			test.log(Status.PASS, "TestCase10 Successful");
		
			screenshotPath = getscreenshotpath("test10");//captures screenshot
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test10");
			test.fail("test10 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase10 UnSuccessful");	
		}
	} 

	//this method close the browser after every Testcase
	@AfterMethod
	public void After() {
		tearDown();//calling this method from BaseTest Class
	}

	@AfterTest()
	public void flush() {
		extent.flush();
	}
	

}
