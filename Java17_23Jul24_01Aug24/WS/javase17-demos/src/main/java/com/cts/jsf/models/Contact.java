package com.cts.jsf.models;

import java.time.LocalDate;
import java.util.Objects;

public class Contact implements Comparable<Contact> {

	private int contactId;
	private String fullName;
	private String mobile;
	private String mailId;
	private LocalDate dateOfBirth;

	public Contact() {
		//left blank
	}
	
	public Contact(int contactId, String fullName, String mobile, String mailId, LocalDate dateOfBirth) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.mailId = mailId;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int compareTo(Contact o) {
		return ((Integer)this.contactId).compareTo(o.contactId);
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", mobile=" + mobile + ", mailId="
				+ mailId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactId, fullName, mailId, mobile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return contactId == other.contactId && Objects.equals(fullName, other.fullName)
				&& Objects.equals(mailId, other.mailId) && Objects.equals(mobile, other.mobile);
	}
	
	

}
