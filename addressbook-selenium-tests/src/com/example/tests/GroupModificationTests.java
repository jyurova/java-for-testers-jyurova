package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	@Test
	public void modifySomeGroup() {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().goToGroupsPage();
	
	   //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
	app.getGroupHelper().initGroupModification(0);
	GroupData group = new GroupData();
	group.name = "qwwe1";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupModification();
	app.getNavigationHelper().returnToGroupsPage();	
	
	 //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states 
    app.getGroupHelper().compareStatesForEdit(oldList, group, newList);
  }


	}
