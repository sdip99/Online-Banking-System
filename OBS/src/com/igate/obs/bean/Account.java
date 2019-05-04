package com.igate.obs.bean;

import java.time.LocalDate;

public class Account {
	
		private long accountId;
		private String accountType;
		private double balance;
		private LocalDate openDate;
		private long debitNum;
		private int debit_cvv;
		private String ifsc;
		private String cust_name;
		private String phone_no;
		private String email;
		private String address;
		private String panNo;
		private LocalDate custDob;
		public Account() {
			
		}
		public Account(long accountId, String accountType, double balance,
				LocalDate openDate, long debitNum, int debit_cvv, String ifsc,
				String cust_name, String phone_no, String email, String address,
				String panNo, LocalDate custDob) {
			
			this.accountId = accountId;
			this.accountType = accountType;
			this.balance = balance;
			this.openDate = openDate;
			this.debitNum = debitNum;
			this.debit_cvv = debit_cvv;
			this.ifsc = ifsc;
			this.cust_name = cust_name;
			this.phone_no = phone_no;
			this.email = email;
			this.address = address;
			this.panNo = panNo;
			this.custDob = custDob;
		}
		public long getAccountId() {
			return accountId;
		}
		public void setAccountId(long accountId) {
			this.accountId = accountId;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public LocalDate getOpenDate() {
			return openDate;
		}
		public void setOpenDate(LocalDate openDate) {
			this.openDate = openDate;
		}
		public long getDebitNum() {
			return debitNum;
		}
		public void setDebitNum(long debitNum) {
			this.debitNum = debitNum;
		}
		public int getDebit_cvv() {
			return debit_cvv;
		}
		public void setDebit_cvv(int debit_cvv) {
			this.debit_cvv = debit_cvv;
		}
		public String getIfsc() {
			return ifsc;
		}
		public void setIfsc(String ifsc) {
			this.ifsc = ifsc;
		}
		public String getCust_name() {
			return cust_name;
		}
		public void setCust_name(String cust_name) {
			this.cust_name = cust_name;
		}
		public String getPhone_no() {
			return phone_no;
		}
		public void setPhone_no(String phone_no) {
			this.phone_no = phone_no;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPanNo() {
			return panNo;
		}
		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}
		public LocalDate getCustDob() {
			return custDob;
		}
		public void setCustDob(LocalDate custDob) {
			this.custDob = custDob;
		}
		@Override
		public String toString() {
			return "Account [accountId=" + accountId + ", accountType=" + accountType
					+ ", balance=" + balance + ", openDate=" + openDate
					+ ", debitNum=" + debitNum + ", debit_cvv=" + debit_cvv
					+ ", ifsc=" + ifsc + ", cust_name=" + cust_name + ", phone_no="
					+ phone_no + ", Email=" + email + ", address=" + address
					+ ", panNo=" + panNo + ", custDob=" + custDob + "]";
		}
		

	}


