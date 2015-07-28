package com.example.tests;

import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class NewContact extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	//save old state
	List<ContactData> oldList =  app.getContactHelper().getContacts();
	
	//actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "first name 1";
    contact.lastName = "last name 1";
    contact.address = "address 1";
    contact.homePhone = "123";
    contact.mobilePhone = "1234";
    contact.workPhone = "q12345"; 
    contact.email = "email1";
    contact.email2 = "email2";
    contact.yearBD = "1908";
    contact.address2 = "address 2";
    contact.phone2 = "phone 2";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submit();
    app.getNavigationHelper().returnToHomePage();
    
    //save new state
	List<ContactData> newList =  app.getContactHelper().getContacts();
    
    //compare states
	assertEquals(newList.size(), oldList.size() + 1); 

  }
}
