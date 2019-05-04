package com.igate.obs.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.igate.obs.bean.Account;
import com.igate.obs.bean.Customer;
import com.igate.obs.bean.FundTransfer;
import com.igate.obs.bean.Login;
import com.igate.obs.bean.Payee;
import com.igate.obs.bean.ServiceTracker;
import com.igate.obs.bean.Transaction;
import com.igate.obs.exception.ObsException;
import com.igate.obs.service.IObsService;

@Controller
public class ObsController {

	@Autowired
	@Qualifier("obsservice")
	IObsService service;

	@Autowired
	private HttpSession session;

	/*******************************
	 * REGISTER
	 ***************************************/
	/*********************************************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************************************************/
	@RequestMapping(value = "/Register", method = RequestMethod.POST)

	public String RegisterUser(@RequestParam("accountid") Long accountid, @RequestParam("debitnumber") Long debitnumber,
			@RequestParam("cvv") int cvv, Model model) {
		// Validating the account details of user.
		Account account;
		try {
			account = service.getUserDetails(accountid);
			if (account != null) {

				if (debitnumber == account.getDebitNum() && cvv == account.getDebit_cvv()) {
					model.addAttribute("accId", accountid);
					return "LoginInfo";

				} else {

					return "registration";
				}
			}

			else {
				return "registration";
			}

		} catch (ObsException e) {

			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

	@RequestMapping(value = "SaveLoginDetails")
	public String saveLoginDetails(@RequestParam("accountId") long accountId, @RequestParam("pwd") String password,
			@RequestParam("cpwd") String rePassword, @RequestParam("tpwd") String transactionPassword, Model model) {
		// Saving the security details from user.

		try {
			if (password.equals(rePassword)) { // to save password of user, password and retype-password must me same
				Login login = new Login();
				login.setAccountId(accountId);
				login.setLoginPassword(password);
				login.setTransaction_pwd(transactionPassword);
				login.setUserType("user");
				String userId = service.addUserLoginDetails(login);

				session.setAttribute("userId", userId);

				return "login";

			} else {

				String message = "password and repassword must be same...";
				session.setAttribute("message", message);
				return "LoginInfo";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/*******************************
	 * LOGIN (USER)
	 ***************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "LoginCheck", method = RequestMethod.POST)

	public String CheckUser(@RequestParam("uname") String uname, @RequestParam("pass") String pass) {

		// authenticating the user with username and password.
		try {
			Login login = service.validateUser(uname, pass);

			if (login != null) {
				if (login.getUserType().equals("admin")) {
					session.setAttribute("login_info", login);
					return "admin_home";
				} else {
					session.setAttribute("account_info", service.getUserDetails(login.getAccountId()));
					session.setAttribute("login_info", login);
					return "user_home";
				}
			} else {

				return "login";
			}
		} catch (ObsException e) {

			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/***************************
	 * Forgot Password
	 *******************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPasswordValid(@RequestParam("accountid") Long accountid,
			@RequestParam("debitnumber") Long debitnumber, @RequestParam("cvv") int cvv) {

		// Validating the user account deatails in order to set a new password.
		try {
			Account account = service.getUserDetails(accountid);

			if (account != null) {

				if (debitnumber == account.getDebitNum() && cvv == account.getDebit_cvv()) {
					session.setAttribute("accountId", accountid);
					return "setpassword";

				} else {
					String errorMsg = "Invalid Debit Number or CVV Number";
					session.setAttribute("error", errorMsg);
					return "forgotpassword";
				}
			}

			else {
				String errorMsg = "Invalid Account number or there is no account in bank";
				session.setAttribute("error", errorMsg);
				return "forgotpassword";
			}
		} catch (ObsException e) {

			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

	@RequestMapping(value = "/SavePassword")
	public String setPassword(@RequestParam("newpassword") String password,
			@RequestParam("retypepassword") String repassword) {
		// updating the password of user after validating the user.
		try {
			if (password.equals(repassword)) {
				long accountId = (long) session.getAttribute("accountId");
				int count = service.setPassword(password, accountId);

				if (count > 0) {
					String message = "Password changed successfully";
					session.setAttribute("message", message);
					return "login";
				} else {
					String message = "Password is not changed. Try again...!!";
					session.setAttribute("message", message);
					return "login";
				}
			} else {
				String message = "Password and retype password must be same...";
				session.setAttribute("message", message);
				return "setpassword";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

	/******************************
	 * Change Password
	 ***********************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "/SaveChangedPassword", method = RequestMethod.POST)
	public String updatedPassword(@RequestParam("oldPwd") String oldPassword,
			@RequestParam("newPwd") String newPassword, @RequestParam("rpwd") String retypePassword, Model model) {

		// Prompting for old password and authenticating.
		try {
			Login login = (Login) session.getAttribute("login_info");
			long accountId = login.getAccountId();

			if (oldPassword.equals(login.getLoginPassword())) {

				if (newPassword.equals(retypePassword)) {

					// updating the password if the old password entered is correct.

					int rowCount = service.setPassword(newPassword, accountId);

					if (rowCount > 0) {
						String message = "Password successfully updated";
						session.setAttribute("message", message);

						return "login";
					} else {
						return "ChangePassword";
					}
				} else {
					return "ChangePassword";
				}
			} else {

				return "ChangePassword";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

	/*******************************
	 * MINI/Detailed STATEMENT
	 ***************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "/miniStatement", method = RequestMethod.GET)
	public String ministatement(Model model) {

		// Displaying the last 10 transactions of user account.
		try {
			Login login = (Login) session.getAttribute("login_info");
			long accountId = login.getAccountId();
			List<Transaction> miniList = service.miniStatement(accountId);

			model.addAttribute("miniList", miniList);
			return "ministatementInfo";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	@RequestMapping(value = "/showDetailedStatement")
	public String detailedStatement(@RequestParam("start") String from, @RequestParam("end") String to, Model model) {

		// Displaying the transactions of users account between user given duration.
		try {
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			Login login = (Login) session.getAttribute("login_info");

			long accountId = login.getAccountId();

			List<Transaction> detailedList = service.detailedStatement(LocalDate.parse(from, dt),
					LocalDate.parse(to, dt), accountId);

			model.addAttribute("detailedList", detailedList);

			return "DetailedInfo";

		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/****************************
	 * Transfer Fund
	 ******************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Deep Shah Date : 11/01/2016 Change
	 * Description : Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "addPayee", method = RequestMethod.POST)

	public String addPayee(@RequestParam("pname") String pname, @RequestParam("paccId") long paccId,
			@RequestParam("pifsc") String ifsc, Model model) {
		try {
			if (service.checkPayeeInBank(paccId)) {
				Login log = (Login) session.getAttribute("login_info");
				Payee p = new Payee();
				p.setAccount_id(log.getAccountId());
				p.setPayee_acc_no(paccId);
				p.setPayee_ifsc(ifsc);
				p.setPayee_name(pname);
				int row = service.insertPayee(p);
				if (row > 0) {
					model.addAttribute("add_success", true);
					return "addPayee";
				} else {
					return "";
				}

			} else {
				return "error";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	@RequestMapping(value = "showAllPayee", method = RequestMethod.GET)

	public String showAllPayee(Model model) {
		try {
			Login log = (Login) session.getAttribute("login_info");
			List<Payee> pList = service.getAllPayee(log.getAccountId());

			model.addAttribute("pList", pList);
			return "showPayee";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	@RequestMapping(value = "makePayment", method = RequestMethod.GET)

	public String makePayment(@RequestParam("radio") long pid, Model model) {
		try {
			Login log = (Login) session.getAttribute("login_info");
			Payee payee = service.getPayeeById(pid, log.getAccountId());

			model.addAttribute("payee", payee);
			return "fundTransferForm";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	@RequestMapping(value = "transferFund", method = RequestMethod.GET)

	public String fundTransfer(@RequestParam("amount") int amount, @RequestParam("pid") long pid, Model model) {
		try {
			Login log = (Login) session.getAttribute("login_info");
			Account acc = (Account) session.getAttribute("account_info");
			if (acc.getBalance() > amount) {

				service.updateBalance(amount, log.getAccountId());

				service.updateBalanceInPayee(pid, amount);
				FundTransfer ft = new FundTransfer();
				ft.setSourceId(log.getAccountId());
				ft.setDestId(pid);
				ft.setTamount(amount);
				service.addTransactions("done", "fund transfer", amount, log.getAccountId());
				service.insertFundTransfer(ft);
				session.setAttribute("account_info", service.getUserDetails(log.getAccountId()));
				model.addAttribute("transfer_success", true);
				return "showPayee";
			} else {
				return "error";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

	@RequestMapping(value = "viewTransactions", method = RequestMethod.GET)

	public String ViewTransactions(Model model) {
		try {
			Login log = (Login) session.getAttribute("login_info");
			List<FundTransfer> fList = service.getAllTransactionsById(log.getAccountId());

			model.addAttribute("fList", fList);
			return "viewAllOnlineTransaction";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/*********************************
	 * Cheque Book Request
	 *******************************************/
	/***************************************************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * Cheque book request helps in allowing the values from the user interface to
	 * the controller Version : 1.0 Restrictions : UserId must be valid
	 * Modifications : checking the method is working Author : Dharma Teja Masetty
	 * Date : 11/1/2016 Change Description : Author_Initials : Initial Version : 1.0
	 ********************************************************************************************************************************/

	@RequestMapping(value = "ChequeBookRequest", method = RequestMethod.GET)
	public String chequeRequest(Model model) {
		Account acc = (Account) session.getAttribute("account_info");

		model.addAttribute("details", acc);

		return "ChequeService";
	}

	@RequestMapping(value = "SaveChequeDetails")
	public String TrackRequest(Model model) {
		try {
			Login log = (Login) session.getAttribute("login_info");

			int trackid = service.showService(log.getAccountId());

			model.addAttribute("trackid", trackid);

			return "Service2";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/********************************
	 * Track Service request
	 ********************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * track service request helps in the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Dharma Teja Masetty Date : 11/1/2016
	 * Change Description : Author_Initials : Initial Version : 1.0
	 ************************************************************************************/
	@RequestMapping(value = "displayTracker")
	public String getTrackerService(@RequestParam("id") int serviceid, Model model) {

		// displaying the details of service request using the serviceTrackerId.
		try {
			Login log = (Login) session.getAttribute("login_info");
			ServiceTracker servicetracker = service.displayService(serviceid, log.getAccountId());

			model.addAttribute("servicetracker", servicetracker);

			return "Service3";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	@RequestMapping(value = "trackAllServices")
	public String getAllTrackerService(Model model) {
		try {
			Login log = (Login) session.getAttribute("login_info");
			long accountId = log.getAccountId();
			List<ServiceTracker> list = service.getAllTrackService(accountId);

			model.addAttribute("list", list);
			return "Service4";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/********************************
	 * Change user details
	 **********************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/
	@RequestMapping(value = "changeDetails")
	public String updateDetails(Model model) {

		// displaying the details of user and updating the changes made for address and
		// mobile number.

		Account account = (Account) session.getAttribute("account_info");

		model.addAttribute("details", account);

		return "changeUserDetials";
	}

	@RequestMapping(value = "saveDetails")
	public String saveUpdateDetails(@RequestParam("add1") String address, @RequestParam("phoneno") String phoneNum,
			Model model) {
		try {
			Login login = (Login) session.getAttribute("login_info");
			long accountId = login.getAccountId();
			Account account = new Account();
			account.setAccountId(accountId);
			account.setAddress(address);
			account.setPhone_no(phoneNum);

			if (service.updateDetails(account)) {
				account = service.getUserDetails(accountId);
				model.addAttribute("accountDetails", account);
				return "settings";
			} else {
				return "settings";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {

		session.invalidate();
		return "Home";
	}

	/***************************
	 * ADMIN
	 **********************************************/

	/**************************
	 * View All transactions
	 **********************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "/ViewAllTransaction", method = RequestMethod.GET)
	public String getAllTransactions(Model model) {

		// Displaying all the transactions of all accounts to admin.
		try {
			List<Transaction> allTransactionData = service.getAllTransactions();

			model.addAttribute("trList", allTransactionData);
			return "ViewAllTransactions";
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}
	}

	/**************************
	 * Create a new Account
	 ************************************************/
	/************************************************************************************
	 * File : Obscontroller.java Package : com.igate.obs.controller Description :
	 * registerUser helps in allowing the values from the user interface to the
	 * controller Version : 1.0 Restrictions : UserId must be valid Modifications :
	 * checking the method is working Author : Date : Change Description :
	 * Author_Initials : Initial Version : 1.0
	 ************************************************************************************/

	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public String addUser(@RequestParam("customer_name") String cname, @RequestParam("phone_no") long phoneNo,
			@RequestParam("email") String email, @RequestParam("address1") String address1,
			@RequestParam("address2") String address2, @RequestParam("pancard") String pancard,
			@RequestParam("dob") LocalDate dob, Model model) {

		System.out.println("Hi..");
		// Receiving the details of customer and creating a new account of customer.
		try {
			Customer customer = new Customer();
			customer.setCustomer_name(cname);
			customer.setPhone_no(phoneNo);
			customer.setEmail(email);
			customer.setAddress1(address1);
			customer.setAddress2(address2);
			customer.setPancard(pancard);
			customer.setDob(dob);
			System.out.println("Inside.!");
			int rowCount = service.saveCustomerData(customer);

			if (rowCount > 0) {
				String message = "Customer added successfully..";
				model.addAttribute("message", message);
				return "admin_home";
			} else {
				return "newAccount";
			}
		} catch (ObsException e) {
			session.setAttribute("error", e.getMessage());
			return "errorPage";
		}

	}

}
