package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void modifySomeContact(ContactData contact) {	
	app.navigateTo().mainPage();
	
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	int index = app.getContactHelper().random(oldList);
	
	//actions
	app.getContactHelper().modifyContact(index, contact);

    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
	app.getContactHelper().compareStatesModification(oldList, index, contact, newList);
}
}
