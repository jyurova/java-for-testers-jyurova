package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{

	@Test
	public void deleteSomeGroup() {
	
	//save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    int index = app.getGroupHelper().random(oldList);
    
    //actions
    app.getGroupHelper().deleteGroup(index);	
	
	//save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states 
	app.getGroupHelper().compareStatesRemoval(oldList, index, newList);
  }
	}