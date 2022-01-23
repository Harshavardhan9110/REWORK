package WebElements;

import org.openqa.selenium.By;

public class OneWayPageUI {
	
	//I tried to select elements through CssSelector but is Not locating to the correct path so here i used xpath
	public static By oneway = By.xpath(".//*[@href='/one-way-cabs']");
	public static By agra = By.xpath(".//*[@id='tabAgra']");
	public static By place = By.xpath(".//*[@href='/agra/agra-to-shikohabad-one-way-cabs']");		
}
	