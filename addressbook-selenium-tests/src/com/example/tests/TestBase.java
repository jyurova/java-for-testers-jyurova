package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
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
	
	@DataProvider
	
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupDataForDataProvider(generateRandomGroups(5)).iterator();
	}
	
		public static List<Object[]> wrapGroupDataForDataProvider(List<GroupData> groups) {
			List<Object[]> list = new ArrayList<Object[]>();
			for (GroupData group : groups) {
				list.add(new Object[]{group});
			}
		return list;
	}

		@DataProvider
		public Iterator<Object[]> randomValidContactGenerator() {
			List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 5; i++){
				ContactData contact = new ContactData()
					.withFirstname (generateRandomString()) 
					.withLastname  (generateRandomString())
					.withAddress  (generateRandomString())
					.withHome  (generateRandomString())
					.withMobile  (generateRandomString())
					.withWork  (generateRandomString())
					.withEmail  (generateRandomString())
					.withEmail2  (generateRandomString())
					//.withByear  (generateRandomString())
					.withPhone2  (generateRandomString())
					.withAddress2  (generateRandomString())
					//.withBday  (generateRandomString())
					.withBmonth  (generateRandomString()); 
				contact.title = contact.getFirstname() + " " + contact.getLastname();
				list.add(new Object[]{contact});
			}
			return list.iterator();
		}

		public String generateRandomString() {
			Random rnd = new Random();
			if (rnd.nextInt(3) == 0 ) {
				return " ";
			}else{
				return "test" + rnd.nextInt();
			}
		}
}