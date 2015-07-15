package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
			type(By.name("firstname"), contact.firstname);
			type(By.name("lastname"), contact.lastName);
			type(By.name("address"), contact.address);
			type(By.name("home"), contact.homePhone);
			type(By.name("mobile"), contact.mobilePhone);
			type(By.name("work"), contact.workPhone);
			type(By.name("email"), contact.email);
			type(By.name("emai2"), contact.email2);
		    selectByTest(By.name("bday"), contact.bday);
		    selectByTest(By.name("bmonth"), contact.bmonth);
		    type(By.name("byear"), contact.yearBD);
		    //selectByTest(By.name("new_group"), "Eddie_would_go");
		    type(By.name("address2"), contact.address2);
		    type(By.name("phone2"), contact.phone2);

		}

	public void submit() {
			click(By.name("submit"));
		}
	
	public void returnToHP() {
		click(By.linkText("home page"));
	}


}
