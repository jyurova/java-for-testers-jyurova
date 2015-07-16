package com.example.tests;

import org.testng.annotations.Test;

public class EditContact extends TestBase {

@Test
public void editContact() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().selectContactForEdit(1);
	ContactData contact = new ContactData();
	contact.firstname = "cracozabra";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactModification();
	app.getNavigationHelper().returnToHP();
 	}
}
