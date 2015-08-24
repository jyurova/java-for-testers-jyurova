package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class NewContact extends TestBase {
		
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationwithValidData(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submit();
    app.navigateTo().returnToHomePage();
    
    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();

	//compare states
    app.getContactHelper().compareStatesContactCreation(contact, oldList, newList);
    
}
}
