package com.example.fw;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewGroupCreation() {
		    click(By.name("new"));
		}

	public void fillGroupForm(GroupData group) {
		    type(By.name("group_name"), group.name);
		    type(By.name("group_header"), group.header);
		    type(By.name("group_footer"), group.footer);
		}

	public void submitGroupCreation() {
		click(By.name("submit"));
		}

	public void goToGroupsPage() {
		click(By.linkText("groups"));
		}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) +"]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));		
	}

	public void submitGroupModification() {
		click(By.name("update"));		
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			 group.name = title.substring("Select (".length(),title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}
	
	public void compareStatesRemoval(List<GroupData> oldList, int index,
		List<GroupData> newList) {
		oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	public void compareStatesModification(GroupData group,
			List<GroupData> oldList, int index, List<GroupData> newList) {
		oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	public void compareStatesCreation(GroupData group, List<GroupData> oldList,
			List<GroupData> newList) {
		oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	public int random(List<GroupData> oldList) {
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		return index;
}
}
