package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericClass.WaitStatementLib;

public class HomePage 
{
	private static By skip = By.id("skip");
	
	public static void skipYourContribution(WebDriver driver)
	{
		WebElement skipElement = driver.findElement(skip);
		WaitStatementLib.iSleep(3);
		WaitStatementLib.eWaitForVisibility(driver, 30, skipElement);
		skipElement.click();
	}
	
	

}
