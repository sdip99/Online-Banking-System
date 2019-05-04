package com.igate.obs.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.igate.obs.bean.Account;
import com.igate.obs.bean.Customer;
import com.igate.obs.bean.FundTransfer;
import com.igate.obs.bean.Login;
import com.igate.obs.bean.Payee;
import com.igate.obs.bean.ServiceTracker;
import com.igate.obs.bean.Transaction;
import com.igate.obs.logger.BankingLogger;

@Repository("obsdao")
public class ObsDao implements IObsDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	Logger logger = BankingLogger.getLogger();
	
/******************************getUser Details************************************************/
	@Override
	public Account getUserDetails(long accountId) {
		String sql="select * from obs_bank where account_id=?";
		Object param[] ={accountId};
		
		return jdbcTemplate.queryForObject(sql, param , new RowMapper<Account>(){

			@Override
			public Account mapRow(ResultSet result, int count) throws SQLException {
				Account account = new Account();
				account.setAccountId(result.getLong(1));
				account.setAccountType(result.getString(2));
				account.setBalance(result.getDouble(3));
				account.setOpenDate(result.getDate(4).toLocalDate());
				account.setDebitNum(result.getLong(5));
				account.setDebit_cvv(result.getInt(6));
				account.setIfsc(result.getString(7));
				account.setCust_name(result.getString(8));
				account.setPhone_no(result.getString(9));
				account.setEmail(result.getString(13));
				account.setAddress(result.getString(12));
				account.setPanNo(result.getString(11));
				account.setCustDob(result.getDate(10).toLocalDate());
				logger.info(account);
				return account;
			}
		
		});
	}
	
	
/*********************************Registration***********************************************/
	//inserting into the database for new customer
	@Override
	public String addUser(Login login) {
		String insertQuery = "INSERT INTO obs_login values(?,?,?,?,?)";
		String userId = UUID.randomUUID().toString().substring(0,6);
		System.out.println(userId);


		Object param[]={userId,
						login.getLoginPassword(),
						login.getTransaction_pwd(),
						login.getUserType(),login.getAccountId()};
		int rowCount=jdbcTemplate.update(insertQuery,param);

		if(rowCount>0)
		{	
			logger.info("Login details of user are inserted into database with userId : "+userId);

			return userId;
			
		}else{
			logger.info("Login details are not inserted...");
			return null;
		}

	}

/************************************Login**************************************************/	
	// to validate the customer
	@Override
	public Login validateUser(String username,String password) {
		String sql ="SELECT * FROM obs_login where user_id=? and login_password=?";
		Object param[]= {username,password};
		Login login = null;
		try{
		login = jdbcTemplate.queryForObject(sql, param, new RowMapper<Login>() {

			@Override
			public Login mapRow(ResultSet resultSet, int count) throws SQLException {
				Login login = new Login();
				login.setAccountId(resultSet.getLong(5));
				login.setUserId(resultSet.getString(1));
				login.setLoginPassword(resultSet.getString(2));
				login.setTransaction_pwd(resultSet.getString(3));
				login.setUserType(resultSet.getString(4));
				logger.info("login details of user : "+login);
				return login;
				
			} 
		});
		}catch(EmptyResultDataAccessException e){
			
		}
		
		return login;
	}
	
/*************************************Ministatement************************************************/
	//List of ministatement transactions 
	@Override
	public List<Transaction> getTransactionDetails(long accountId) {
		String sql = "select * from transactions where account_id=? and rownum<=10 order by dateoftransaction desc";
		Object param[] = {accountId};

		return jdbcTemplate.query(sql, param, new RowMapper<Transaction>(){

			@Override
			public Transaction mapRow(ResultSet resultSet, int count) throws SQLException {
				Transaction transaction = new Transaction();
				transaction.setTransactionId(resultSet.getInt(1));
				transaction.setTransactionDescription(resultSet.getString(2));
				transaction.setTransactionDate((resultSet.getDate(3)).toLocalDate());
				transaction.setTransactionType(resultSet.getString(4));
				transaction.setTransactionAmount(resultSet.getDouble(5));
				transaction.setAccountId(resultSet.getInt(1));
				logger.info("Mini statement transaction details : "+transaction);
				return transaction;
			}

		});

	}
	
/************************************Detailed Statement********************************************/
	//List of detailed statement transactions
	@Override
	public List<Transaction> getDetailedTransactions(LocalDate fromDate,
			LocalDate toDate, long accountId) {
		String sql="select * from transactions where account_id=? and dateoftransaction between ? and ?";
		Object param[] = {accountId,Date.valueOf(fromDate),Date.valueOf(toDate)};
		return jdbcTemplate.query(sql, param, new RowMapper<Transaction>(){

			@Override
			public Transaction mapRow(ResultSet resultSet, int count) throws SQLException {
				Transaction transaction = new Transaction();
				transaction.setTransactionId(resultSet.getInt(1));
				transaction.setTransactionDescription(resultSet.getString(2));
				transaction.setTransactionDate((resultSet.getDate(3)).toLocalDate());
				transaction.setTransactionType(resultSet.getString(4));
				transaction.setTransactionAmount(resultSet.getDouble(5));
				transaction.setAccountId(resultSet.getInt(1));
				logger.info("Detailed statement transaction details : "+transaction);
				return transaction;
			}

		});

	}
	
