package com.example.tests;

import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

@Test
public void deleteContact() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().selectContactForEdit(1);
	app.getContactHelper().deleteContact();
	app.getNavigationHelper().returnToHP();
}

}
