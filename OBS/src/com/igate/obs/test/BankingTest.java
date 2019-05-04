package com.igate.obs.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igate.obs.bean.Account;
import com.igate.obs.bean.FundTransfer;
import com.igate.obs.bean.Login;
import com.igate.obs.bean.Payee;
import com.igate.obs.bean.Transaction;
import com.igate.obs.exception.ObsException;
import com.igate.obs.service.IObsService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("springds-servlet.xml")
public class BankingTest {
	@Autowired
	@Qualifier("obsservice")
	IObsService service;
	
	Account account = null;
	Login login = null;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before class executed...");
	}
	@Test
	public void login() {
		try {
			login = service.validateUser("anjali","anjali");
		} catch (ObsException e) {
			
		}
	}
	
	@Test
	public void setPassword() {
		int count = 0;
		try {
			count = service.setPassword("pranavi",1013);
			
		} catch (ObsException e) {
			
		}
	}
	
	@Test
	public void miniStatement() {
		List<Transaction> miniList = null;
		try {
			miniList = service.miniStatement(1011);
			
		} catch (ObsException e) {
			
		}
	}
	
	@Test
	public void showAllPayee() {
		List<Payee> pList = null;
		try {
			pList = service.getAllPayee(1011);
			
		} catch (ObsException e) {
			
		}
	}
	
	@Test
	public void viewFundTransfers() {
	List<FundTransfer> fList = null;
	try {
		fList = service.getAllTransactionsById(1011);
		
	} catch (ObsException e) {
		
	}
	}
	
	
	@Test
	public void viewAlltransactions() {
		List<Transaction> allTransactionData = null;
	try {
		allTransactionData = service.getAllTransactions();
		
	} catch (ObsException e) {
		
	}
	}
	 
			
	
}
