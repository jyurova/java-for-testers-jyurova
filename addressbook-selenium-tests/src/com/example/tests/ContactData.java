package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public String yearBD;
	public String address2;
	public String phone2;
	public String bday;
	public String bmonth;

	public ContactData(String firstname, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email, String email2, String yearBD, String address2,
			String phone2, String bday, String bmonth) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.email2 = email2;
		this.yearBD = yearBD;
		this.address2 = address2;
		this.phone2 = phone2;
		this.bday = bday;
		this.bmonth = bmonth;
	}
	
	public ContactData() {
	}
}