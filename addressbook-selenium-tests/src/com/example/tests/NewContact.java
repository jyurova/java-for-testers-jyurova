package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;

public class NewContact extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigateTo().mainPage();
	
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	//actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "test name 1";
    contact.lastname = "test name 1";
    contact.address = "address 1";
    contact.home = "123";
    contact.mobile = "1234";
    contact.work = "q12345"; 
    contact.email = "email1@email1.email";
    contact.email2 = "email2";
    contact.byear = "1908";
    contact.address2 = "address 2";
    contact.phone2 = "phone 2";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submit();
    app.navigateTo().returnToHomePage();
    
    //compare states
    List<ContactData> newList = app.getContactHelper().getContacts();
    assertEquals(newList.size(), oldList.size() + 1) ;
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
}
}
