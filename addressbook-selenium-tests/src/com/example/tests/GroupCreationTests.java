package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
		
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getGroupHelper().goToGroupsPage();
	//save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	
	//actions
    app.getGroupHelper().initNewGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
    
    //save new states
    List<GroupData> newList = app.getGroupHelper().getGroups();
    // compare states 
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
} 