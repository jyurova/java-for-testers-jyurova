package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.MODIFICATION;;

public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void modifySomeContact(ContactData contact) {	
	
	//save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	
	int index = app.getContactHelper().random(oldList);
	
	//actions
	app.getContactHelper().modifyContact(index, contact, MODIFICATION);

    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states (подправить в соответствии с отзывом из предыдущего ДЗ)
	assertThat(newList, equalTo(oldList.without(index).withAdded(contact.title)));
}
} 