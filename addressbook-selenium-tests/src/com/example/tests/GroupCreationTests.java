
package com.example.tests;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.goToGroupsPage();
    app.initNewGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";    	
	app.fillGroupForm(this, group);
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.goToGroupsPage();
    app.initNewGroupCreation();
    app.fillGroupForm(this, new GroupData(" ", " ", " "));
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
}
