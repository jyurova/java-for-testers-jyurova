package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{

	@Test
	public void deleteSomeGroup() {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().goToGroupsPage();
	
	//save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    int index = app.getGroupHelper().random(oldList);
    
    //actions
	app.getGroupHelper().deleteGroup(index);
	app.getNavigationHelper().returnToGroupsPage();	
	
	//save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states 
	app.getGroupHelper().compareStatesRemoval(oldList, index, newList);
  }

	}