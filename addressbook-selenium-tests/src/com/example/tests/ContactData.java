package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String byear;
	public String address2;
	public String phone2;
	public String bday;
	public String bmonth;
	public String title;

	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work,
			String email, String email2, String byear, String address2,
			String phone2, String bday, String bmonth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
		//this.bday = bday;
		//this.bmonth = bmonth;
	}
	
	public ContactData() {
	}

	public ContactData(String titleToSet) {
		// !!!!!!!!!!
		this.title = titleToSet;
	}

	@Override
	public String toString() {
		return "ContactData [title=" + title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.title.toLowerCase().compareTo(other.title.toLowerCase());
	}
	
	
}