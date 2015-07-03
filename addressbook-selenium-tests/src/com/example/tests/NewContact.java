package com.example.tests;

import org.testng.annotations.Test;

public class NewContact extends TestBase {

  @Test
  public void testNewContactNonEmpty() throws Exception {
    openMainPage();
    initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "Petr";
    contact.lastName = "Petrov";
    contact.address = "home";
    contact.homePhone = "12345r";
    contact.mobilePhone = "P12345";
    contact.workPhone = "12334v";
    contact.email1 = "Petrov@bla.bla";
    contact.email2 = "Petrov@qwe.qwe";
    contact.yearBD = "7896";
    contact.address2 = "home2";
    contact.phone2 = "987654";
    contact.bday = "22";
    contact.bmonth = "May";  
	fillGroupForm(contact);
    submit();
    returnToHP();
  }
 
  @Test
  public void testNewContactEmpty() throws Exception {
	    openMainPage();
	    initNewContactCreation();
	    fillGroupForm(new ContactData("", "", "", "", "", "", "", "", "", "", "", "7", "April"));
	    submit();
	    returnToHP();
	  }
}

