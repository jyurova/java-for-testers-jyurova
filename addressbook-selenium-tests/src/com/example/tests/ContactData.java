package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String byear;
	private String address2;
	private String phone2;
	private String bday;
	private String bmonth;
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
	
	public ContactData withFirstname (String firstname){
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getByear() {
		return byear;
	} 

	public void setByear(String byear) {
		this.byear = byear;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	}