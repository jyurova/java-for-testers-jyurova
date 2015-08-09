package com.example.tests;

import org.testng.annotations.Test;
import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
		
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    
    //save old state
    GroupHelper groupHelper = app.getGroupHelper();
    SortedListOf<GroupData> oldList = groupHelper.getGroups();
    
    //actions
	app.getGroupHelper().createGroup(group);

    
    //save new state
	SortedListOf<GroupData> newList = groupHelper.getGroups();
    
    //compare states 
    groupHelper.compareStates(group, oldList, newList);
  }
}