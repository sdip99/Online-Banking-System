package com.igate.obs.bean;

import java.time.LocalDate;

public class Customer {
	private int customer_id;
	private String customer_name;
	private long phone_no;
	private String email;
	private String address1;
	private String address2;
	private String pancard;
	private LocalDate dob;
	
	public Customer(int customer_id, String customer_name,
			long phone_no, String email, String address1, String address2,
			String pancard, LocalDate dob) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.phone_no = phone_no;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.pancard = pancard;
		this.dob = dob;
	}
	
	public Customer() {
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id
				+ ", customer_name=" + customer_name + ", phone_no=" + phone_no
				+ ", email=" + email + ", address1=" + address1 + ", address2="
				+ address2 + ", pancard=" + pancard + ", dob=" + dob + "]";
	}
}



