package WebElements;

import org.openqa.selenium.By;

public class ContactUsPageUI {
	//I tried to select elements through CssSelector but is Not locating to the correct path so here i used xpath
	public static By contactus = By.xpath(".//*[@href='/contact-us']");
	public static By phoneno = By.xpath(".//*[@href='tel:90 4545 0000']");
}