/*****************************view All Transactions*****************************************************/
	//List of All Transactions 
	@Override
	public List<Transaction> getAllTransactions() {
		String sql="select * from transactions where DATEOFTRANSACTION=sysdate";
		return jdbcTemplate.query(sql, new RowMapper<Transaction>(){
			@Override
			public Transaction mapRow(ResultSet rs, int count) throws SQLException {

				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getInt(1));
				transaction.setTransactionDescription(rs.getString(2));
				transaction.setTransactionDate(rs.getDate(3).toLocalDate());
				transaction.setTransactionType(rs.getString(4));
				transaction.setTransactionAmount(rs.getDouble(5));
				transaction.setAccountId(rs.getInt(6));
				logger.info("All the transactions performed today : "+transaction);
				return transaction;
			}
		});
	}
	
	
/*************************ChequeBookRequest********************************************/	
	//Getting the trackerId
	public int gettrackerid(){
		String sql = "select seq_tracker.nextval from dual";
		int nextid = jdbcTemplate.queryForObject(sql, Integer.class);
		return nextid;
	}
	
	//Inserting the values of service Request.
	@Override
	public int showService(long accountId) {
		String insertQuery = "insert into Service_Tracker values(?,?,?,sysdate,sysdate+5,?)";
		int serviceTrackerId = gettrackerid();
		ServiceTracker serviceTracker = new ServiceTracker();
		Object param[] = {serviceTrackerId,
						  serviceTracker.getServiceDescription(),
						  accountId,
						  serviceTracker.getServiceStatus()};
		int rowCount=jdbcTemplate.update(insertQuery,param);

		if(rowCount>0)
		{ 
			logger.info("Request accepted with serviceId : "+serviceTrackerId);
			return serviceTrackerId;
		}else{
			return 0;
		}
		
	}
	
	
/*******************************Track Service request***************************************/
	//List of serviceTracker.
	@Override
	public ServiceTracker displayService(int service_id,Long account_id) {
		String sql = "select * from service_tracker where service_id=? and account_id=?";
		Object param[] = {service_id,account_id};
		return jdbcTemplate.queryForObject(sql, param, new RowMapper<ServiceTracker>() {

			@Override
			public ServiceTracker mapRow(ResultSet res, int count) throws SQLException {
				ServiceTracker servetrack = new ServiceTracker(res.getInt(1),
															   res.getString(2),
															   res.getLong(3),
															   res.getDate(4).toLocalDate(),
															   res.getDate(5).toLocalDate(),
															   res.getString(6));
				
				
				logger.info("Service Tracker List by serviceId : "+servetrack);
				return servetrack;
			}
		});
	}
	
	@Override
	public List<ServiceTracker> getAllTrackService(long accountId) {
		
		String sql = "select * from service_tracker where account_id=?";
		Object param[] = {accountId};
		return jdbcTemplate.query(sql, param, new RowMapper<ServiceTracker>() {

			@Override
			public ServiceTracker mapRow(ResultSet res, int count) throws SQLException {
				ServiceTracker servetrack = new ServiceTracker(res.getInt(1),
															   res.getString(2),
															   res.getLong(3),
															   res.getDate(4).toLocalDate(),
															   res.getDate(5).toLocalDate(),
															   res.getString(6));
				logger.info("Sevrices list by accountId : "+servetrack);
				return servetrack;
			}
		});
	}
