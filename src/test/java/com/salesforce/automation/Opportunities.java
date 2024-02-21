package com.salesforce.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforce.base.BaseSalesforce;

public class Opportunities extends BaseSalesforce {

	protected Logger opportunitieslog = LogManager.getLogger();

	@Test

	public void baseOptyLogin() throws InterruptedException {
		salesforce_Login();
		Thread.sleep(3000);
		WebElement optyTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickElement(optyTab, "Click on Opportunity");
		Thread.sleep(3000);

		String expoptyHome = "Opportunities\n" + "Home";

		WebElement optyHome = driver.findElement(By.xpath("//div[@class='content']"));
		String actoptyHome = getTextFromElement(optyHome, "Opportunity Home");

		opportunitieslog.info(actoptyHome);
		if (actoptyHome.equals(expoptyHome)) {
			opportunitieslog.info("Test case is Passed.Opportunity Home is displayed");
		} else {
			opportunitieslog.error("Test case is Failed.Opportunity Home is not displayed");
		}
	}

	@Test

	public void CheckdrpdwnOptyTC15() throws InterruptedException {

		baseOptyLogin();
		Thread.sleep(3000);
		String[] expoptyList = { "All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities",
				"New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities",
				"Won" };

		WebElement drpdwnOptyele = driver.findElement(By.xpath("//select[@id='fcf']"));
		boolean flag = checkSelectDropdownList(drpdwnOptyele, expoptyList, "View dropdwon");

		if (flag == true) {
			opportunitieslog.info("Test case is Passed and dropdown options are availabled");
		} else {
			opportunitieslog.error("Test case is failed and dropdown options are not availabled");
		}
		// closeBrowser();

	}

	@Test

	public void createNewOptyTC16() throws InterruptedException {
		baseOptyLogin();
		Thread.sleep(3000);
		WebElement newbtn = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(newbtn, "Click on New button");
		Thread.sleep(1000);
		WebElement optyName = driver.findElement(By.xpath("//input[@id='opp3']"));
		enterText(optyName, "test10", "Enter text on optyName");
		Thread.sleep(1000);
		WebElement accntName = driver.findElement(By.xpath("//input[@id='opp4']"));
		enterText(accntName, "United Oil & Gas Corp.", "Enter text on optyName");
		Thread.sleep(1000);
		// WebElement
		// closeDate=driver.findElement(By.xpath("//span[@class='dateFormat']"));
		WebElement closeDate = driver.findElement(By.xpath("//input[@id='opp9']"));
		clickElement(closeDate, "Click closedate");
		Thread.sleep(3000);
		WebElement yearPcker = driver.findElement(By.xpath("//select[@id='calYearPicker']"));
		selectDropdownByVisibleText(yearPcker, "2025", "enter year");

		Thread.sleep(3000);
		WebElement monthPcker = driver.findElement(By.xpath("//select[@id='calMonthPicker']"));
		selectDropdownByVisibleText(monthPcker, "July", "enter month");

		Thread.sleep(3000);
		enterDate("18");
		Thread.sleep(3000);

		WebElement stagedrpdwn = driver.findElement(By.xpath("//select[@id='opp11']"));
		selectDropdownByVisibleText(stagedrpdwn, "Value Proposition", "Select Value Proposition from stage dropdown");
		Thread.sleep(1000);
		// WebElement
		// probabiltytxtbx=driver.findElement(By.xpath("//input[@id='opp12']"));
		// enterText(probabiltytxtbx, "50", "Enter probabilty");
		// Thread.sleep(1000);
		WebElement leadSourcedrpdwn = driver.findElement(By.xpath("//select[@id='opp6']"));
		selectDropdownByVisibleText(leadSourcedrpdwn, "Web", "Enter lead Source");
		Thread.sleep(1000);
		WebElement prmecampsorcetxtbx = driver.findElement(By.xpath("//input[@id='opp17']"));
		enterText(prmecampsorcetxtbx, "", "Primary Campaign Source");
		Thread.sleep(1000);
		WebElement savebtn = driver.findElement(By.xpath("//input[@title='Save']"));
		clickElement(savebtn, "Click on Save");
		Thread.sleep(1000);
		WebElement newoptynme = driver.findElement(By.xpath("//h2[@class='pageDescription']"));
		String expoptyName = "test10";
		String actoptyName = getTextFromElement(newoptynme, "New opportunity created");
		Thread.sleep(1000);
		if (actoptyName.equals(expoptyName)) {
			opportunitieslog.info("Test case is Passed and New opportinuty displayed");
		} else {
			opportunitieslog.error("Test case is Failed and New opportinuty is not displayed");
		}

		// closeBrowser();

	}

