package WebElements;

import org.openqa.selenium.By;

public class CorporateCarRentalPageUI {
	
	//I tried to select elements through CssSelector but is Not locating to the correct path so here i used xpath
	public static By corporate = By.xpath(".//*[@href='/corporate-car-rental']");
	public static By name = By.xpath(".//*[@formcontrolname='corpRegNameControl']");
	public static By company = By.xpath(".//*[@formcontrolname='corpRegCompanyControl']");
	public static By email = By.xpath(".//*[@formcontrolname='corpRegEmailControl']");
	public static By phoneno = By.xpath(".//*[@formcontrolname='corpRegPhoneControl']");
	public static By req = By.xpath("//*[@formcontrolname='corpRegmonthlyRentalRequirementControl']");
	public static By submit = By.xpath(".//*[@class='createAccountBtn']");
	public static By msg = By.xpath(".//*[@class='col apiResponseHandlingDiv ng-star-inserted']");
	
}