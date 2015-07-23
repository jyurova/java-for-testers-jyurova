package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test
	public void modifySomeContact() {	
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().chooseContactForEdit(1);
	ContactData contact = new ContactData();
	contact.firstname = "sdf1";
	contact.lastname = "sdfg2";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().updateContact();
	app.getNavigationHelper().returnToHomePage();

}
}
