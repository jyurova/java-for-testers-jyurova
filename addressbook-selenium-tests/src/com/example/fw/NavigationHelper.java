package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupsPage() {
	    click(By.linkText("group page"));
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
		}

	public void returnToHP() {
		click(By.linkText("home page"));
		}

}
