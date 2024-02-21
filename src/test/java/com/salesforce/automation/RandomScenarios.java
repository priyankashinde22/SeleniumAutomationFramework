package com.salesforce.automation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforce.base.BaseSalesforce;

public class RandomScenarios extends BaseSalesforce {
	
	protected Logger randomScenarioslog = LogManager.getLogger();
	
	@Test

	public void verifyFirstNameNLastNameOfLoggedInUserDisplayedTC33() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);
		WebElement homeTab = driver.findElement(By.linkText("Home"));
		clickElement(homeTab, "Home");
		Thread.sleep(3000);
		WebElement firstlastName = driver.findElement(By.linkText("priyanka nicolas"));
		clickElement(firstlastName, "Logged in username");

		String expMyProfiletitle = "User: priyanka nicolas ~ Salesforce - Developer Edition";
		String actMyProfiletitle = getTitle(driver, "My Profile Page");
		randomScenarioslog.info(actMyProfiletitle);
		if (expMyProfiletitle.equals(actMyProfiletitle)) {

			randomScenarioslog.info("My Profile Page is Displayed");
		} else

		{
			randomScenarioslog.error("My Profile Page is not Displayed");
		}


	}
	
	@Test

	public void verifyEditedLastNameIsUpdatedTC34() throws InterruptedException {
		verifyFirstNameNLastNameOfLoggedInUserDisplayedTC33();
		Thread.sleep(3000);

		WebElement editProfile = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		clickElement(editProfile, "Edit profile link");

		WebElement eleFrame = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));

		driver.switchTo().frame(eleFrame);

		randomScenarioslog.info("Edit profile pop up window is displayed with contact and About tabs to edit.");
		WebElement eleAbout = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
		clickElement(eleAbout, "About tab");
		WebElement eleLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		enterText(eleLastName, "Abcd", "Last Name textbox");
		WebElement eleSaveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
		clickElement(eleSaveAll, "Save All button");

		driver.switchTo().defaultContent();

		String expUserLoginName = "priyanka Abcd";
		WebElement userLoginName = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		String actLoginName = getTextFromElement(userLoginName, "Login User Name");
		if (expUserLoginName.equals(actLoginName)) {
			randomScenarioslog.info("Changed User Last name is dislayed");

		} else {
			randomScenarioslog.error("Changed User Last name is not dislayed");
		}

	}

	@Test
	
	public void verifyTheTabCustomizationTC35() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);

		WebElement plusTab = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		clickElement(plusTab, " Click + Tab");
		Thread.sleep(3000);
		WebElement headerAlltabs = driver.findElement(By.xpath("//div[@class='content']"));
		String expHeader = "All Tabs";
		// String actHeader=headerAlltabs.getText();
		String actHeader = getTextFromElement(headerAlltabs, "All Tabs");
		randomScenarioslog.info(actHeader);
		if (expHeader.equals(actHeader)) {
			randomScenarioslog.info("All tab Page is displayed");
		} else {
			randomScenarioslog.error("All tab Page is not displayed");
		}
		WebElement customizeTab = driver.findElement(By.xpath("//input[@class='btnImportant']"));
		clickElement(customizeTab, "Click on Customize tab");
		Thread.sleep(2000);
		String expCustomTab = "Customize My Tabs";
		WebElement customizetabHeader = driver.findElement(By.xpath("//h1[text()='Customize My Tabs']"));
		// String actCustomTab=customizetabHeader.getText();
		String actCustomTab = getTextFromElement(customizetabHeader, "Customize My Tab");
		if (expCustomTab.equals(actCustomTab)) {
			randomScenarioslog.info("The Customize My Tabs' page is displayed.");
		} else {
			randomScenarioslog.error("The Customize My Tabs' page is not displayed.");
		}

		WebElement availbleDrpdwn = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		selectDropdownByValue(availbleDrpdwn, "Account", "Available tab option");

		Thread.sleep(3000);

		WebElement addBtn = driver.findElement(By.xpath("//a[@id='duel_select_0_right']"));
		clickElement(addBtn, "Click on Add ");

		Thread.sleep(3000);

		WebElement selectDrpdwn = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		checkOptionFromDropdown(selectDrpdwn, "Account", "Select tab option");
		Thread.sleep(3000);

		WebElement saveBtn = driver.findElement(By.xpath("//input[@name='save']"));
		clickElement(saveBtn, "Click on Save ");

		Thread.sleep(3000);
		WebElement h1Alltabs = driver.findElement(By.xpath("//div[@class='content']"));
		String eHeader = "All Tabs";
		// String aHeader=h1Alltabs.getText();
		String aHeader = getTextFromElement(h1Alltabs, "All Tabs");
		randomScenarioslog.info(aHeader);
		if (eHeader.equals(aHeader)) {
			randomScenarioslog.info("All tab Page is displayed");
		} else {
			randomScenarioslog.error("All tab Page is not displayed");
		}
		Thread.sleep(3000);
		salesforceLogout();
		// closeBrowser();

		// salesforce_Login();
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "priyanka@house.com", "Username");
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Test@123", "Password");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Log In");
		Thread.sleep(3000);

		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		String expAccntLink = "Accounts";
		// String actAccntLink=accountsLink.getText();
		String actAccntLink = getTextFromElement(accountsLink, "Accounts Tab");

		if (expAccntLink.equals(actAccntLink)) {
			randomScenarioslog.info("Test case is Passed.Account tab is added");
		} else {
			randomScenarioslog.error("Test case is Failed.Account tab is not added");
		}

		//closeBrowser();

	}

	@Test
	public void blockingAnEventInTheCalenderTC36() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement homeTab = driver.findElement(By.linkText("Home"));
		clickElement(homeTab, "Home");
		Thread.sleep(3000);

		String expDate = "Tuesday February 13, 2024";
		WebElement datelink = driver.findElement(By.linkText("Tuesday February 13, 2024"));
		String actDate = getTextFromElement(datelink, "Date");
		randomScenarioslog.info(actDate);
		if (expDate.equals(actDate)) {

			randomScenarioslog.info("Date is Displayed with Day,Month and Year format");
		} else

		{
			randomScenarioslog.error("Date is not Displayed");
		}

		clickElement(datelink, "Date");

		String expCalenderTitle = "Calendar for priyanka Abcd ~ Salesforce - Developer Edition";
		String actCalenderTitle = getTitle(driver, "Calender ");
		randomScenarioslog.info(actCalenderTitle);
		if (expCalenderTitle.equals(actCalenderTitle)) {

			randomScenarioslog.info("Calender Page is Displayed");
		} else

		{
			randomScenarioslog.error("Calender Page is not Displayed");
		}

		WebElement timelink = driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']"));
		clickElement(timelink, "8:00 PM");

		String expCalenderNewEvent = "Calendar: New Event ~ Salesforce - Developer Edition";
		String actCalenderNewEvent = getTitle(driver, "Calender New Event");
		randomScenarioslog.info(actCalenderNewEvent);
		if (expCalenderNewEvent.equals(actCalenderNewEvent)) {

			randomScenarioslog.info("Calender: New Event Page is Displayed");
		} else

		{
			randomScenarioslog.error("Calender: New Event Page is not Displayed");
		}

		WebElement txtbxSubject = driver.findElement(By.xpath("//input[@id='evt5']"));
		if (driver.switchTo().activeElement().equals(txtbxSubject)) {
			randomScenarioslog.info("Cursor at the Subject textbox");
		}

		else {
			randomScenarioslog.error("Cursor is not at the Subject textbox");
		}

		WebElement subjectCombo = driver.findElement(By.xpath("//a[@title='Combo (New Window)']"));
		clickElement(subjectCombo, "Subject combo");

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				randomScenarioslog.info(driver.switchTo().window(child_window).getTitle());

				WebElement eleOtherLink = driver.findElement(By.xpath("//a[text()='Other']"));
				clickElement(eleOtherLink, "Other link");
				
			}

		}
		driver.switchTo().window(parent);
		String result = txtbxSubject.getAttribute("value");
		randomScenarioslog.info(result);
		if (result.equals("Other")) {
			randomScenarioslog.info("Other is entered in the Subject field");
		} else {
			randomScenarioslog.error("Other is not entered in the Subject field");
		}

		WebElement eleEndDateTime = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		clickElement(eleEndDateTime, "EndDate Time");
		String tmes[] = { "9:00 PM", "9:30 PM", "10:00", "10:30", "11:00", "11:30" };
		List<WebElement> listEndDateTimes = driver.findElements(By.xpath("//div[@id='simpleTimePicker']/div"));


		boolean flag = isDisplayDropDownList(listEndDateTimes, tmes, "9:00 to 11:30");

		if (flag) {
			randomScenarioslog.info("Dropdwon is displayed with time 9:00 to 11:30");
		} else {
			randomScenarioslog.error("Dropdwon is not displayed with time 9:00 to 11:30");
		}

		selectOptionFromDropdownList(listEndDateTimes, "9:00", "time 9:00");

		Thread.sleep(3000);

		WebElement eleSave = driver.findElement(By.xpath("//td[@id='topButtonRow']/input[@title='Save']"));
		clickElement(eleSave, "Save");

		WebElement event = driver.findElement(By.xpath("//a[@title='Busy - Other']"));
		if (event.isDisplayed()) {
			randomScenarioslog.info("Other link is displayed");
			randomScenarioslog.info(event.getAttribute("href"));
		} else {
			randomScenarioslog.error("Other link is not displayed");
		}

		WebElement eleCalFnLn = driver.findElement(By.xpath("//h1[@class='pageType']"));
		String actHeadertxt = getTextFromElement(eleCalFnLn, "Calender for priyanka Abcd");
		String expHeadertxt = "Calendar for priyanka Abcd - Day View";

		if (actHeadertxt.equals(expHeadertxt)) {
			randomScenarioslog.info("Test case is Passed.");
		} else {
			randomScenarioslog.error("Test case is Failed.");
		}

	}
	
	@Test

	public void blockingAnEventInTheCalenderWthWeeklyRecurranceTC37() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement homeTab = driver.findElement(By.linkText("Home"));
		clickElement(homeTab, "Home");
		Thread.sleep(3000);

		String expDate = "Tuesday February 13, 2024";
		WebElement datelink = driver.findElement(By.linkText("Tuesday February 13, 2024"));
		String actDate = getTextFromElement(datelink, "Date");
		randomScenarioslog.info(actDate);
		if (expDate.equals(actDate)) {

			randomScenarioslog.info("Date is Displayed with Day,Month and Year format");
		} else

		{
			randomScenarioslog.error("Date is not Displayed");
		}

		clickElement(datelink, "Date");

		String expCalenderTitle = "Calendar for priyanka Abcd ~ Salesforce - Developer Edition";
		String actCalenderTitle = getTitle(driver, "Calender ");
		randomScenarioslog.info(actCalenderTitle);
		if (expCalenderTitle.equals(actCalenderTitle)) {

			randomScenarioslog.info("Calender Page is Displayed");
		} else

		{
			randomScenarioslog.error("Calender Page is not Displayed");
		}

		WebElement timelink = driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:20:j_id64']"));
		clickElement(timelink, "4:00 PM");

		String expCalenderNewEvent = "Calendar: New Event ~ Salesforce - Developer Edition";
		String actCalenderNewEvent = getTitle(driver, "Calender New Event");
		randomScenarioslog.info(actCalenderNewEvent);
		if (expCalenderNewEvent.equals(actCalenderNewEvent)) {

			randomScenarioslog.info("Calender: New Event Page is Displayed");
		} else

		{
			randomScenarioslog.error("Calender: New Event Page is not Displayed");
		}

		WebElement txtbxSubject = driver.findElement(By.xpath("//input[@id='evt5']"));
		if (driver.switchTo().activeElement().equals(txtbxSubject)) {
			randomScenarioslog.info("Cursor at the Subject textbox");
		}

		else {
			randomScenarioslog.error("Cursor is not at the Subject textbox");
		}

		WebElement subjectCombo = driver.findElement(By.xpath("//a[@title='Combo (New Window)']"));
		clickElement(subjectCombo, "Subject combo");

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				randomScenarioslog.info(driver.switchTo().window(child_window).getTitle());

				WebElement eleOtherLink = driver.findElement(By.xpath("//a[text()='Other']"));
				clickElement(eleOtherLink, "Other link");
				// driver.close();
			}

		}
		driver.switchTo().window(parent);
		String result = txtbxSubject.getAttribute("value");
		randomScenarioslog.info(result);
		if (result.equals("Other")) {
			randomScenarioslog.info("Other is entered in the Subject field");
		} else {
			randomScenarioslog.error("Other is not entered in the Subject field");
		}

		WebElement eleEndDateTime = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		clickElement(eleEndDateTime, "EndDate Time");
		String tmes[] = { "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30", "9:00 PM", "9:30 PM", "10:00",
				"10:30", "11:00", "11:30" };
		List<WebElement> listEndDateTimes = driver.findElements(By.xpath("//div[@id='simpleTimePicker']/div"));

		boolean flag = isDisplayDropDownList(listEndDateTimes, tmes, "5:00 to 11:30");

		if (flag) {
			randomScenarioslog.info("Dropdwon is displayed with time 5:00 to 11:30");
		} else {
			randomScenarioslog.error("Dropdwon is not displayed with time 5:00 to 11:30");
		}

		selectOptionFromDropdownList(listEndDateTimes, "7:00", "time 7:00");

		Thread.sleep(3000);
		WebElement eleRecurrence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		clickElement(eleRecurrence, "Save");

		if (eleRecurrence.isSelected()) {
			randomScenarioslog.info("The recurrence checkbox is checked");
		} else {
			randomScenarioslog.error("The recurrence checkbox is not checked");
		}
		WebElement eleFrequency = driver.findElement(By.xpath("//label[text()='Frequency']"));
		if (eleFrequency.isDisplayed()) {
			randomScenarioslog.info("Frequency section is displayed");
		} else {
			randomScenarioslog.error("Frequency section is not displayed");
		}
		WebElement eleStartDate = driver.findElement(By.xpath("//label[text()='Recurrence Start']"));

		if (eleStartDate.isDisplayed()) {
			randomScenarioslog.info("StartDate and EndDate section is displayed");
		} else {
			randomScenarioslog.error("StartDate and EndDate section is not displayed");
		}

		WebElement eleWeekly = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		clickElement(eleWeekly, "Weekly radiobtn");
		Thread.sleep(3000);
		if (eleWeekly.isSelected()) {
			randomScenarioslog.info("Weekly radiobutton is selected");
		} else {
			randomScenarioslog.error("Weekly radiobutton is not selected");

		}
		WebElement eleEvery = driver.findElement(By.xpath("//input[@id='di']"));

		if (eleEvery.getAttribute("value").equals("1")) {
			randomScenarioslog.info("Every section is dislpayed with 1");
		} else {
			randomScenarioslog.error("Every section is not dislpayed with 1");
		}

		WebElement eleDay = driver.findElement(By.xpath("//input[@id='4']"));
		if (eleDay.isSelected()) {
			randomScenarioslog.info("Wednesday is selected");
		}
		{
			randomScenarioslog.error("Wednesday is not selected");
		}

		WebElement eleRecurrenceEnd = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
		clickElement(eleRecurrenceEnd, "End date");

		Thread.sleep(3000);

		WebElement eleYear = driver.findElement(By.xpath("//select[@id='calYearPicker']"));
		selectOptionFromDropdownByVisibleText(eleYear, "2024", "Current year");

		Thread.sleep(3000);
		WebElement eleMonth = driver.findElement(By.xpath("//select[@id='calMonthPicker']"));
		selectOptionFromDropdownByVisibleText(eleMonth, "February", "Current year");
		Thread.sleep(3000);
		List<WebElement> eledates = driver.findElements(By.xpath("//tr[@class='calRow']/td"));
		selectOptionFromDropdownList(eledates, "27", "Date 27");

		Thread.sleep(3000);
		WebElement eleSave = driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@title='Save']"));
		clickElement(eleSave, "Save");
		Thread.sleep(3000);
		WebElement event = driver.findElement(By.xpath("//a[@title='Busy - Other']"));
		if (event.isDisplayed()) {
			randomScenarioslog.info("Other link is displayed");
			// randomScenarioslog.info(event.getAttribute("href"));
		} else {
			randomScenarioslog.error("Other link is not displayed");
		}

		WebElement iconMonth = driver.findElement(By.xpath("//img[@class='monthViewIcon']"));
		clickElement(iconMonth, "Month");
		Thread.sleep(3000);
		WebElement eleCalFnLn = driver.findElement(By.xpath("//h1[@class='pageType']"));
		String actHeadertxt = getTextFromElement(eleCalFnLn, "Calenderfor priyanka Abcd");
		String expHeadertxt = "Calendar for priyanka Abcd - Month View";

		if (actHeadertxt.equals(expHeadertxt)) {
			randomScenarioslog.info("Test case is Passed.");
		} else {
			randomScenarioslog.error("Test case is Failed.");
		}

	}

	

}
