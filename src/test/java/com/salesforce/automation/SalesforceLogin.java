package com.salesforce.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import com.salesforce.base.BaseSalesforce;

public class SalesforceLogin extends BaseSalesforce {

	protected Logger loginlog = LogManager.getLogger();

	@Test

	public void errorMessageLoginTC1() throws InterruptedException {

		String expTitle = "Login | Salesforce";
		String actTitle = getTitle(driver, "Login Page :");
		loginlog.info(actTitle);

		Assert.assertEquals(actTitle, expTitle);
		extentReport.logTestInfo("using hard assert compare actual and expected");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(actTitle));

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "priyanka@house.com", "Username");
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "", "Password");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Log In");

		// Thread.sleep(5000);
		WebElement errMsg = driver.findElement(By.id("error"));
		String expErrMsg = "Please enter your password.";
		String actErrMsg = errMsg.getText();
		loginlog.info(actErrMsg);
		wait.until(ExpectedConditions.visibilityOf(errMsg));
		if (actErrMsg.equals(expErrMsg)) {
			loginlog.info("Test case passed");

		} else {
			loginlog.error("Test case failed");

		}

	}

	// SoftAssert soft= new SoftAssert();
	// soft.assertEquals(actErrMsg,expErrMsg);
	// soft.assertAll();

	@Test
	public void validLoginTC2() throws InterruptedException {

		salesforce_Login();

	}

	@Test
	public void checkRememberMeTC3() throws InterruptedException {
		String expTitle = "Login | Salesforce";
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		String actTitle = getTitle(driver, "Login Page");
		// loginlog.info(actTitle);

		if (expTitle.equals(actTitle)) {
			loginlog.info("Salesforce application page is displayed");
		} else {
			loginlog.error("Salesforce application page is not displayed");
		}
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "priyanka@house.com", "Username");
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Test@123", "Password");
		WebElement chkbxRememberMe = driver.findElement(By.id("rememberUn"));
		checkElement(chkbxRememberMe, "Remember checkbox");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Log In");
		Thread.sleep(5000);
		String expHomePageTitle = "Home Page ~ Salesforce - Developer Edition";
		String actHomePageTitle = getTitle(driver, "Home Page");
		if (expHomePageTitle.equals(actHomePageTitle)) {
			loginlog.info("Homepage is displayed");
		} else {
			loginlog.error("Homepage is not displayed");
		}
		salesforceLogout();

		Thread.sleep(4000);

		WebElement chkbxRemember = driver.findElement(By.id("rememberUn"));
		if (chkbxRemember.isSelected()) {
			loginlog.info("CheckBox rememberme is checked");
		} else {
			loginlog.error("CheckBox rememberme is not checked");
		}
		WebElement uname = driver.findElement(By.id("username"));

		String userName = uname.getAttribute("value");
		loginlog.info(userName);
		if (userName.equals("priyanka@house.com")) {
			loginlog.info("Testcase is Passed");
		} else {
			loginlog.error("Testcase is failed");

		}

	}

	@Test
	public void forgetPasswordTC4A() {
		String expTitle = "Login | Salesforce";
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		String actTitle = getTitle(driver, "Login Page");
		if (expTitle.equals(actTitle)) {
			loginlog.info("Salesforce application login page is displayed");
		} else {
			loginlog.error("Salesforce application login page is not displayed");
		}
		WebElement forgotPwd = driver.findElement(By.linkText("Forgot Your Password?"));
		clickElement(forgotPwd, "Forgot password link");
		String exptitle = "Forgot Your Password | Salesforce";
		String title = getTitle(driver, "Forgot password link Page");
		if (exptitle.equals(title)) {
			loginlog.info("Saleforce forgot password page is displyed.");
		} else {
			loginlog.error("Saleforce forgot password page is not displyed.");
		}
		WebElement username = driver.findElement(By.id("un"));
		enterText(username, "priyanka@house.com", "Forgot password textbox");
		WebElement btnContinue = driver.findElement(By.id("continue"));
		clickElement(btnContinue, "Forgot password textbox");
		WebElement header = driver.findElement(By.id("header"));
		String expHeader = "Check Your Email";
		String txtHeader = getTextFromElement(header, "Check your email");
		loginlog.info(txtHeader);
		if (expHeader.equals(txtHeader)) {
			loginlog.info("Test case is passed");
		} else {
			loginlog.error("Test case is failed");
		}

	}

	@Test
	public void forgetPasswordTC4B() throws InterruptedException {
		String expTitle = "Login | Salesforce";
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		String actTitle = getTitle(driver, "Login Page");
		if (expTitle.equals(actTitle)) {
			loginlog.info("Salesforce application login page is displayed");
		} else {
			loginlog.error("Salesforce application login page is not displayed");
		}
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "123", "Username");
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "22131", "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Log In");
		Thread.sleep(5000);

		WebElement ele = driver.findElement(By.id("error"));
		String expErrorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actErroMsg = getTextFromElement(ele, "Error message");
		loginlog.info(actErroMsg);
		if (expErrorMsg.equals(actErroMsg)) {
			loginlog.info("Test case is Passed");
		} else {
			loginlog.error("Test case is Failed");
		}
		

}

}
