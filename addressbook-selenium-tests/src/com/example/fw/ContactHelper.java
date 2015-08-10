package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper  extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submit() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.home);
	    type(By.name("mobile"), contact.mobile);
	    type(By.name("work"), contact.work);
	    type(By.name("email"), contact.email);
	    type(By.name("email2"), contact.email2);
	    //selectByText(By.name("bday"), contact.bday);
	    //selectByText(By.name("bmonth"), contact.byear);
	  // type(By.name("byear"), contact.byear);
		 //selectByText(By.name("new_group"), "");
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void chooseContactForEdit(int index) {
		click(By.xpath("//img[@title='Edit'][" + index + "]"));
	}
	
	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}
	
	public void updateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));
		
	}

}
