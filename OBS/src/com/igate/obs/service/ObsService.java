package com.igate.obs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.igate.obs.bean.Account;
import com.igate.obs.bean.Customer;
import com.igate.obs.bean.FundTransfer;
import com.igate.obs.bean.Login;
import com.igate.obs.bean.Payee;
import com.igate.obs.bean.ServiceTracker;
import com.igate.obs.bean.Transaction;
import com.igate.obs.dao.IObsDao;
import com.igate.obs.exception.ObsException;

@Service("obsservice")
public class ObsService implements IObsService{

	
	@Autowired
	@Qualifier("obsdao")
	IObsDao dao;

	@Override
	public Login validateUser(String username,String password) throws ObsException {
		return dao.validateUser(username,password);
	}
	@Override
	public List<Transaction> getAllTransactions() throws ObsException{
		return dao.getAllTransactions();
	}
	@Override
	public Account getUserDetails(long accountId) throws ObsException{
		return dao.getUserDetails(accountId);
	}
	@Override
	public List<Transaction> miniStatement(long accountId) throws ObsException{
		
		return dao.getTransactionDetails(accountId);
	}

	@Override
	public boolean checkPayeeInBank(long paccId) throws ObsException {
		
		return dao.checkPayeeInBank(paccId);
		
	}
	@Override
	public int insertPayee(Payee p) throws ObsException {
		
		return dao.insertPayee(p);
	}
	@Override
	public List<Payee> getAllPayee(long accountId) throws ObsException {
		// TODO Auto-generated method stub
		return dao.getAllPayee(accountId);
	}
	@Override
	public Payee getPayeeById(long pid, long accountId) throws ObsException{
		// TODO Auto-generated method stub
		return dao.getPayeeById(pid,accountId);
	}
	@Override
	public int updateBalance(int amount, long accountId) throws ObsException{
		// TODO Auto-generated method stub
		return dao.updateBalance(amount,accountId);
	}
	@Override
	public int updateBalanceInPayee(long pid, int amount) throws ObsException{
		// TODO Auto-generated method stub
		return dao.updateBalanceInPayee(pid,amount);
	}
	@Override
	public List<Transaction> detailedStatement(LocalDate from, LocalDate to,long accountId) throws ObsException{
		// TODO Auto-generated method stub
		return dao.getDetailedTransactions(from, to, accountId);
	}
	@Override
	public ServiceTracker displayService(int service_id,Long account_id) throws ObsException{
		return dao.displayService(service_id,account_id);
	}
	@Override
	public int showService(long accountId) throws ObsException{
		// TODO Auto-generated method stub
		return dao.showService(accountId);
	}
	@Override
	public int setPassword(String password, long accountId) throws ObsException{
		
		return dao.setPassword(password,accountId);
	}
	@Override
	public void updatePassword(String password, long accountId) throws ObsException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean updateDetails(Account account) throws ObsException{
		return dao.updateDetails(account);
	}
	@Override
	public String addUserLoginDetails(Login login) throws ObsException{
		return dao.addUser(login);
	}
	@Override
	public int saveCustomerData(Customer customer) throws ObsException{
		
		return dao.saveCustomerData(customer);
	}
	@Override
	public void insertFundTransfer(FundTransfer ft) throws ObsException{
		
		dao.insertFundTransfer(ft);
		
	}
	@Override
	public List<FundTransfer> getAllTransactionsById(long accountId) throws ObsException{
		// TODO Auto-generated method stub
		return dao.getAllTransactionsById(accountId);
	}
	@Override
	public List<ServiceTracker> getAllTrackService(long accountId) throws ObsException{
		// TODO Auto-generated method stub
		return dao.getAllTrackService(accountId);
	}
	@Override
	public void addTransactions(String string, String string2, int amount,
			long accountId) {
		dao.addTransactions(string,string2,amount,accountId);
		
	}

}
