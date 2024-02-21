package com.salesforce.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforce.base.BaseSalesforce;

public class CreateAccount extends BaseSalesforce {
	
	protected Logger createAccountlog = LogManager.getLogger();

	@Test
	public void createAccountTC10() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement plusTab = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		clickElement(plusTab, " Click + Tab");
		Thread.sleep(3000);
		WebElement headerAlltabs = driver.findElement(By.xpath("//div[@class='content']"));
		String expHeader = "All Tabs";
		// String actHeader=headerAlltabs.getText();
		String actHeader = getTextFromElement(headerAlltabs, "All Tabs");
		createAccountlog.info(actHeader);
		if (expHeader.equals(actHeader)) {
			createAccountlog.info("All tab Page is displayed");
		} else {
			createAccountlog.error("All tab Page is not displayed");
		}
		WebElement customizeTab = driver.findElement(By.xpath("//input[@class='btnImportant']"));
		clickElement(customizeTab, "Click on Customize tab");
		Thread.sleep(2000);
		String expCustomTab = "Customize My Tabs";
		WebElement customizetabHeader = driver.findElement(By.xpath("//h1[text()='Customize My Tabs']"));
		// String actCustomTab=customizetabHeader.getText();
		String actCustomTab = getTextFromElement(customizetabHeader, "Customize My Tab");
		if (expCustomTab.equals(actCustomTab)) {
			createAccountlog.info("The Customize My Tabs' page is displayed.");
		} else {
			createAccountlog.error("The Customize My Tabs' page is not displayed.");
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
		createAccountlog.info(aHeader);
		if (eHeader.equals(aHeader)) {
			createAccountlog.info("All tab Page is displayed");
		} else {
			createAccountlog.error("All tab Page is not displayed");
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
			createAccountlog.info("Test case is Passed.Account tab is added");
		} else {
			createAccountlog.error("Test case is Failed.Account tab is not added");
		}

		//closeBrowser();

	}
	
	@Test

