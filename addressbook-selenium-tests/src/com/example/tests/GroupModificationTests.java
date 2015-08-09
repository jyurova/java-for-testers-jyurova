package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
	
	//save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    int index = app.getGroupHelper().random(oldList);
    
    //actions
	app.getGroupHelper().modifyGroup(index, group);
	
	 //save new state
	SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states 
    app.getGroupHelper().compareStatesModification(group, oldList, index, newList);  
	}
	}