package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

@Test
public void deleteContact() {
	app.navigateTo().mainPage();
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
	app.getContactHelper().chooseContactForEdit(0); 
	app.getContactHelper().deleteContact();
	app.navigateTo().returnToHomePage();
	  
    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
	
    
    //compare states
    oldList.remove(0);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
} 
}
