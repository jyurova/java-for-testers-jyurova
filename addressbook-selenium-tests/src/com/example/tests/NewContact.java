package com.example.tests;

import org.testng.annotations.Test;

public class NewContact extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "first name 1";
    contact.lastname = "last name 1";
    contact.address = "address 1";
    contact.homephone = "123";
    contact.mobilephone = "1234";
    contact.workphone = "q12345";
    contact.email = "email1";
    contact.email2 = "email2";
    contact.byear = "1908";
    contact.address2 = "address 2";
    contact.phone2 = "phone 2";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submit();
    app.getNavigationHelper().returnToHomePage();
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "", "", ""));
    app.getContactHelper().submit();
    app.getNavigationHelper().returnToHomePage();
  }
}
