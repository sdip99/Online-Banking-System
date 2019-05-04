package com.igate.obs.bean;

public class Login {


	private long accountId;
	private String userId;
	private String loginPassword;
	private String transaction_pwd;
	private String userType;
	
	public Login() {

	}

	public Login(long accountId, String userId, String loginPassword,
				 String transaction_pwd, String userType) {

		this.accountId = accountId;
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.transaction_pwd = transaction_pwd;
		this.userType = userType;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getTransaction_pwd() {
		return transaction_pwd;
	}

	public void setTransaction_pwd(String transaction_pwd) {
		this.transaction_pwd = transaction_pwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Login [accountId=" + accountId + ", userId=" + userId
				+ ", loginPassword=" + loginPassword + ", transaction_pwd="
				+ transaction_pwd + ", userType=" + userType + "]";
	}
}
