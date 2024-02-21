package com.salesforce.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforce.base.BaseSalesforce;

public class Contacts extends BaseSalesforce {

	protected Logger contactslog = LogManager.getLogger();

	@Test

	public void createNewContactTC25() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);

		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		WebElement btnNew = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(btnNew, "New Contacts");
		Thread.sleep(1000);

		String expNewEditContact = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String actNewEditContact = getTitle(driver, "Contact Edit New Contact");
		if (expNewEditContact.contains(actNewEditContact)) {
			contactslog.info("Contact Edit: New Contact Page is Displayed");
		} else {
			contactslog.error("Contact Edit: New Contact Page is not Displayed");
		}

		WebElement txtbxLastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		enterText(txtbxLastName, "Cruise", "LastName textbox");

		WebElement txtbAcctName = driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(txtbAcctName, "test1", "Account Name textbox");

		WebElement btnSave = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		clickElement(btnSave, "Save New Contact");

		String expnewacctTitle = "Contact: Cruise ~ Salesforce - Developer Edition";

		String actnewacctTitle = getTitle(driver, "New Contact");

		if (expnewacctTitle.equals(actnewacctTitle)) {
			contactslog.info("Test case is Passed");
		} else {
			contactslog.error("Test case is Failed");
		}
		// closeBrowser();

	}

	@Test
	public void createNewViewContactPageTC26() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);

		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		WebElement createNewViewLink = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewViewLink, "Create New View link");

		String expNewViewtitle = "Contacts: Create New View ~ Salesforce - Developer Edition";
		String actNewViewtitle = getTitle(driver, "Contacts Home Page");
		if (expNewViewtitle.equals(actNewViewtitle)) {
			contactslog.info("Contacts: Create New View Page is Displayed");
		} else {
			contactslog.error("Contacts: Create New View Page is not Displayed");
		}
		WebElement txtbxViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(txtbxViewName, "test_feb11", "View name textbox");

		Thread.sleep(3000);
		WebElement btnSave = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title='Save']"));
		clickElement(btnSave, "Save View");
		String expHometitle = "Contacts ~ Salesforce - Developer Edition";
		String acHomettitle = getTitle(driver, "Save Contacts View Page");
		if (expHometitle.contains(acHomettitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		Thread.sleep(3000);

		WebElement drpwnList = driver.findElement(By.xpath("//select[@name='fcf']"));
		boolean result = verifyOptionFromDropdownIsDisplayed(drpwnList, "test_feb11", "check Dropdown list");
		if (result) {
			contactslog.info("View name is present in dropdwon");
		} else {
			contactslog.error("View name is not present in dropdwon");
		}

		// closeBrowser();

	}

	@Test

	public void checkRecentlyCreatedContactsTC27() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);
		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}
		WebElement drpdwnList = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		boolean result = selectOptionFromDropdownByVisibleText(drpdwnList, "Recently Created", "DropDown");
		if (result) {
			contactslog.info("Recently Created option is selected in dropdwon");
		} else {
			contactslog.error("Recently Created option is not selected in dropdwon");
		}

		// closeBrowser();

	}

	@Test

	public void myContactsViewInContactPageTC28() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);
		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		WebElement drpdwnView = driver.findElement(By.xpath("//select[@id='fcf']"));
		boolean result = selectOptionFromDropdownByVisibleText(drpdwnView, "My Contacts", "View dropdown");
		if (result) {
			contactslog.info("My Contacts option is selected in dropdwon");
		} else {
			contactslog.error("My Contacts option is not selected in dropdwon");
		}

		// closeBrowser();

	}

	@Test
	public void viewAcontactInTheContactPageTC29() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		Thread.sleep(3000);
		WebElement recentContacts = driver.findElement(By.xpath("(//th[@class=' dataCell  ']/a)[1]"));
		clickElement(recentContacts, "Recent contact clicked");

		String expDetailsInfo = "Contact Detail";

		WebElement contactDetails = driver.findElement(By.xpath("//h2[text()='Contact Detail']"));
		String actDetailsInfo = getTextFromElement(contactDetails, "Contacts details");

		if (expDetailsInfo.contains(actDetailsInfo)) {
			contactslog.info("Contacts Detail Page is Displayed");
		} else {
			contactslog.error("Contacts Detail Page is not Displayed");
		}
		// closeBrowser();

	}

	@Test
	public void checktheErrorMessageTC30() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);
		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		WebElement createNewViewLink = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewViewLink, "Create New View link");

		String expNewViewtitle = "Contacts: Create New View ~ Salesforce - Developer Edition";
		String actNewViewtitle = getTitle(driver, "Contacts Home Page");
		if (expNewViewtitle.equals(actNewViewtitle)) {
			contactslog.info("Contacts: Create New View Page is Displayed");
		} else {
			contactslog.error("Contacts: Create New View Page is not Displayed");
		}

		WebElement txtbxUniqueViewName = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(txtbxUniqueViewName, "EFGH", "Unique View name textbox");

		WebElement btnSave = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title='Save']"));
		clickElement(btnSave, "Save View");

		Thread.sleep(3000);
		String expErrorMsg = "Error: You must enter a value";
		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errorMsg']"));

		String actErrorMsg = getTextFromElement(errorMsg, "Error Message Text");
		if (expErrorMsg.contains(actErrorMsg)) {
			contactslog.info("Error message is Displayed");
		} else {
			contactslog.error("Error message is not Displayed");
		}
		// closeBrowser();

	}

	@Test
	public void checkCancelButtonForCreateNewViewTC31() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		WebElement createNewViewLink = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewViewLink, "Create New View link");

		String expNewViewtitle = "Contacts: Create New View ~ Salesforce - Developer Edition";
		String actNewViewtitle = getTitle(driver, "Contacts Home Page");
		if (expNewViewtitle.equals(actNewViewtitle)) {
			contactslog.info("Contacts: Create New View Page is Displayed");
		} else {
			contactslog.error("Contacts: Create New View Page is not Displayed");
		}

		WebElement txtbxUniqueViewName = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(txtbxUniqueViewName, "ABCD", "Unique View name textbox");
		Thread.sleep(3000);
		WebElement txtbxViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(txtbxViewName, "EFGH", "View name textbox");

		WebElement btnCancel = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title='Cancel']"));
		clickElement(btnCancel, "Cancel View");

		String expcanceltitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String actcanceltitle = getTitle(driver, "Contacts Home Page");
		if (expcanceltitle.contains(actcanceltitle)) {
			contactslog.info("Test case is Passed and Contacts Home Page is Displayed");
		} else {
			contactslog.error("Test case is Failed and Contacts Home Page is not Displayed");
		}

		// closeBrowser();

	}

	@Test
	public void checkSaveAndNewOnContactPageTC32() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement contactsLink = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a[text()='Contacts']"));
		clickElement(contactsLink, "Contacts");

		String exptitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Contacts Home Page");
		if (exptitle.contains(acttitle)) {
			contactslog.info("Contacts Home Page is Displayed");
		} else {
			contactslog.error("Contacts Home Page is not Displayed");
		}

		WebElement btnNew = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(btnNew, "New Contacts");
		Thread.sleep(1000);

		WebElement txtbxLastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		enterText(txtbxLastName, "Indian", "LastName textbox");
		Thread.sleep(1000);

		WebElement txtbxAcctName = driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(txtbxAcctName, "Global Media", "LastName textbox");
		Thread.sleep(3000);

		WebElement btnSaveNNew = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save & New']"));
		clickElement(btnSaveNNew, "Save and New ");

		String expContactEdit = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String actContactEdit = getTitle(driver, "Contacts New Contact Page");

		if (expContactEdit.contains(actContactEdit)) {
			contactslog.info("Test case is Passed and Contact Edit: New Contact Page is Displayed");
		} else {
			contactslog.error("Test case is Failed and Contact Edit: New Contact Page is not Displayed");
		}

		// closeBrowser();

	}

}
