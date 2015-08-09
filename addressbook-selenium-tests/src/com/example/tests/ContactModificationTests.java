package com.example.tests;

import org.testng.annotations.Test;
import com.example.fw.ContactHelper;

public class ContactModificationTests extends TestBase{
	
	@Test
	public void modifySomeContact() {	
	app.navigateTo().mainPage();
	app.getContactHelper().chooseContactForEdit(1);
	ContactData contact = new ContactData();
	contact.firstname = "sdf1";
	contact.lastname = "sdfg2";
	app.getContactHelper().fillContactForm(contact, ContactHelper.MODIFICATION);
	app.getContactHelper().updateContact();
	app.navigateTo().returnToHomePage();

}
}
