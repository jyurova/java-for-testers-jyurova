package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	public void openMainPage() {
		    driver.get(manager.baseUrl + "/addressbookv4.1.4/");
		}


}
