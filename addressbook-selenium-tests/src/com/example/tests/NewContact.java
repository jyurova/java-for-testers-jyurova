package com.example.tests;

import org.testng.annotations.Test;

public class NewContact extends TestBase {

  @Test
  public void testNewContactNonEmpty() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "Petr";
    contact.lastName = "Petrov";
    contact.address = "home";
    contact.homePhone = "12345r";
    contact.mobilePhone = "P12345";
    contact.workPhone = "12334v";
    contact.email = "Petrov@bla.bla";
    contact.email2 = "Petrov@qwe.qwe";
    contact.yearBD = "7896";
    contact.address2 = "123";
    contact.phone2 = "987654";
    contact.bday = "22";
    contact.bmonth = "May";  
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submit();
    app.getContactHelper().returnToHP();
  }
 
  @Test
  public void testNewContactEmpty() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initNewContactCreation();
	    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "", "", "", "7", "April"));
	    app.getContactHelper().submit();
	    app.getContactHelper().returnToHP();
	  }
}

