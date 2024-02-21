package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import com.salesforce.utilities.ExtentReportsUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver = null;
	protected Logger basetestlog = LogManager.getLogger();
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			basetestlog.info("browser instance chrome created.");
			
			driver.manage().window().maximize();
			basetestlog.info("window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			basetestlog.info("browser instance firefox created.");
			
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			basetestlog.info("browser instance edge created.");
			
			driver.manage().window().maximize();
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			basetestlog.info("browser instance opera created.");
			
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			basetestlog.info("browser instance safari created.");
			

			break;

		default:
			basetestlog.info("Unsupported browser: " + browserName);
			
		}

		// return driver;
	}

	public void goToUrl(String url) {
		driver.get(url);
		basetestlog.info(url + "is entered");
		

	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			basetestlog.info("username data is entered in " + objectName + " textbox");
			extentReport.logTestInfo("username data is entered in " + objectName + " textbox");
		
		}
		else
		{
			basetestlog.info(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			basetestlog.info(objectName + "element is clicked");
			extentReport.logTestInfo(objectName + "element is clicked");
			

		} else {
			basetestlog.info(objectName + " element is not enabled");

		}
	}

	public void checkElement(WebElement ele, String objectName) {
		if (!ele.isSelected()) {
			ele.click();
			basetestlog.info(objectName + "element is cheked");
			extentReport.logTestInfo(objectName + "element is checked");

		} else {
			basetestlog.info(objectName + " element is not cheked");

		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		basetestlog.info("text is extracted from " + objectName);
		extentReport.logTestInfo("text is extracted from " + objectName);
		return data;
	}

	public void clearTextFromElement(WebElement ele, String objectName) {
		ele.clear();
		basetestlog.info("text is cleared " + objectName);
		extentReport.logTestInfo("text is cleared " + objectName);
	}
	
	public String getTitle(WebDriver driver, String objectName) {
		String title = driver.getTitle();
		basetestlog.info(objectName + "title=" + title);
		extentReport.logTestInfo(objectName + "title=" + title);
		return title;

	}

	public void selectDropdownByValue(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		select.selectByValue(value);
		basetestlog.info(objectName);
		extentReport.logTestInfo(objectName);
		

	}

	public void selectDropdownByVisibleText(WebElement ele, String text, String objectName) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
		basetestlog.info(objectName);
		extentReport.logTestInfo(objectName);

	}
	public boolean selectOptionFromDropdownByVisibleText(WebElement ele, String text, String objectName) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
		basetestlog.info(objectName);
		extentReport.logTestInfo(objectName);
		return true;

	}
	
	public void checkOptionFromDropdown(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();

		for (WebElement optionele : options) {
			String option = optionele.getText();
			basetestlog.info(option);
			if (option.equals(value)) {
				basetestlog.info("Option is available");
				extentReport.logTestInfo("Option is available");
				break;
			} else {
				basetestlog.info("Option is not available");
				break;
			}

		}

	}

	public boolean verifyOptionFromDropdown(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();
		boolean flag = false;
		for (WebElement optionele : options) {

			if (optionele.getText().equals(value)) {

				flag = true;

			}

		}
		return flag;

	}

	public boolean verifyOptionFromDropdownIsDisplayed(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();
		boolean flag = false;
		for (WebElement optionele : options) {
			
			if (optionele.isSelected())
			{
				if(optionele.getText().equals(value))
				flag = true;

			}

		}
		return flag;

	}
	
	
	
	public boolean checkSelectDropdownList(WebElement ele, String expList[], String objectName) {

		Select drpdwnView = new Select(ele);
		List<WebElement> drpdwnList = drpdwnView.getOptions();
		boolean match = false;
		for (WebElement view : drpdwnList) {

			for (int i = 0; i < drpdwnList.size(); i++) {

				if (expList[i].equals(view.getText())) {
					match = true;
				}

			}

		}
		return match;

	}
	
	public void selectOptionFromDropdownList(List<WebElement> list, String text, String objectName) {
		
	
		for (WebElement ele : list) {

			for (int i = 0; i < list.size(); i++) {

				if (text.equals(ele.getText())) {
					
					clickElement(ele, objectName);
					
				}

			}

		}
	
		

	}
	
	
	
	//;;;

	public boolean checkDropdownList(List<WebElement> list, String expList[], String objectName) {

	
		boolean match = false;
		for (WebElement ele : list) {

			for (int i = 0; i < list.size(); i++) {

				if (expList[i].equals(ele.getText())) {
					match = true;
				}

			}

		}
		return match;

	}
	
	public boolean isDisplayDropDownList(List<WebElement> list, String expList[], String objectName) {

		
		boolean match = false;
		
		for (WebElement ele : list) {

			if (ele.isDisplayed())
			{

				for (int i = 0; i < expList.length; i++) {

					if (expList[i].equals(ele.getText())) {
						match = true;
					}

				}
			}

		}
		return match;

	}
	
	public String switchToWindow(WebDriver driver,String objectName) {
		
		String parent = driver.getWindowHandle();
		 basetestlog.info(parent);
		Set<String> s = driver.getWindowHandles();
		String actTitle=null;

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				
				 actTitle = driver.switchTo().window(child_window).getTitle();

				driver.close();
			}

		}
		driver.switchTo().window(parent);
		return actTitle;
		
	}

	public Alert switchToAlert(WebDriver driver, String objectName) {
		Alert al = driver.switchTo().alert();
		basetestlog.info(objectName);
		extentReport.logTestInfo(objectName);

		return al;

	}

	public String getTextFromAlert(WebDriver driver, String objectName) {
		Alert alert = switchToAlert(driver, objectName);
		String actualError = alert.getText();
		basetestlog.info("Getting text from alert" + actualError);
		extentReport.logTestInfo("Getting text from alert" + actualError);
		acceptAlert(driver, objectName);
		return actualError;

	}

	public void acceptAlert(WebDriver driver, String objectName) {
		Alert alert = switchToAlert(driver, objectName);
		alert.accept();

	}

	public void dismissAlert(WebDriver driver, String objectName) {
		Alert alert = switchToAlert(driver, objectName);
		alert.dismiss();

	}
	
	

	public void closeBrowser() {
		driver.close();
		basetestlog.info("browser instance closed");
		driver = null;
	}
	

	public void quitBrowser() {
		driver.quit();
		basetestlog.info("all browser closed");
		driver=null;
		
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			basetestlog.info("captured the screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			basetestlog.info("went wrong when capturing the screen");
			
		}
	}
	
	public void takescreenshot(WebElement element,String filepath) {
		File src = element.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			basetestlog.info("captured element screenshot");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			basetestlog.info("went wrong when capturing the screen");
			
		}
		
		
	}
	
	
	

}