package com.example.tests;

public class ContactData implements Comparable<ContactData>{
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
		//this.bday = bday;
		//this.bmonth = bmonth;
	}
	
	public ContactData() {
	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastName=" +lastName+", address="
	+address+",homePhone="+homePhone+", mobilePhone="+mobilePhone+", workPhone=" +workPhone+", email="
				+email+",email2= " +email2+", address2=" +address2+ ", phone2 =" +phone2+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}
	
	
}