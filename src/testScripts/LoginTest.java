package testScripts;

import java.io.IOException;

import genericClass.ExcelLib;
import genericClass.ScreenshotLib;
import genericClass.Utility;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends Utility{

	public static void main(String[] args) throws IOException
	{
		String reportName = new Object(){}.getClass().getName();
		System.out.println(reportName);
		Utility.getBrowser(reportName);
		String uname = ExcelLib.readData("Sheet1", 1, 1);
		String pass = ExcelLib.readData("Sheet1", 1, 2);
		
		LoginPage.validLogin(driver, uname, pass);
		logger.info("logged in successfully");
		HomePage.skipYourContribution(driver);
		BasePage.logoutApplication(driver);
		logger.info("Logged out successfully");
		String result = BasePage.verifyLogout(driver);
		if(result.equalsIgnoreCase("pass"))
		{
			logger.pass("Login test passed successfully");
		}
		else
		{
			ScreenshotLib.takesScreenshot(driver, "LoginTest");
			logger.addScreenCaptureFromPath("./screenshots/LoginTest.png");
			logger.fail("Login test failed");
		}
		extent.flush();
		System.out.println("Test case completed");
	}

}
