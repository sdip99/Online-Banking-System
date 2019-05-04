package com.igate.obs.bean;

import java.time.LocalDate;

public class FundTransfer {
	
	private int fId;
	private long sourceId;
	private long destId;
	private LocalDate dot;
	private double tamount;
	public FundTransfer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FundTransfer [fId=" + fId + ", sourceId=" + sourceId
				+ ", destId=" + destId + ", dot=" + dot + ", tamount="
				+ tamount + "]";
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
	public long getDestId() {
		return destId;
	}
	public void setDestId(long destId) {
		this.destId = destId;
	}
	public LocalDate getDot() {
		return dot;
	}
	public void setDot(LocalDate dot) {
		this.dot = dot;
	}
	public double getTamount() {
		return tamount;
	}
	public void setTamount(double tamount) {
		this.tamount = tamount;
	}
	public FundTransfer(int fId, long sourceId, long destId, LocalDate dot,
			double tamount) {
		super();
		this.fId = fId;
		this.sourceId = sourceId;
		this.destId = destId;
		this.dot = dot;
		this.tamount = tamount;
	}

}
