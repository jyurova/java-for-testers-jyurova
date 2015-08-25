package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class RemoveContact extends TestBase {

@Test
public void deleteContact() {

	//save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	
	int index = app.getContactHelper().random(oldList);
	
	//actions
	app.getContactHelper().removeContact(index);
	  
    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
    //compare states
	assertThat(newList, equalTo(oldList.without(index)));  
} 
}