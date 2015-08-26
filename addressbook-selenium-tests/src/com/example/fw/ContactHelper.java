package com.example.fw;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper  extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false; 

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	//CACHE
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
		}
	
	private void rebuildCache() {
		SortedListOf<ContactData> cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			contact.title = title.substring("Select (".length(), title.length() - ")".length());
			cachedContacts.add(contact);
	}
	}

	public ContactHelper createContact(ContactData contact, boolean fotmType) {
		manager.navigateTo().mainPage();
    	initContactCreation();
    	fillContactForm(contact, CREATION);
    	submit();
    	returnToHomePage();
    	rebuildCache();
    	return this;
		
	}

	public ContactHelper modifyContact(int index, ContactData contact, boolean fotmType) {
		manager.navigateTo().mainPage();
		chooseContactForEdit(index);
		fillContactForm(contact, MODIFICATION);
		updateContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper removeContact(int index) {
		manager.navigateTo().mainPage();
		chooseContactForEdit(index);
		deleteContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper chooseContactForEdit(int index) {
		click(By.xpath("//img[@title='Details'][" + (index+1) + "]"));
		click(By.xpath("(//input[@name='modifiy'])"));
		return this;
	}
	
	public ContactHelper deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper submit() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean fotmType) {
		type(By.name("firstname"), contact.getFirstname());
	    type(By.name("lastname"), contact.getLastname());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHome());
	    type(By.name("mobile"), contact.getMobile());
	    type(By.name("work"), contact.getWork());
	    type(By.name("email"), contact.getEmail());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getByear());
	    type(By.name("byear"), contact.getByear());
	    if (fotmType == CREATION){
	    	//selectByText(By.name("new_group"), "group 1");
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() !=0){
	    		throw new Error ("Group selector exists in contact modification form");
	    	}
	    }		 
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhone2());
	    return this;
	}
	
	public ContactHelper updateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		return this;
		}
		
	public int random(List<ContactData> oldList) {
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		return index;
	}
					
	public void returnToHomePage() {
		click(By.linkText("home page"));
	} 
}