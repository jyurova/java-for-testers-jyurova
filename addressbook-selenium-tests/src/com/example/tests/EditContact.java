package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class EditContact extends TestBase {

@Test (dataProvider= "randomValidGroupGenerator")
public void editContact(ContactData contact) {
	app.getNavigationHelper().openMainPage();
	   //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
	int index = app.getContactHelper().random(oldList);
 
    //actions
	app.getContactHelper().selectContactForEdit(index);
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().submitContactModification();
	app.getNavigationHelper().returnToHomePage();
 	

	//save new state
	List<ContactData> newList = app.getContactHelper().getContacts(); 
	//compare states
    app.getContactHelper().compareStatesModification(contact, oldList, index, newList);
}
}

