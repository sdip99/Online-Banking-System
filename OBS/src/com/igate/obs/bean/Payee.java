package com.igate.obs.bean;

public class Payee {
	private long account_id;
	private long payee_acc_no;
	private String payee_name;
	private String payee_ifsc;
	public Payee() {
		
	}
	public Payee(long payee_acc_no, String payee_name, String payee_ifsc) {
		super();
		this.payee_acc_no = payee_acc_no;
		this.payee_name = payee_name;
		this.payee_ifsc = payee_ifsc;
	}
	public long getPayee_acc_no() {
		return payee_acc_no;
	}
	public void setPayee_acc_no(long payee_acc_no) {
		this.payee_acc_no = payee_acc_no;
	}
	public String getPayee_name() {
		return payee_name;
	}
	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}
	public String getPayee_ifsc() {
		return payee_ifsc;
	}
	public void setPayee_ifsc(String payee_ifsc) {
		this.payee_ifsc = payee_ifsc;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		return "Payee [payee_acc_no=" + payee_acc_no + ", payee_name="
				+ payee_name + ", payee_ifsc=" + payee_ifsc + "]";
	}
	

}
