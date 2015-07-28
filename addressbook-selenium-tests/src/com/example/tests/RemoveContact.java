package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

@Test
public void deleteContact() {
	app.getNavigationHelper().openMainPage();
	
    //save old state
	//List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//Random rnd = new Random();
	//int index = rnd.nextInt(oldList.size()-1);

	//actions
	//app.getContactHelper().selectContactForEdit(index);
	//app.getContactHelper().deleteContact();
	//app.getNavigationHelper().returnToHomePage();
	 //save new state
 
	   //save new state
	//List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare states
	//assertEquals(newList.size(), oldList.size()+1); 
		
	//oldList.remove(index);
	//Collections.sort(oldList);
	//assertEquals(newList, oldList);
	  
	  } 
}
