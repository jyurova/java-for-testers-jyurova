package com.example.tests;

import org.testng.annotations.Test;
import static com.example.fw.ContactHelper.CREATION;

public class NewContact extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigateTo().mainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "first name 1";
    contact.lastname = "last name 1";
    contact.address = "address 1";
    contact.home = "123";
    contact.mobile = "1234";
    contact.work = "q12345"; 
    contact.email = "email1@email1.email";
    contact.email2 = "email2";
    contact.byear = "1908";
    contact.address2 = "address 2";
    contact.phone2 = "phone 2";
    app.getContactHelper().fillContactForm(contact, CREATION);
    app.getContactHelper().submit();
    app.navigateTo().returnToHomePage();
    
}
}
