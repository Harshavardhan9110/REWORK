package WebElements;

import org.openqa.selenium.By;

public class AboutUsPageUI {
	//I tried to select elements through CssSelector but is Not locating to the correct path so here i used xpath
	public static By aboutus = By.xpath(".//*[@href='/aboutus']");
	public static By ceo = By.xpath(".//*[@class='ceoName']");
}
	
	