/****************************Fund Transfer*****************************************************/
	@Override
	public int insertPayee(Payee p) {
		String insertPayee = "INSERT INTO payee_table VALUES(?,?,?,?)";
		Object param[] = {p.getPayee_acc_no(),p.getPayee_name(),p.getPayee_ifsc(),p.getAccount_id()};
		int rowCount = jdbcTemplate.update(insertPayee, param);
		logger.info("Values of payee added to database");
		return rowCount;
	}
	
	

	@Override
	public boolean checkPayeeInBank(long paccId) {
		
		String sql="select * from obs_bank where account_id=?";
		Object param[] ={paccId};
		Account accid = jdbcTemplate.queryForObject(sql, param , new RowMapper<Account>(){

			@Override
			public Account mapRow(ResultSet result, int count) throws SQLException {
				Account account = new Account();
				account.setAccountId(result.getLong(1));
					return account;
			}
			
		});
		if(accid.getAccountId()==0){
			logger.info("Payee have no account in bank");
			return false;
		}else{
			logger.info("Payee is found with accountId : "+accid.getAccountId());
			return true;
		}
		
	}

	@Override
	public List<Payee> getAllPayee(long accountId) {
		String sql="select * from payee_table where account_id=?";
		Object parm[]={accountId};
		return jdbcTemplate.query(sql, parm, new RowMapper<Payee>(){
			@Override
			public Payee mapRow(ResultSet result, int count) throws SQLException {
				Payee payee = new Payee();
				payee.setAccount_id(result.getLong(4));
				payee.setPayee_acc_no(result.getLong(1));
				payee.setPayee_name(result.getString(2));
				payee.setPayee_ifsc(result.getString(3));
				logger.info("Payee List : "+payee);
				return payee;
			}
		});
	}

	@Override
	public Payee getPayeeById(long pid, long accountId) {
		
		String sql="select * from payee_table where payee_account_id=? and account_id=?";
		Object param[] ={pid,accountId};
		return jdbcTemplate.queryForObject(sql, param, new RowMapper<Payee>(){

			@Override
			public Payee mapRow(ResultSet rs, int count) throws SQLException {
				Payee payee = new Payee();
				payee.setAccount_id(rs.getLong(4));
				payee.setPayee_acc_no(rs.getLong(1));
				payee.setPayee_name(rs.getString(2));
				payee.setPayee_ifsc(rs.getString(3));
				logger.info("Payee selected : "+payee);
				return payee;
				
			}
			
			
		});
	}

	@Override
	public int updateBalance(int amount, long accountId) {

		String sql = "Update obs_bank set account_balance=account_balance-? where account_id=?";
		Object param[] = {amount,accountId};
		int rowcount = jdbcTemplate.update(sql, param);
		logger.info("User account balance is updated successfully...");
		return rowcount;


	}

	@Override
	public int updateBalanceInPayee(long pid, int amount) {
		String sql = "Update obs_bank set account_balance=account_balance+? where account_id=?";
		Object param[] = {amount , pid};
		int rowcount = jdbcTemplate.update(sql, param);
		logger.info("Payee account balance is updated successfully....");
		return rowcount;

	}
	
	@Override
	public void insertFundTransfer(FundTransfer ft) {
		
		String insertQuery="Insert into Fund_transfer values(seq_ft.NEXTVAL,?,?,sysdate,?)";
		Object param[] = {ft.getSourceId(),ft.getDestId(),ft.getTamount()};
		logger.info("FundTransfer details are updated....");
		jdbcTemplate.update(insertQuery, param);
		
	}


	@Override
	public List<FundTransfer> getAllTransactionsById(long accountId) {
		
		String fetchAll="Select * from Fund_transfer where account_id=? order by date_of_transfer desc";
		Object param[]={accountId};
		return jdbcTemplate.query(fetchAll, param, new RowMapper<FundTransfer>() {

			@Override
			public FundTransfer mapRow(ResultSet rs, int count)
					throws SQLException {
				FundTransfer ft = new FundTransfer();
				ft.setfId(rs.getInt(1));
				ft.setSourceId(rs.getLong(2));
				ft.setDestId(rs.getLong(3));
				ft.setDot(rs.getDate(4).toLocalDate());
				ft.setTamount(rs.getDouble(5));
				logger.info("Details of fund transfer : "+ft);
				return ft;
			}
		});
	}
	
	@Override
	public void addTransactions(String string, String string2, int amount,
			long accountId) {
		String sql = "Insert into transactions values(seq_transactions.nextval,?,sysdate,?,?,?)";
		Object param[] = {string,string2,accountId,amount};
		jdbcTemplate.update(sql, param);
		
	}


/********************setPassword***********************************************/
	//updating the password by using the accountId.
	@Override
	public int setPassword(String password, long accountId) {
		String sql = "update obs_login set login_password=? where account_id=?";
		Object param[] = {password,accountId};
		int rowCount = jdbcTemplate.update(sql, param);
		logger.info("Password updated successfully...");
		return rowCount;
	}
/******************************update Details**********************************************/	
	//updating the details of user account.
	@Override
	public boolean updateDetails(Account account){
		String sql = "update obs_bank set CUST_PNO=?,CUST_ADD=? where account_id=?";
		Object param[] ={account.getPhone_no(),account.getAddress(),account.getAccountId()};
		int rowCount = jdbcTemplate.update(sql, param);
		if(rowCount>0){
			logger.info("User details updated successfully.....");
			return true;
		}else{
			logger.info("Details not updated successfully....");
			return false;
		}
		
	}
/************************create new account*************************************************/	
	//Getting the customerId
	private int getNextCustomerId() {
		String getUserId = "SELECT seq_customer.nextVal from dual";
		int nextId = jdbcTemplate.queryForObject(getUserId, Integer.class);
		
		return nextId;
	}
	
	//Inserting the customer values in database.
	@Override
	public int saveCustomerData(Customer customer) {
		
		String insertQuery = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?)";
		int customerId = getNextCustomerId();
		Object param[]={customerId, customer.getCustomer_name(), customer.getPhone_no(), customer.getEmail(),
						customer.getAddress1(), customer.getAddress2(), customer.getPancard(), Date.valueOf(customer.getDob())};
		int rowCount = jdbcTemplate.update(insertQuery, param);
		
		if(rowCount>0){
			logger.info("New account created with customerId : "+customerId);
			return customerId;
		}else{
			logger.info("Account is not created due to some reason..");
			return 0;
		}
	}


	


	



	}
	
	
	
	
	
	
	
	
	

