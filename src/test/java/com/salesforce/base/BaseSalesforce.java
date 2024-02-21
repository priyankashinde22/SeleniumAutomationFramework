package com.salesforce.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.salesforce.utilities.Constants;
import com.salesforce.utilities.PropertiesUtility;

public class BaseSalesforce extends BaseTest {
	
	protected Logger baseSalesforcelog = LogManager.getLogger();

	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("chrome") String name) {
		
		baseSalesforcelog.info("-----SetupBeforeMethod executed----");
		launchBrowser(name);
		String url = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);

	}

	public void salesforce_Login() throws InterruptedException {

		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and paswword extracted from properties file");
		Thread.sleep(5000);

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, userName, "Username textbox");
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, passWord, "Password");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Log In");
		Thread.sleep(5000);
		String expHomePageTitle = "Home Page ~ Salesforce - Developer Edition";
		String actHomePageTitle = getTitle(driver, "Home Page");
		if (expHomePageTitle.equals(actHomePageTitle)) {
			baseSalesforcelog.info("Homepage is displayed");
		} else {
			baseSalesforcelog.info("Homepage is not displayed");
		}
		String expUserLoginName = "priyanka shinde";
		WebElement userLoginName = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		String actLoginName = getTextFromElement(userLoginName, "Login User Name");
		if (expUserLoginName.equals(actLoginName)) {
			baseSalesforcelog.info("Login with correct username");

		} else {
			baseSalesforcelog.info("Login with wrong username");
		}

	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		
		baseSalesforcelog.info("-----tearDownAfterTestMethod executed----");
		
		closeBrowser();
		
	}

	public void salesforceLogout() throws InterruptedException {
		WebElement userNavArrow = driver.findElement(By.id("userNav-arrow"));
		clickElement(userNavArrow, "User-nav arrow");
		Thread.sleep(4000);
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		clickElement(logOut, "Logout link");
		Thread.sleep(4000);
		String expTitle = "Login | Salesforce";
		String actTitle = getTitle(driver, "Login Page");
		if (expTitle.equals(actTitle)) {
			baseSalesforcelog.info("Salesforce application login page is displayed");
		} else {
			baseSalesforcelog.info("Salesforce application login page is not displayed");
		}

		

	}

}
