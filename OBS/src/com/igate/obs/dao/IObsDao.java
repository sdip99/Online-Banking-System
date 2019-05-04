package com.igate.obs.dao;

import java.time.LocalDate;
import java.util.List;

import com.igate.obs.bean.Account;
import com.igate.obs.bean.Customer;
import com.igate.obs.bean.FundTransfer;
import com.igate.obs.bean.Login;
import com.igate.obs.bean.Payee;
import com.igate.obs.bean.ServiceTracker;
import com.igate.obs.bean.Transaction;
import com.igate.obs.exception.ObsException;

public interface IObsDao {
	
	public List<Transaction> getTransactionDetails(long accountId) throws ObsException;
	public List<Transaction> getDetailedTransactions(LocalDate fromDate,LocalDate toDate, long accountId) throws ObsException;
	public Login validateUser(String username,String password)throws ObsException;
	public String addUser(Login log) throws ObsException;
	public List<Transaction> getAllTransactions() throws ObsException;
	public Account getUserDetails(long accountId) throws ObsException;
	public int showService(long accountId) throws ObsException;
	boolean checkPayeeInBank(long paccId) throws ObsException;
	int insertPayee(Payee p) throws ObsException;
	public List<Payee> getAllPayee(long accountId) throws ObsException;
	public Payee getPayeeById(long pid, long accountId) throws ObsException;
	public int updateBalance(int amount, long accountId) throws ObsException;
	public int updateBalanceInPayee(long pid, int amount) throws ObsException;
	public ServiceTracker displayService(int service_id,Long account_id) throws ObsException;
	public int setPassword(String password, long accountId) throws ObsException;
	public boolean updateDetails(Account account) throws ObsException;
	public int saveCustomerData(Customer customer) throws ObsException;
	public void insertFundTransfer(FundTransfer ft) throws ObsException;
	public List<FundTransfer> getAllTransactionsById(long accountId) throws ObsException;
	public List<ServiceTracker> getAllTrackService(long accountId) throws ObsException;
	public void addTransactions(String string, String string2, int amount,
			long accountId);
	
	


}
