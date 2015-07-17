package com.example.tests;

import java.util.List;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	

	@Test(dataProvider= "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().goToGroupsPage();
		
		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		int index = app.getGroupHelper().random(oldList);

		//actions
		app.getGroupHelper().initGroupModification(index);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getNavigationHelper().returnToGroupsPage();
	    
	    //save new states
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	 // compare states 
	    app.getGroupHelper().compareStatesModification(group, oldList, index, newList);
	 
	}


	}