	public void enterDate(String date) throws InterruptedException {
		List<WebElement> tbleCol = driver.findElements(By.xpath("(//table[@class=\"calDays\"]//tr/td)"));

		for (int i = 1; i < tbleCol.size(); i++) {

			if (tbleCol.get(i).getText().equals(date))
				driver.findElement(By.xpath("(//table[@class=\"calDays\"]//tr/td)[" + i + "]")).click();

		}

	}

	@Test

	public void checkOptyPipelineReportTC17() throws InterruptedException {
		baseOptyLogin();
		Thread.sleep(3000);
		WebElement optypiplnk = driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
		clickElement(optypiplnk, "Pipeline link clicked");
		WebElement piplneheader = driver.findElement(By.xpath("//h1[text()='Opportunity Pipeline']"));
		String expoptypiplne = "Opportunity Pipeline";
		String actoptpiplne = getTextFromElement(piplneheader, "Opportunity pipeline text");
		Thread.sleep(3000);
		if (expoptypiplne.equals(actoptpiplne)) {
			opportunitieslog.info("Test case is Passed and opportinuty pipeline report is displayed");
		} else {
			opportunitieslog.error("Test case is Failed and opportinuty pipeline report  is not displayed");
		}
		//closeBrowser();

	}

	@Test

	public void checkStuckOptyReportTC18() throws InterruptedException {

		baseOptyLogin();
		Thread.sleep(3000);
		WebElement stuckOpty = driver.findElement(By.xpath("//a[text()='Stuck Opportunities']"));
		clickElement(stuckOpty, "Stuck Opportunity clicked");
		WebElement stuckoptyHeader = driver.findElement(By.xpath("//h1[text()='Stuck Opportunities']"));
		String expstuckOpt = "Stuck Opportunities";
		String actstuckOpt = getTextFromElement(stuckoptyHeader, "Stuck opportunity text");
		Thread.sleep(3000);
		if (expstuckOpt.equals(actstuckOpt)) {
			opportunitieslog.info("Test case is Passed and Stuck opportunity report is displayed");
		} else {
			opportunitieslog.error("Test case is Failed and Stuck opportinuty report  is not displayed");
		}
		//closeBrowser();

	}

	@Test

	public void checkQuarterlySummaryReportTC19() throws InterruptedException {

		baseOptyLogin();
		Thread.sleep(3000);

		WebElement intervaldrpdwn = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		selectDropdownByVisibleText(intervaldrpdwn, "Current and Next FQ", "Select current and next FQ");
		WebElement includedrpdwn = driver.findElement(By.xpath("//select[@id='open']"));
		selectDropdownByVisibleText(includedrpdwn, "All Opportunities", "Select All opportunity");
		WebElement runreportBtn = driver.findElement(By.xpath("//input[@title='Run Report']"));

		clickElement(runreportBtn, "Clicked Run Report");
		Thread.sleep(3000);

		WebElement optyHeader = driver.findElement(By.xpath("//h1[text()='Opportunity Report']"));
		String expOpt = "Opportunity Report";
		String actOpt = getTextFromElement(optyHeader, "Opportunity Report text");
		Thread.sleep(3000);
		if (expOpt.equals(actOpt)) {
			opportunitieslog.info("Test case is Passed and opportunity report is displayed");
		} else {
			opportunitieslog.error("Test case is Failed and opportinuty report  is not displayed");
		}
		//closeBrowser();

	}

}
