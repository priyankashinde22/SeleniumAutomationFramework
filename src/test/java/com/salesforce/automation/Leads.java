package com.salesforce.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforce.base.BaseSalesforce;

public class Leads extends BaseSalesforce {

	protected Logger leadslog = LogManager.getLogger();

	@Test

	public void checkLeadsTabTC20() throws InterruptedException {

		salesforce_Login();
		Thread.sleep(3000);
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		clickElement(leadsTab, "Click on Leads");
		Thread.sleep(3000);
		String expleadsHome = "Leads\n" + "Home";

		WebElement leadsHome = driver.findElement(By.xpath("//div[@class='content']"));
		String actleadsHome = getTextFromElement(leadsHome, "Leads Home");
		leadslog.info(actleadsHome);
		if (expleadsHome.equals(actleadsHome)) {
			leadslog.info("Test case is Passed.Leads Home is displayed");
		} else {
			leadslog.error("Test case is Failed.Leads Home is not displayed");

		}
		// closeBrowser();

	}

	@Test

	public void leadsSelectViewTC21() throws InterruptedException {
		checkLeadsTabTC20();
		String[] expList = { "All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads" };

		WebElement drpdwnViewele = driver.findElement(By.xpath("//select[@id='fcf']"));
		boolean flag = checkSelectDropdownList(drpdwnViewele, expList, "View dropdwon");

		if (flag == true) {
			leadslog.info("Test case is Passed and dropdown options are availabled");
		} else {
			leadslog.error("Test case is failed and dropdown options are not availabled");
		}
		// closeBrowser();
	}

	@Test

	public void defaultViewTC22() throws InterruptedException {
		checkLeadsTabTC20();
		Thread.sleep(3000);
		WebElement drpdwnViewele = driver.findElement(By.xpath("//select[@id='fcf']"));
		selectDropdownByVisibleText(drpdwnViewele, "My Unread Leads", "Select My Unread Leads");
		salesforceLogout();
		checkLeadsTabTC20();
		WebElement eleGo = driver.findElement(By.xpath("//input[@title='Go!']"));
		clickElement(eleGo, "Click on Go button");
		Thread.sleep(3000);
		WebElement newLead = driver.findElement(By.xpath("//input[@title='New Lead']"));
		if (newLead.isDisplayed()) {
			leadslog.info("Test case is Passed");
		} else {
			leadslog.error("Test case is Failed");
		}

	}

	@Test
	public void todaysLeadsTC23() throws InterruptedException {
		checkLeadsTabTC20();
		Thread.sleep(3000);
		WebElement drpdwnViewele = driver.findElement(By.xpath("//select[@id='fcf']"));
		selectDropdownByVisibleText(drpdwnViewele, "Today's Leads", "Select My Unread Leads");
		salesforceLogout();
		checkLeadsTabTC20();
		WebElement eleGo = driver.findElement(By.xpath("//input[@title='Go!']"));
		clickElement(eleGo, "Click on Go button");
		Thread.sleep(3000);
		WebElement newLead = driver.findElement(By.xpath("//input[@title='New Lead']"));
		if (newLead.isDisplayed()) {
			leadslog.info("Test case is Passed");
		} else {
			leadslog.error("Test case is Failed");
		}
		// closeBrowser();
	}

	@Test

	public void newLeadsHomeTC24() throws InterruptedException {
		checkLeadsTabTC20();
		Thread.sleep(3000);
		WebElement newbtn = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(newbtn, "Click on New button");
		Thread.sleep(3000);
		WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		enterText(lastName, "ABCD", "Enter text in lastname textBox");
		Thread.sleep(1000);
		WebElement company = driver.findElement(By.xpath("//input[@id='lea3']"));
		enterText(company, "ABCD", "Enter text in company textBox");
		Thread.sleep(1000);
		WebElement savebtn = driver.findElement(By.xpath("//input[@title='Save']"));
		clickElement(savebtn, "Click on Save button");
		WebElement newLead = driver.findElement(By.xpath("//h2[@class='topName']"));
		String expLead = "ABCD";
		String actnewLead = getTextFromElement(newLead, "Created New Lead");
		if (expLead.equals(actnewLead)) {
			leadslog.info("Test case is Passed");
		} else {
			leadslog.error("Test case is Failed");
		}
		// closeBrowser();

	}

}
