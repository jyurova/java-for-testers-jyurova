package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ContactData parameterObject) {
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



	public void submit() {
			driver.findElement(By.name("submit")).click();
		}
	
	public void returnToHP() {
		driver.findElement(By.linkText("home page")).click();
	}


}
