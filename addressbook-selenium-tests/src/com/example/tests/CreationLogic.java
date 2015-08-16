package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class CreationLogic extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigateTo().mainPage();
	//save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	//actions
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "test name 1";
    group.header = "test name 1";
    group.footer = "address 1";
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submit();
    app.navigateTo().returnToHomePage();
    
    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
	
    
    //compare states
    assertEquals(newList.size(), oldList.size() +1);
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}