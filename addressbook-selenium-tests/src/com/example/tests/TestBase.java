package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }
	
		public static List<Object[]> wrapGroupDataForDataProvider(List<GroupData> groups) {
			List<Object[]> list = new ArrayList<Object[]>();
			for (GroupData group : groups) {
				list.add(new Object[]{group});
			}
		return list;
	}
		
		public static List<Object[]> wrapContactsDataForDataProvider(List<ContactData> contacts) {
			List<Object[]> list = new ArrayList<Object[]>();
			for (ContactData contact : contacts) {
				list.add(new Object[]{contact});
			}
		return list;
	}
}