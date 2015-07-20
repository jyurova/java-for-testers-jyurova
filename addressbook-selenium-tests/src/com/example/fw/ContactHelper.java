package com.example.fw;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
			type(By.name("firstname"), contact.firstname);
			type(By.name("lastname"), contact.lastName);
			type(By.name("address"), contact.address);
			type(By.name("home"), contact.homePhone);
			type(By.name("mobile"), contact.mobilePhone);
			type(By.name("work"), contact.workPhone);
			type(By.name("email"), contact.email);
			type(By.name("email2"), contact.email2);
		    selectByText(By.name("bday"), contact.bday);
		    selectByText(By.name("bmonth"), contact.bmonth);
		    type(By.name("byear"), contact.yearBD);
		    //selectByText(By.name("new_group"), "Eddie_would_go");
		    type(By.name("address2"), contact.address2);
		    type(By.name("phone2"), contact.phone2);

		}

	public void submit() {
			click(By.name("submit"));
		}
	
	public void selectContactForEdit(int index) {
		click(By.xpath("//img[@title='Edit'][" + (index+1) + "]"));
	}
	
	
	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}
	public void submitContactModification() {
		click(By.xpath("//input[11]"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			 contact.firstname = title.substring("Select (".length(),title.length() - ")".length());
			contacts.add(contact);
		}
		return contacts;
	}
	
	public void compareStatesRemoval(List<ContactData> oldList, int index,
		List<ContactData> newList) {
		oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	public void compareStatesModification(ContactData contact,
			List<ContactData> oldList, int index, List<ContactData> newList) {
		oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	public void compareStatesCreation(ContactData contact, List<ContactData> oldList,
			List<ContactData> newList) {
		oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	public int random(List<ContactData> oldList) {
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		return index;
}
}
