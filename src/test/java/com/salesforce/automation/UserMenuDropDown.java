package com.salesforce.automation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.salesforce.base.BaseSalesforce;

public class UserMenuDropDown extends BaseSalesforce {
	
	protected Logger userMenuDropDownlog = LogManager.getLogger();

	@Test
	
	public void selectUserMenuFrmUserNameDropdownTC05() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement userNavArrow = driver.findElement(By.id("userNav-arrow"));
		if (userNavArrow.isDisplayed()) {
			userMenuDropDownlog.info("User Menu Dropdown is displayed");
		} else {
			userMenuDropDownlog.error("User Menu Dropdown not is displayed");
		}
		clickElement(userNavArrow, "User-nav arrow");
		Thread.sleep(3000);
		String[] listMenu = { "My profile", "My Settings", "Developer Console", "Logout",
				"Switching to lightning Experience" };
		List<WebElement> userNavMenu = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		boolean result = checkDropdownList(userNavMenu, listMenu, "UserMenu List");

		userMenuDropDownlog.info(result);

		if (result) {
			userMenuDropDownlog.info("Test case is Passed");
		} else {
			userMenuDropDownlog.error("Test case is Failed");
		}


	}
	
	@Test
	public void selectMyProfileFrmUserNameMenuTC06() throws InterruptedException {
		selectUserMenuFrmUserNameDropdownTC05();
		Thread.sleep(3000);
		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		clickElement(myProfile, "MyProfile link");
		String expMyProfiletitle = "User: priyanka shinde ~ Salesforce - Developer Edition";
		String actMyProfiletitle = getTitle(driver, "My Profile Page");
		userMenuDropDownlog.info(actMyProfiletitle);
		if (expMyProfiletitle.equals(actMyProfiletitle)) {

			userMenuDropDownlog.info("My Profile Page is Displayed");
		} else

		{
			userMenuDropDownlog.error("My Profile Page is not Displayed");
		}

		WebElement editProfile = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		clickElement(editProfile, "Edit profile link");

		WebElement eleFrame = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));

		driver.switchTo().frame(eleFrame);

		userMenuDropDownlog.info("Edit profile pop up window is displayed with contact and About tabs to edit.");
		WebElement eleAbout = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
		clickElement(eleAbout, "About tab");
		WebElement eleLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		enterText(eleLastName, "nicolas", "Last Name textbox");
		WebElement eleSaveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
		clickElement(eleSaveAll, "Save All button");

		driver.switchTo().defaultContent();

		String expUserLoginName = "priyanka nicolas";
		WebElement userLoginName = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		String actLoginName = getTextFromElement(userLoginName, "Login User Name");
		if (expUserLoginName.equals(actLoginName)) {
			userMenuDropDownlog.info("Changed User Last name is dislayed");

		} else {
			userMenuDropDownlog.error("Changed User Last name is not dislayed");
		}

		WebElement elePost = driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
		clickElement(elePost, "Post Link");
		WebElement eleframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(eleframe);
		userMenuDropDownlog.info("hi");
		WebElement eleText = driver.findElement(By.cssSelector("body.chatterPublisherRTE.cke_editable"));
		enterText(eleText, "testing", "Enter text");

		driver.switchTo().defaultContent();
		WebElement eleShare = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		clickElement(eleShare, "Share button");
		WebElement txtele = driver.findElement(By.xpath("(//p)[2]"));
		String exptext = "testing";
		String acttext = getTextFromElement(txtele, "posted extract text");
		userMenuDropDownlog.info(acttext);
		if (exptext.equals(acttext)) {
			userMenuDropDownlog.info("Entered text is dislayed");

		} else {
			userMenuDropDownlog.error("Entered text is not dislayed");
		}
		WebElement eleFile = driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		clickElement(eleFile, "File Link");
		Thread.sleep(5000);

		clickElement(eleFile, "File Link");
		WebElement eleUpload = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		clickElement(eleUpload, "Upload File");
		Thread.sleep(5000);
		WebElement eleChoose = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		enterText(eleChoose, "/Users/ramkrishnaborhade/Desktop/Screen Shot 2020-07-14 at 10.30.24 PM.png",
				"Choode file path");
		
		clickElement(eleShare, "Share button");
		String expfile = "posted file";
		WebElement uplodedfile = driver
				.findElement(By.xpath("(//span[@title='Screen Shot 2024-02-07 at 12.47.07 PM' ])[1]"));
		String actfile = getTextFromElement(uplodedfile, "posted extract text");
		userMenuDropDownlog.info(acttext);
		if (actfile.equals(expfile)) {
			userMenuDropDownlog.info("File is dislayed");

		} else {
			userMenuDropDownlog.error("File is not dislayed");
		}

		WebElement elePhoto = driver.findElement(By.xpath("//img[@title='priyanka nicolas']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elePhoto).click().perform();

		Thread.sleep(5000);
		WebElement eleAddPhoto = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		clickElement(eleAddPhoto, "Add photo");
		Thread.sleep(5000);
		WebElement eleIframe = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(eleIframe);
		userMenuDropDownlog.info("hi");
		WebElement eleChooseFile = driver.findElement(By.xpath("//input[@class='fileInput']"));
		enterText(eleChooseFile, "/Users/ramkrishnaborhade/Desktop/Screen Shot 2020-07-13 at 10.57.29 PM.png",
				"Choose file");
		Thread.sleep(9000);
		WebElement eleSaveFile = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		clickElement(eleSaveFile, "Save uploaded file");
		// validation remaining

	}

	
	@Test
	public void selectMySettingsFrmUserNameMenuTC07() throws InterruptedException {

		selectUserMenuFrmUserNameDropdownTC05();
		Thread.sleep(3000);
		WebElement myProfile = driver.findElement(By.linkText("My Settings"));
		clickElement(myProfile, "My Settings link");
		String expMySettingstitle = "Hello, priyanka nicolas! ~ Salesforce - Developer Edition";
		String actMySettingstitle = getTitle(driver, "My Settings Page");
		userMenuDropDownlog.info(actMySettingstitle);
		if (expMySettingstitle.equals(actMySettingstitle)) {

			userMenuDropDownlog.info("My Settings Page is Displayed");
		} else

		{
			userMenuDropDownlog.error("My Settings Page is not Displayed");
		}

		WebElement linkPesonal = driver.findElement(By.xpath("//a/span[text()='Personal']"));
		clickElement(linkPesonal, "Personal link");

		WebElement linkloginHistory = driver.findElement(By.xpath("//a/span[text()='Login History']"));
		clickElement(linkloginHistory, "Login History");

		String exppageTitle = "Login History ~ Salesforce - Developer Edition";
		String actpageTitle = getTitle(driver, "Login History Page");

		if (actpageTitle.equals(exppageTitle)) {
			userMenuDropDownlog.info("Login History page is displayed");
		} else {
			userMenuDropDownlog.error("Login History page is not displayed");
		}

		 WebElement linkDownload = driver.findElement(By.xpath("//a[contains(text(),'Download login history forlast six months,')]"));
		 clickElement(linkDownload, "Download link");

		userMenuDropDownlog.info("File is Downloaded");

		WebElement linkDisplayLayout = driver.findElement(By.xpath("//a/span[text()='Display & Layout']"));
		clickElement(linkDisplayLayout, "Display & Layout link");

		WebElement linkCustomizeMyTabs = driver.findElement(By.xpath("//a/span[text()='Customize My Tabs']"));
		clickElement(linkCustomizeMyTabs, "Customize My Tabs link");
		Thread.sleep(5000);
		WebElement drpdownCustomApp = driver.findElement(By.xpath("//select[@id='p4']"));
		selectDropdownByVisibleText(drpdownCustomApp, "Salesforce Chatter", "Salesforce Chatter option");
		Thread.sleep(5000);
		WebElement drpdownAvailbleTabs = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		selectDropdownByVisibleText(drpdownAvailbleTabs, "Reports", "Select Reports option dropdown");
		Thread.sleep(5000);
		WebElement imgAdd = driver.findElement(By.xpath("//img[@title='Add']"));
		clickElement(imgAdd, "Click on Add");
		Thread.sleep(5000);
		WebElement drpdwnSelectedTabs = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		boolean result = verifyOptionFromDropdown(drpdwnSelectedTabs, "Reports", "Check Reports option dropdown");

		if (result) {
			userMenuDropDownlog.info("Reports option is present in dropdown");
		} else {
			userMenuDropDownlog.error("Reports option is not present in dropdown");
		}

		WebElement btnSave = driver.findElement(By.xpath("//input[@title='Save']"));
		clickElement(btnSave, "Save");

		Thread.sleep(3000);

		WebElement linkEmail = driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
		clickElement(linkEmail, "Email");

		Thread.sleep(3000);
		WebElement lnkMyEmailSettings = driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		clickElement(lnkMyEmailSettings, "My Email Settings");

		WebElement txtbxEmailName = driver.findElement(By.xpath("//input[@id='sender_name']"));
		enterText(txtbxEmailName, "priyanka", "Email name");
		Thread.sleep(3000);
		WebElement txtbxEmailAddress = driver.findElement(By.xpath("//input[@id='sender_email']"));
		enterText(txtbxEmailAddress, "ms.priyankshinde@gmail.com", "Email address");
		Thread.sleep(3000);
		WebElement rdobtnYes = driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		if (!rdobtnYes.isSelected()) {
			clickElement(rdobtnYes, "Yes");

		} else {
			userMenuDropDownlog.info("Radio button is selected");
		}
		Thread.sleep(3000);

		WebElement btnSaveEmailSettings = driver.findElement(By.xpath("//input[@title='Save']"));
		clickElement(btnSaveEmailSettings, "Save");
		Alert alert = switchToAlert(driver, "Alert");
		alert.accept();

		String expMsg = "Your settings have been successfully saved.";

		WebElement succsMsg = driver.findElement(By.xpath("//div[@class='messageText']"));
		String actMsg = getTextFromElement(succsMsg, "extract message");

		if (actMsg.equals(expMsg)) {

			userMenuDropDownlog.info("Test case is Passed");
		} else {
			userMenuDropDownlog.error("Test case is Failed");
		}

		WebElement lnkCalenderReminders = driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
		clickElement(lnkCalenderReminders, "Click Calender and Reminders");

		WebElement lnkActivityReminders = driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		clickElement(lnkActivityReminders, "Click Activity Reminders");

		String parent = driver.getWindowHandle();
		userMenuDropDownlog.info(parent);

		WebElement openTestReminder = driver.findElement(By.xpath("//input[@id='testbtn']"));
		clickElement(openTestReminder, "Click Test Reminder");
		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				userMenuDropDownlog.info(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}

		}
		driver.switchTo().window(parent);

	}
	
	@Test

	public void selectDevelopersConsoleFrmUserNameMenuTC08() throws InterruptedException {

		selectUserMenuFrmUserNameDropdownTC05();
		Thread.sleep(3000);
		WebElement myProfile = driver.findElement(By.linkText("Developer Console"));
		clickElement(myProfile, "Developer Console link");

//		String parent = driver.getWindowHandle();
//		// userMenuDropDownlog.info(parent);
//		Set<String> s = driver.getWindowHandles();
//
//		Iterator<String> I1 = s.iterator();
//
//		while (I1.hasNext()) {
//
//			String child_window = I1.next();
//
//			if (!parent.equals(child_window)) {
//				driver.switchTo().window(child_window);
//
//				String expTitle = "Developer Console";
//				String actTitle = driver.switchTo().window(child_window).getTitle();
//				userMenuDropDownlog.info(actTitle);
//
//				if (actTitle.equals(expTitle)) {
//
//					userMenuDropDownlog.info("Test case is Passed");
//				} else {
//					userMenuDropDownlog.error("Test case is Failed");
//				}
//
//				driver.close();
//			}
//
//		}
//		driver.switchTo().window(parent);
		String expTitle = "Developer Console";
		String actTitle=switchToWindow(driver, "Developer Console");
		if (actTitle.equals(expTitle)) {

			userMenuDropDownlog.info("Test case is Passed");
		} else {
			userMenuDropDownlog.error("Test case is Failed");
		}

	}
	
	@Test
	public void selectLogoutFrmUserNameMenuTC09() throws InterruptedException {
		selectUserMenuFrmUserNameDropdownTC05();
		Thread.sleep(3000);
		salesforceLogout();
		
	}
	
	
	

	

}
