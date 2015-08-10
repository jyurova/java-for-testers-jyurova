package com.example.tests;

import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

@Test
public void deleteContact() {
	app.navigateTo().mainPage();
	app.getContactHelper().chooseContactForEdit(1); 
	app.getContactHelper().deleteContact();
	app.navigateTo().returnToHomePage();
	  } 
}
