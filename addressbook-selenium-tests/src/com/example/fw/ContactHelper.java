package com.example.fw;

import java.util.ArrayList;
import java.util.List;

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
		type(By.name("firstName"), contact.firstName);
	    type(By.name("lastName"), contact.lastName);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.email);
	    type(By.name("email2"), contact.email2);
	   // selectByText(By.name("bday"), "6");
	    //selectByText(By.name("bmonth"), "May");
	   type(By.name("yearBD"), contact.yearBD);
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

	public List<ContactData> getContacts() {
		List<ContactData> contacts =  new ArrayList<ContactData>();
		for 
		return contacts;
	}



}
