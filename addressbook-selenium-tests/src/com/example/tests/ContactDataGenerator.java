package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually:" + file);
		}
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCSVFile(contacts, file);
		} else if ("xml".equals(format)){
			saveContactsToXMLFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream(); 
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	private static void saveContactsToCSVFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," + contact.getHome() + "," + contact.getMobile() + "," + contact.getWork() + "," + contact.getEmail() + "," + contact.getEmail2() + "," + contact.getPhone2() + "," + contact.getAddress2() + "\n");
		}
		writer.close();			
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
				.withFirstname (generateRandomString()) 
				.withLastname  (generateRandomString())
				.withAddress  (generateRandomString())
				.withHome  (generateRandomString())
				.withMobile  (generateRandomString())
				.withWork  (generateRandomString())
				.withEmail  (generateRandomString())
				.withEmail2  (generateRandomString())
				.withPhone2  (generateRandomString())
				.withAddress2  (generateRandomString());
			contact.title = contact.getFirstname() + " " + contact.getLastname();
			list.add(contact);
		}
		return list;
	}
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0 ) {
			return " ";
		}else{
			return "test" + rnd.nextInt();
		}
	}
}