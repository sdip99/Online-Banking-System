package com.igate.obs.bean;

import java.time.LocalDate;

public class Transaction {
	private int transactionId;
	private String transactionDescription;
	private LocalDate transactionDate;
	private String transactionType;
	private Double transactionAmount;
	private int accountId;
	public Transaction() {

	}
	public Transaction(int transactionId,String transactionDescription,
						LocalDate transactionDate, String transactionType,
						Double transactionAmount, int accountId) {
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.accountId = accountId;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "TransactionBean \n\t transactionDescription="
				+ transactionDescription + "\n\t transactionDate="
				+ transactionDate + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", accountId="
				+ accountId + "]";
	}

}
