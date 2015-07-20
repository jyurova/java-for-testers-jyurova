package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

@Test
public void deleteContact() {
	app.getNavigationHelper().openMainPage();
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	int index = app.getContactHelper().random(oldList);
	//actions
	app.getContactHelper().selectContactForEdit(index);
	app.getContactHelper().deleteContact();
	app.getNavigationHelper().returnToHomePage();
	 //save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    //compare states
    app.getContactHelper().compareStatesRemoval(oldList, index, newList);
  }
}
