package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test
	public void modifySomeContact() {	
	app.navigateTo().mainPage();
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
	app.getContactHelper().chooseContactForEdit(0);
	ContactData contact = new ContactData();
	contact.firstname = "sdf11";
	contact.lastname = "sdfg22";
    contact.title = contact.firstname + " " + contact.lastname;
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().updateContact();
	app.navigateTo().returnToHomePage();

    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
	
    
    //compare states
	oldList.remove(0);
    oldList.add(new ContactData(contact.title));
    Collections.sort(oldList);
    assertEquals(newList, oldList);
}
}
