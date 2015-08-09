package com.example.fw;

import static org.junit.Assert.assertThat;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}
	
	private void rebuildCache() {
		SortedListOf<GroupData> cachedGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() -")".length());
			cachedGroups.add(new GroupData().withName(name));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroup(int index) {
	selectGroupByIndex(index);
	submitGroupDeletion();
	returnToGroupsPage();
	rebuildCache();
	return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}
	//----------------------------
	
	public void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}
	
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
	selectGroupByIndex(index);
	click(By.name("edit"));	
	return this;
	}

	public GroupHelper submitGroupModification() {
	click(By.name("update"));
	cachedGroups = null;
	return this;
		
	}
		
	public int random(SortedListOf<GroupData> oldList) {
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		return index;
	}
	
	public GroupHelper compareStatesModification(GroupData group, SortedListOf<GroupData> oldList, int index,
		SortedListOf<GroupData> newList) {
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
		return this;
}
	public GroupHelper compareStatesRemoval(SortedListOf<GroupData> oldList, int index, SortedListOf<GroupData> newList) {
		assertThat(newList, equalTo(oldList.without(index)));
		return this;
}
	
	public GroupHelper compareStates(GroupData group, SortedListOf<GroupData> oldList, SortedListOf<GroupData> newList) {
		assertThat(newList, equalTo(oldList.withAdded(group)));
	    return this;
	}
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("groups"));
		return this;
	}
}
