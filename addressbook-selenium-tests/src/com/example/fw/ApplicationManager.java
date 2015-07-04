package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {

	//GroupCreationTests
	public void returnToGroupsPage() {
	    TestBase.driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		    TestBase.driver.findElement(By.name("submit")).click();
		}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		    TestBase.driver.findElement(By.name("group_name")).clear();
		    TestBase.driver.findElement(By.name("group_name")).sendKeys(group.name);
		    TestBase.driver.findElement(By.name("group_header")).clear();
		    TestBase.driver.findElement(By.name("group_header")).sendKeys(group.header);
		    TestBase.driver.findElement(By.name("group_footer")).clear();
		    TestBase.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
		}

	public void initNewGroupCreation() {
		    TestBase.driver.findElement(By.name("new")).click();
		}

	public void goToGroupsPage() {
		    TestBase.driver.findElement(By.linkText("groups")).click();
		}

	public void openMainPage() {
		    TestBase.driver.get(TestBase.baseUrl + "/addressbookv4.1.4/");
		}

	public boolean isElementPresent(By by) {
		    try {
		      TestBase.driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

	public boolean isAlertPresent() {
		    try {
		      TestBase.driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

	public String closeAlertAndGetItsText() {
		    try {
		      Alert alert = TestBase.driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (TestBase.acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      TestBase.acceptNextAlert = true;
		    }
		  }

	//New Contact
	public void returnToHP() {
		TestBase.driver.findElement(By.linkText("home page")).click();
	}

	public void submit() {
			TestBase.driver.findElement(By.name("submit")).click();
		}

	public void fillGroupForm(TestBase testBase, ContactData parameterObject) {
			TestBase.driver.findElement(By.name("firstname")).clear();
		    TestBase.driver.findElement(By.name("firstname")).sendKeys(parameterObject.firstname);
		    TestBase.driver.findElement(By.name("lastname")).clear();
		    TestBase.driver.findElement(By.name("lastname")).sendKeys(parameterObject.lastName);
		    TestBase.driver.findElement(By.name("address")).clear();
		    TestBase.driver.findElement(By.name("address")).sendKeys(parameterObject.address);
		    TestBase.driver.findElement(By.name("home")).clear();
		    TestBase.driver.findElement(By.name("home")).sendKeys(parameterObject.homePhone);
		    TestBase.driver.findElement(By.name("mobile")).clear();
		    TestBase.driver.findElement(By.name("mobile")).sendKeys(parameterObject.mobilePhone);
		    TestBase.driver.findElement(By.name("work")).clear();
		    TestBase.driver.findElement(By.name("work")).sendKeys(parameterObject.workPhone);
		    TestBase.driver.findElement(By.name("email")).clear();
		    TestBase.driver.findElement(By.name("email")).sendKeys(parameterObject.email1);
		    TestBase.driver.findElement(By.name("email2")).clear();
		    TestBase.driver.findElement(By.name("email2")).sendKeys(parameterObject.email2);
		    new Select(TestBase.driver.findElement(By.name("bday"))).selectByVisibleText(parameterObject.bday);
		    new Select(TestBase.driver.findElement(By.name("bmonth"))).selectByVisibleText(parameterObject.bmonth);
		    TestBase.driver.findElement(By.name("byear")).clear();
		    TestBase.driver.findElement(By.name("byear")).sendKeys(parameterObject.yearBD);
		    new Select(TestBase.driver.findElement(By.name("new_group"))).selectByVisibleText("Eddie_would_go");
		    TestBase.driver.findElement(By.name("address2")).clear();
		    TestBase.driver.findElement(By.name("address2")).sendKeys(parameterObject.address2);
		    TestBase.driver.findElement(By.name("phone2")).clear();
		    TestBase.driver.findElement(By.name("phone2")).sendKeys(parameterObject.phone2);
		}

	public void initNewContactCreation() {
			TestBase.driver.findElement(By.linkText("add new")).click();
		}

}
