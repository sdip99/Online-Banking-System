package com.igate.obs.bean;

import java.time.LocalDate;

public class ServiceTracker {
	private int service_id;
	private String serviceDescription="Cheque";
	private Long accountId;
	private LocalDate serviceRaisedDate;
	private LocalDate serviceIssueDate;
	private String serviceStatus="Dispatched";
	
	public ServiceTracker() {
		
	}

	public ServiceTracker(int service_id, String serviceDescription,
			Long accountId, LocalDate serviceRaisedDate,
			LocalDate serviceIssueDate, String serviceStatus) {
		
		this.service_id = service_id;
		this.serviceDescription = serviceDescription;
		this.accountId = accountId;
		this.serviceRaisedDate = serviceRaisedDate;
		this.serviceIssueDate = serviceIssueDate;
		this.serviceStatus = serviceStatus;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public LocalDate getServiceRaisedDate() {
		return serviceRaisedDate;
	}

	public void setServiceRaisedDate(LocalDate serviceRaisedDate) {
		this.serviceRaisedDate = serviceRaisedDate;
	}

	public LocalDate getServiceIssueDate() {
		return serviceIssueDate;
	}

	public void setServiceIssueDate(LocalDate serviceIssueDate) {
		this.serviceIssueDate = serviceIssueDate;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	@Override
	public String toString() {
		return "ServiceTracker [service_id=" + service_id
				+ ", serviceDescription=" + serviceDescription + ", accountId="
				+ accountId + ", serviceRaisedDate=" + serviceRaisedDate
				+ ", serviceIssueDate=" + serviceIssueDate + ", serviceStatus="
				+ serviceStatus + "]";
	}
	
	
}

