package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NewContact extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewContactWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initNewContactCreation();
 	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submit();
    app.getNavigationHelper().returnToHomePage();
    
    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
	oldList.add(contact);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
  
  }
 }