	public void createAccount() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);

		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));

		String expAccntsHome = "Accounts Home";

		clickElement(accountsLink, "Click on Accounts");
		Thread.sleep(5000);
		WebElement accountsHome = driver.findElement(By.xpath("//div[@class='content']"));
		String accntstxtHome = getTextFromElement(accountsHome, "AccountHome page");
		// accountsHome.getText();
		createAccountlog.info(accntstxtHome);
		if (expAccntsHome.contains(accntstxtHome)) {
			createAccountlog.info("Accounts Home Page is displayed");
		} else {
			createAccountlog.error("Accounts Home Page is not displayed");
		}

		Thread.sleep(3000);

		WebElement newbtn = driver.findElement(By.xpath("//input[@name='new']"));
		clickElement(newbtn, "Clicked on new");

		WebElement accntName = driver.findElement(By.xpath("//input[@id='acc2']"));
		enterText(accntName, "testfeb2", "Enter AccountName");
		WebElement drpdwnType = driver.findElement(By.xpath("//select[@id='acc6']"));
		selectDropdownByVisibleText(drpdwnType, "Technology Partner", "Select Type dropdwon");
		WebElement drpdwnCustomerPriority = driver.findElement(By.xpath("//select[@id='00Nan000000LKIi']"));
		selectDropdownByVisibleText(drpdwnCustomerPriority, "High", "Select Customer priority dropdwon");

		WebElement btnSave = driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@title='Save']"));
		clickElement(btnSave, "Clicked Save");
		String expAcctNme = "testfeb2";
		WebElement headerAccntName = driver.findElement(By.xpath("//h2[@class='topName']"));
		String actAcctNme = getTextFromElement(headerAccntName, "Header Account Name");
		// headerAccntName.getText();
		if (expAcctNme.equals(actAcctNme)) {
			createAccountlog.info("Test case is Passed and Account is created");
		} else {
			createAccountlog.error("Test case is Failed and Account is not created");
		}

		//closeBrowser();

	}

	
	@Test
	public void createNewViewTC11() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);

		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		clickElement(accountsLink, "Click on Accounts");
		Thread.sleep(3000);

		WebElement createNewViewLink = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewViewLink, "Create New Link Clicked");

		Thread.sleep(3000);
		WebElement txtbxViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(txtbxViewName, "QA_Test", "Enter View Name");

		WebElement saveView = driver.findElement(By.xpath("//input[@title='Save' and @data-uidsfdc='3']"));
		clickElement(saveView, "Save Button");

		Thread.sleep(3000);
		WebElement drpdwnViewList = driver.findElement(By.xpath("//select[@class='title' and @name='fcf']"));

		Thread.sleep(3000);
		boolean result = verifyOptionFromDropdown(drpdwnViewList, "QA_Test", "View dropdown list");
		createAccountlog.info(result);

		if (result) {
			createAccountlog.info("Test case is Passed");
		} else {
			createAccountlog.error("Test case is Failed");
		}

		//closeBrowser();

	}

	
	@Test
	
	public void editViewTC12() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);

		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		clickElement(accountsLink, "Click on Accounts");
		Thread.sleep(3000);

		WebElement drpdwnView = driver.findElement(By.xpath("//select[@id='fcf']"));
		selectDropdownByVisibleText(drpdwnView, "QA_Test", "Select View dropdwon");

		WebElement editLink = driver.findElement(By.xpath("//a[text()='Edit']"));
		clickElement(editLink, "Edit Link");
		String expheaderEditView = " Edit View";

		WebElement headerEditView = driver.findElement(By.xpath("//h2[text()=' Edit View']"));
		String actheaderEditView = getTextFromElement(headerEditView, "Edit view header text");
		if (actheaderEditView.equals(expheaderEditView)) {
			createAccountlog.info("Test case is Passed");
		} else {
			createAccountlog.error("Test case is Failed");
		}

		String titleString = getTitle(driver, "EditView Page");
		createAccountlog.info(titleString);

		WebElement txtbxViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(txtbxViewName, "Test_view", "Enter View Name");

		Thread.sleep(3000);

		WebElement drpdwnField = driver.findElement(By.xpath("//select[@id='fcol1']"));
		selectDropdownByVisibleText(drpdwnField, "Account Name", "Field dropdown");

		WebElement drpdwnOperator = driver.findElement(By.xpath("//select[@id='fop1']"));
		selectDropdownByVisibleText(drpdwnOperator, "contains", "Operator dropdown");

		WebElement txtboxValue = driver.findElement(By.xpath("//input[@id='fval1']"));
		enterText(txtboxValue, "a", "Value textbox");

		Thread.sleep(3000);
		WebElement btnSave = driver.findElement(By.xpath("//input[@title='Save' and @data-uidsfdc='3']"));
		clickElement(btnSave, "Save edit view");

		WebElement drpdwnViewList = driver.findElement(By.xpath("//select[@class='title' and @name='fcf']"));

		Thread.sleep(3000);
		boolean result = verifyOptionFromDropdown(drpdwnViewList, "Test_view", "View dropdown list");
		createAccountlog.info(result);

		if (result) {
			createAccountlog.info("Test case is Passed");
		} else {
			createAccountlog.error("Test case is Failed");
		}

		//closeBrowser();

	}

	
	@Test
	public void mergeAccountsTC13() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);

		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		clickElement(accountsLink, "Click on Accounts");
		Thread.sleep(3000);
		WebElement mergeAccountsLink = driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
		clickElement(mergeAccountsLink, "Merge Accounts");

		WebElement txtboxSearch = driver.findElement(By.xpath("//input[@id='srch']"));
		enterText(txtboxSearch, "testfeb", "Search textbox");

		WebElement btnFindAccounts = driver.findElement(By.xpath("//input[@name='srchbutton' and @type='submit']"));
		clickElement(btnFindAccounts, "Find Accounts");

		Thread.sleep(3000);

		List<WebElement> numofChekbx = driver.findElements(By.xpath("//th[@scope='row']"));
		createAccountlog.info(numofChekbx.size());
		int count = 0;

		for (int i = 0; i < numofChekbx.size(); i++) {
			WebElement checkboxAccnt = driver.findElement(By.xpath("//input[@id='cid" + i + "']"));
			if(!checkboxAccnt.isSelected())
			{	
				clickElement(checkboxAccnt, "select checkbox Accounts");
	
				count++;
				if (count == 3)
					break;
				
			}

		}

		WebElement btnNext = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@value=' Next ']"));
		clickElement(btnNext, "Next Button");

		String exptitle = "Merge My Accounts ~ Salesforce - Developer Edition";
		String acttitle = getTitle(driver, "Merge my Account");

		if (exptitle.equals(acttitle)) {
			createAccountlog.info("Test case is Passed");
		} else {
			createAccountlog.error("Test case is Failed");
		}

		WebElement btnMerge = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@value=' Merge ']"));
		clickElement(btnMerge, "Merge Button");

		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage= driver.switchTo().alert().getText(); // capture alert message

		createAccountlog.info(alertMessage); // Print Alert Message
		Thread.sleep(5000);
		alert.accept();
		
		WebElement drpdwnHotList = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		selectDropdownByVisibleText(drpdwnHotList, "Recently Viewed", "View dropdown");
		
		WebElement mergedRecord = driver.findElement(By.xpath("(//th[@scope='row'])[1]"));
		String expmergedRecordName="testfeb";
		String actmergedRecordName=getTextFromElement(mergedRecord, "Merged account name");
		if(actmergedRecordName.contains(expmergedRecordName))
		{
			createAccountlog.info("Test case is Passed");
		}
		else {
			createAccountlog.error("Test case is Failed");
		}
		
	//	closeBrowser();
		

	}
	
	@Test
	public void creatAccountReportTC14() throws InterruptedException {
		
		salesforce_Login();
		Thread.sleep(3000);
		
		WebElement accountsLink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		clickElement(accountsLink, "Click on Accounts");
		Thread.sleep(3000);
		
		WebElement txt30daysLink=driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
		clickElement(txt30daysLink, "Accounts with last activity > 30 days");
		
		String exptitleUnsavedReport="Unsaved Report ~ Salesforce - Developer Edition";
		String actUnsavedReport=getTitle(driver, "Unsaved Report Page");
		
		if(actUnsavedReport.contains(exptitleUnsavedReport)) {
			createAccountlog.info("Unsaved Report Page is displayed");
		}
		else {
			createAccountlog.error("Unsaved Report Page is not displayed");
		}
		
		
		WebElement txtbxDateField= driver.findElement(By.xpath("//img[@id='ext-gen148']"));
		clickElement(txtbxDateField, "Date Field");
		Thread.sleep(3000);
		
		WebElement createdDate= driver.findElement(By.xpath("//div[@class='x-combo-list-item' and text()='Created Date']"));
		clickElement(createdDate, "Created Date");
		Thread.sleep(3000);
		
		WebElement fromCal=driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		clickElement(fromCal, "From Date");
		Thread.sleep(3000);
		
		WebElement frmtodaybttn=driver.findElement(By.xpath("//button[@id='ext-gen281']"));
		clickElement(frmtodaybttn, "Select Today");
		
		Thread.sleep(3000);
		WebElement toCal=driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		clickElement(toCal, "To Date");
		Thread.sleep(3000);
		
		WebElement todaybttn=driver.findElement(By.xpath("//button[@id='ext-gen296' and text()='Today']"));
		clickElement(todaybttn, "Select Today");
		
		Thread.sleep(3000);
		List<WebElement> listAccountName=
				driver.findElements(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-DUE_DATE x-grid3-cell-first ']"));
		Thread.sleep(3000);
		if(listAccountName.size()>0) {
			createAccountlog.info("List of accounts are qualified and displayed");
		}
		else{
			createAccountlog.error("List of accounts are not qualified and displayed");
			
		}
		
		
		WebElement btnSave=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		clickElement(btnSave, "Save Report");
		Thread.sleep(3000);
		
		WebElement reportName=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		enterText(reportName, "FebReport", "Entered ReportName");
		
		WebElement btnSaveNReport=driver.findElement(By.xpath("//button[text()='Save and Run Report']"));
		clickElement(btnSaveNReport, "Save and Run Report button");
		Thread.sleep(3000);
		
		String exptitle="FebReport ~ Salesforce - Developer Edition";
		String acttitle=getTitle(driver, "Created Report page");
		
		if(acttitle.contains(exptitle)) {
			createAccountlog.info("Test case is Passed");
		}
		else {
			createAccountlog.error("Test case is Failed");
		}
		//closeBrowser();
		
	}

	
}
