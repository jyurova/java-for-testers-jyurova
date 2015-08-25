package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
    assertThat(newList, equalTo(oldList.without(index)));
  }
	}