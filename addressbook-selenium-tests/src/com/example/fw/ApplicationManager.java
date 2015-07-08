package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {
	
	public static WebDriver driver;
	public static String baseUrl;
	public static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	public ApplicationManager() {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	
	public void stop() {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

	
	//GroupCreationTests
	public void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		    driver.findElement(By.name("submit")).click();
		}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		    driver.findElement(By.name("group_name")).clear();
		    driver.findElement(By.name("group_name")).sendKeys(group.name);
		    driver.findElement(By.name("group_header")).clear();
		    driver.findElement(By.name("group_header")).sendKeys(group.header);
		    driver.findElement(By.name("group_footer")).clear();
		    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
		}

	public void initNewGroupCreation() {
		    driver.findElement(By.name("new")).click();
		}

	public void goToGroupsPage() {
		    driver.findElement(By.linkText("groups")).click();
		}

	public void openMainPage() {
		    driver.get(baseUrl + "/addressbookv4.1.4/");
		}

	public boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

	public boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

	public String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }

	//New Contact
	public void returnToHP() {
		driver.findElement(By.linkText("home page")).click();
	}

	public void submit() {
			driver.findElement(By.name("submit")).click();
		}

	public void fillGroupForm(TestBase testBase, ContactData parameterObject) {
			driver.findElement(By.name("firstname")).clear();
		    driver.findElement(By.name("firstname")).sendKeys(parameterObject.firstname);
		    driver.findElement(By.name("lastname")).clear();
		    driver.findElement(By.name("lastname")).sendKeys(parameterObject.lastName);
		    driver.findElement(By.name("address")).clear();
		    driver.findElement(By.name("address")).sendKeys(parameterObject.address);
		    driver.findElement(By.name("home")).clear();
		    driver.findElement(By.name("home")).sendKeys(parameterObject.homePhone);
		    driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys(parameterObject.mobilePhone);
		    driver.findElement(By.name("work")).clear();
		    driver.findElement(By.name("work")).sendKeys(parameterObject.workPhone);
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys(parameterObject.email1);
		    driver.findElement(By.name("email2")).clear();
		    driver.findElement(By.name("email2")).sendKeys(parameterObject.email2);
		    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(parameterObject.bday);
		    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(parameterObject.bmonth);
		    driver.findElement(By.name("byear")).clear();
		    driver.findElement(By.name("byear")).sendKeys(parameterObject.yearBD);
		    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Eddie_would_go");
		    driver.findElement(By.name("address2")).clear();
		    driver.findElement(By.name("address2")).sendKeys(parameterObject.address2);
		    driver.findElement(By.name("phone2")).clear();
		    driver.findElement(By.name("phone2")).sendKeys(parameterObject.phone2);
		}

	public void initNewContactCreation() {
			driver.findElement(By.linkText("add new")).click();
		}

}
